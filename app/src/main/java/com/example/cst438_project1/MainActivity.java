//main activity gives the user the otion to create an account or to login to a pre-existing account
package com.example.cst438_project1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.cst438_project1.DB.StudentAppDatabase;
import com.example.cst438_project1.Objects.Course;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    StudentAppDatabase db;

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

        db = Room.databaseBuilder(getApplicationContext(), StudentAppDatabase.class, "db").allowMainThreadQueries().build();

        //delete this this is just so that it goes to the main menu
//        startActivity(new Intent(this, mainMenu.class));

        //putting in dummy courses until we can add them through the app
        db.getCourseDAO().nuke();
        addCourses(10);
    }

    private void addCourses(int size){
        for(int i = 0; i < size; i++){
            Course c = new Course("Course" + i, 0000, new Date(2020, 1, 1), new Date(2020, 5, 21),
                                "This is the " + i + " course", 15);

            db.getCourseDAO().insert(c);
        }

    }

    void openCreateAcc(){
        Intent i = new Intent(this, CreateAccount.class);
        startActivity(i);
    }

    void openLogin(){
        Intent i = new Intent(this, Login.class);
        startActivity(i);
        finish();
    }



}
