package com.example.cst438_project1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.cst438_project1.DB.StudentAppDatabase;
import com.example.cst438_project1.Objects.User;

public class Login extends AppCompatActivity {

    StudentAppDatabase db;

    EditText usernameField;
    EditText passwordField;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = Room.databaseBuilder(getApplicationContext(), StudentAppDatabase.class, "db").allowMainThreadQueries().build();

        usernameField = findViewById(R.id.usernameFieldLog);
        passwordField = findViewById(R.id.passwordFieldLog);
        loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tryLogin();
            }
        });

//        usernameField.setText("user1");
//        passwordField.setText("pass");
//        tryLogin();
    }

    void tryLogin(){
        String username = usernameField.getText().toString().trim();
        String password = passwordField.getText().toString().trim();

        if(username.equals("") || password.equals("")){
            Toast.makeText(getApplicationContext(), R.string.aboveIsEmpty, Toast.LENGTH_LONG).show();
        }else {
            try{
                User u = db.getUserDao().getUserByUsername(username);
                if (u.getPassword().equals(password)) {
                    Intent i = new Intent(this, mainMenu.class);
                    i.putExtra("userId", u.getID());
                    startActivity(i);
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), R.string.logError, Toast.LENGTH_LONG).show();
                }
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), R.string.logError, Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }
}
