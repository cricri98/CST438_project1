package com.example.cst438_project1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class CreateAccount extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.buttonCA);

        //Enter account info and validate credentials
        button.setOnClickListener(new View.OnClickListener() {
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
