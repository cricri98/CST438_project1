package com.example.cst438_project1.MainMenuAtivities;

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
import com.example.cst438_project1.R;

public class EditAccountActivity extends AppCompatActivity {

    Button saveAccountButton;

    StudentAppDatabase db;

    int userId;
    User currentUser;

    EditText username;
    EditText name;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_account);
        db = Room.databaseBuilder(getApplicationContext(), StudentAppDatabase.class, "db").allowMainThreadQueries().build();

        saveAccountButton = findViewById(R.id.save_account);
        //tempUsers = findViewById(R.id.tempUserView);

        userId = getIntent().getIntExtra("userId", -1);
        currentUser = db.getUserDao().getUserById(userId);

        username = findViewById(R.id.edit_usernameText);
        name = findViewById(R.id.edit_nameText);
        password = findViewById(R.id.edit_passwordText);


        //Enter account info and validate credentials
        saveAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enterAccountInfo();
            }
        });

        populate();
    }

    //checks to see if username is duplicate or invalid
    //has no constraints for username format, yet
    void enterAccountInfo(){
        //retrieve username and password
        String savedUsername = username.getText().toString().trim();
        String savedName = name.getText().toString().trim();
        String savedPassword = password.getText().toString().trim();

        if(savedUsername.equals("") || savedName.equals("") || savedPassword.equals("")){
            Toast.makeText(getApplicationContext(), R.string.aboveIsEmpty, Toast.LENGTH_LONG).show();
        }else {

            try {
                currentUser.setName(savedName);
                currentUser.setUsername(savedUsername);
                currentUser.setPassword(savedPassword);

                db.getUserDao().updateUser(currentUser);

                finish();
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

    public void populate(){
        if (currentUser != null) {
            username.setText(currentUser.getUsername());
            name.setText(currentUser.getName());
            password.setText(currentUser.getPassword());
        }
    }
}