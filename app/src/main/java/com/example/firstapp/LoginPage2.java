package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LoginPage2 extends AppCompatActivity {
    MyDB myDB; EntityDao entityDao;
    TextView username,password,signhint,already1;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page2);

        SharedPreferences sharedPref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        if (sharedPref.getBoolean("next", false)) {
            // If the user is already logged in, start MainActivity and finish LoginActivity
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
            return; // Exit onCreate to prevent further execution
        }

        myDB= MyDB.getDB(this);
        username = findViewById(R.id.username);
        password= findViewById(R.id.password);
        login= findViewById(R.id.login);
        signhint= findViewById(R.id.signHint);
        already1= findViewById(R.id.already1);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(check()){
                    Intent intent = new Intent(LoginPage2.this,MainActivity.class);
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putString("username", usernm);
                    editor.putBoolean("next", true);
                    editor.apply();
                    startActivity(intent);
                    finish();
                } else
                    Toast.makeText(getApplicationContext(), "Invalid Password", Toast.LENGTH_SHORT).show();
                password.setText("");
            }
        });

        already1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginPage.class);
                startActivity(intent);
                finish();
            }
        });

    }
    String usernm,pass;
    public boolean check(){
        boolean isAllowed= false;
        usernm = username.getText().toString();
        pass= password.getText().toString();
        if(!usernm.isEmpty() && !pass.isEmpty()){
            if(myDB.entityDao().is_exist(usernm,pass)){
                isAllowed= true;
            }
            else
                signhint.setText("rewrite the username(if mistyped)");
        }
        else
            signhint.setText("Complete the fields");
        return isAllowed;
    }
}