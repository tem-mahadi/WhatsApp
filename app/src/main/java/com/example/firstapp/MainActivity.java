package com.example.firstapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar; DrawerLayout drawerLayout; NavigationView navigationView;
    TextView t;
    ImageView setimg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navigation);
        View headerView = navigationView.getHeaderView(0);
        setimg = headerView.findViewById(R.id.setimg);
        t = headerView.findViewById(R.id.headerName);
        SharedPreferences sharedPref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        String USER_NAME = sharedPref.getString("username", null);

        t.setText("Hi "+USER_NAME+",\nWhat's Up?");
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open_drawer,R.string.close_drawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        loadFragment(new tab());
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.opt_marketplace) {
                    loadFragment(new frag_marketplace());
                } else if (id == R.id.opt_msgrq) {
                    loadFragment(new frag_request());
                } else if (id == R.id.chats) {
                    loadFragment(new tab());
                } else if(id== R.id.opt_archive){
                    loadFragment(new frag_archive());
                } else {
                    Intent intent= new Intent(getApplicationContext(), LoginPage2.class);
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putBoolean("next", false);
                    editor.apply();
                    startActivity(intent);
                    finish();
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

                setimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gallery= new Intent(Intent.ACTION_PICK);
                gallery.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(gallery,100);
            }
        });

    }

        @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode== RESULT_OK){
            if(requestCode==100){
                assert data != null;
                setimg.setImageURI(data.getData());
//                Bitmap bitmap = null;
//                try {
//                    bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), data.getData());
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                db.entityDao().updateImage(bitmap,USER_NAME);
            }
        }
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else super.onBackPressed();
    }

    private void loadFragment(Fragment fragment){
        FragmentTransaction ft= getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.container,fragment);
        ft.commit();
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