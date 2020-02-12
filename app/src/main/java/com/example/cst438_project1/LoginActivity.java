package com.example.cst438_project1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

public class LoginActivity extends AppCompatActivity {
    StudentAppDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        database = Room.databaseBuilder(this, StudentAppDatabase.class, "database").build();

        final EditText username = findViewById(R.id.username);
        final EditText password = findViewById(R.id.password);
        final Button login = findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String name = username.getText().toString();
                String pass = password.getText().toString();
                User[] user = database.getUserDao().getUserbyName(name);
                for (User u:user){
                    if (u.isPassword(pass)){
                        currentUser.set(u);
                        finish();
                    }
                }
            }
        });

    }
}
