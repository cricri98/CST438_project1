package com.example.cst438_project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class mainMenu extends AppCompatActivity {

    //done just have to link everything and do all that fun stuff
    Button coursesButton;
    Button assignmentsButton;
    Button accountButton;
    Button gradesButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        coursesButton = findViewById(R.id.viewCoursesButton);
        assignmentsButton = findViewById(R.id.viewAssignmentsButton);
        accountButton = findViewById(R.id.viewAccountButton);
        gradesButton = findViewById(R.id.viewGradesButton);

        coursesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCourseView();
            }
        });

        assignmentsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAssignmentView();
            }
        });

        accountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAccountView();
            }
        });

        gradesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGradesView();
            }
        });
    }

    public void openCourseView(){
        Intent i = new Intent(this, CourseViewerActivity.class);
        startActivity(i);
    }

    public void openAssignmentView(){
        Intent i = new Intent(this, ViewAssignmentActivity.class);
        startActivity(i);
    }

    public void openAccountView(){
        Intent i = new Intent(this, AccountActivity.class);
        startActivity(i);
    }

    public void openGradesView(){
        Intent i = new Intent(this, ViewGradesActivity.class);
        startActivity(i);
    }
}
