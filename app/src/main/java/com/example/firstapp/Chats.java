package com.example.firstapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class Chats extends Fragment {
    RecyclerView recyclerView; MyDB db;
    public Chats() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_chats, container, false);
        recyclerView = view.findViewById(R.id.recview);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        db = MyDB.getDB(requireContext());
        List<Entity2> users = db.entityDao().getAllUsers();
        recyclerAdapter ra= new recyclerAdapter(users);
        recyclerView.setAdapter(ra);
        return view;
    }
}