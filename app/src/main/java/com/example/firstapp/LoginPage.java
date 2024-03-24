package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LoginPage extends AppCompatActivity {
    MyDB myDB; EntityDao entityDao;
    TextView username,password,signhint,already1;
    Button signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        myDB= MyDB.getDB(this);
        username = findViewById(R.id.username);
        password= findViewById(R.id.password);
        signup= findViewById(R.id.signup);
        signhint= findViewById(R.id.signHint);
        already1= findViewById(R.id.already1);


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(check()){
                    Entity2 newUser = new Entity2(0,usernm,pass);
                    myDB.entityDao().insert(newUser);
                    Toast.makeText(LoginPage.this,"Sign Up Successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginPage.this, LoginPage2.class);
                    startActivity(intent);
                    finish();
                }else
                    Toast.makeText(LoginPage.this,"Unique Username Required", Toast.LENGTH_SHORT).show();
                username.setText("");
                password.setText("");
             }
        });

        already1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginPage2.class);
                startActivity(intent);
                finish();
            }
        });

    }
    String usernm,pass;
    public boolean check(){
        boolean flag=false;
        usernm = username.getText().toString();
        pass= password.getText().toString();
        if(!usernm.isEmpty() && !pass.isEmpty()){
            if(myDB.entityDao().is_taken(usernm)){
                signhint.setText("Username is Taken");
            }
            else
                flag=true;
        }
        else
            signhint.setText("Complete the fields");
        return flag;
    }

}