package com.example.firstapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager= findViewById(R.id.viewpager);
        TabLayout tabLayout=findViewById(R.id.tab);
        toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        whatsAppAdapter adapter= new whatsAppAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.opt_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemID= item.getItemId();

        if(itemID == R.id.camera) {
            AlertDialog.Builder alertDialog= new AlertDialog.Builder(this);
            alertDialog.setTitle("Camera");
            alertDialog.setIcon(android.R.drawable.ic_menu_camera);
            alertDialog.setMessage("Wanna Take Your Picture?");
            alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(MainActivity.this,"Are You Cute?",Toast.LENGTH_SHORT).show();
                }
            });
            alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(MainActivity.this,"You're Beautiful",Toast.LENGTH_SHORT).show();
                }
            });
            alertDialog.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
           alertDialog.show();
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