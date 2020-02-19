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
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);

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


        //delete this this is just so that it goes to the main menu
//        startActivity(new Intent(this, mainMenu.class));
    }

    void openCreateAcc(){
        Intent i = new Intent(this, CreateAccount.class);
        startActivity(i);
    }

    void openLogin(){
        Intent i = new Intent(this, Login.class);
        startActivity(i);
    }



}
