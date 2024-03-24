package com.example.firstapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.room.Entity;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;

public class tab extends Fragment {
    ViewPager viewPager;
    TabLayout tabLayout;

    public tab() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab, container, false);
        viewPager= view.findViewById(R.id.viewpager);
        tabLayout= view.findViewById(R.id.tab);

        whatsAppAdapter adapter= new whatsAppAdapter(getChildFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }
}