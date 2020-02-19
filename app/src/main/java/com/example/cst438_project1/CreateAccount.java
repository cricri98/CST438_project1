package com.example.cst438_project1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class CreateAccount extends AppCompatActivity {

    Button createAccountButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        createAccountButton = findViewById(R.id.createAccountButton);

        //Enter account info and validate credentials
        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enterAccountInfo();
            }
        });

    }

    //checks to see if username is duplicate or invalid
    //has no constraints for username format, yet
    void enterAccountInfo(){
        //retrieve username and password
        EditText username = findViewById(R.id.usernameText);
        String savedUsername = username.getText().toString();

        EditText password = findViewById(R.id.passwordText);
        String savedPassword = password.getText().toString();


        //check if credentials are in the database already
        //that includes the preset accounts
        //set a boolean for this "duplicateAcc"

        boolean duplicateAcc = false;

    }
}