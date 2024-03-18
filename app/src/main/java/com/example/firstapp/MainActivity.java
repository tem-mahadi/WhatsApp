package com.example.firstapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.opt_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemID= item.getItemId();
        if(itemID == R.id.camera) {
            Toast.makeText(this,"You're Beautiful",Toast.LENGTH_SHORT).show();
        }
        else if(itemID == R.id.settings) {
            Toast.makeText(this,"Settings off",Toast.LENGTH_SHORT).show();
        }
        else if(itemID == R.id.new_grp) {
            Toast.makeText(this,"New Group Coming",Toast.LENGTH_SHORT).show();
        }
        else if(itemID == R.id.search_bar) {
            Toast.makeText(this,"You Can seach Later",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this,"New Broadcast On",Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}