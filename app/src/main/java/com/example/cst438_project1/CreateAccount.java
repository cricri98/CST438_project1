package com.example.cst438_project1;

import android.content.Intent;
import android.content.res.Resources;
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

public class CreateAccount extends AppCompatActivity {

    Button createAccountButton;

    TextView tempUsers;

    StudentAppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        db = Room.databaseBuilder(getApplicationContext(), StudentAppDatabase.class, "db").allowMainThreadQueries().build();

        createAccountButton = findViewById(R.id.createAccountButton);
        tempUsers = findViewById(R.id.tempUserView);


        //Enter account info and validate credentials
        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enterAccountInfo();
            }
        });

        updateTempText();

        tempUsers.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                for(User u : db.getUserDao().getAll()){
                    db.getUserDao().deleteUser(u);
                }
                updateTempText();
                return false;
            }
        });

    }

    private void updateTempText(){
        String temp = "";
        User[] users = db.getUserDao().getAll();

        for(User us : users){
            temp = temp + us + '\n';
        }
        tempUsers.setText(temp);
    }


    //checks to see if username is duplicate or invalid
    //has no constraints for username format, yet
    void enterAccountInfo(){
        //retrieve username and password
        EditText username = findViewById(R.id.usernameField);
        String savedUsername = username.getText().toString().trim();

        EditText name = findViewById(R.id.nameField);
        String savedName = name.getText().toString().trim();

        EditText password = findViewById(R.id.passwordField);
        String savedPassword = password.getText().toString().trim();

        if(savedUsername.equals("") || savedName.equals("") || savedPassword.equals("")){
            Toast.makeText(getApplicationContext(), R.string.aboveIsEmpty, Toast.LENGTH_LONG).show();
        }else {

            try {
                if (!(db.getUserDao().getUserByUsername(savedUsername) instanceof User)) {
                    User u = new User(savedUsername, savedName, savedPassword);

                    db.getUserDao().insertUser(u);

                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), R.string.usernameError, Toast.LENGTH_LONG).show();
                }
            } catch (Resources.NotFoundException e) {
                Toast.makeText(getApplicationContext(), R.string.usernameError, Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}