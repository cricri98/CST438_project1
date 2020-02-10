//main activity gives the user the otion to create an account or to login to a pre-existing account
package com.example.cst438_project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);

        //start create account activity
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCreateAcc();
            }
        });

        //start login activity
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLogin();
            }
        });
    }

    void openCreateAcc(){
        Intent CAccount = new Intent(this, CreateAccount.class);
        startActivity(CAccount);
    }

    void openLogin(){
        Intent Login = new Intent(this, Login.class);
        startActivity(Login);
    }



}
