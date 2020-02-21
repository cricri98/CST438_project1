package com.example.cst438_project1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cst438_project1.MainMenuAtivities.AccountActivity;
import com.example.cst438_project1.MainMenuAtivities.ViewCourses.CourseViewerActivity;
import com.example.cst438_project1.MainMenuAtivities.ViewAssignment.ViewAssignmentActivity;
import com.example.cst438_project1.MainMenuAtivities.ViewGradesActivity;

public class mainMenu extends AppCompatActivity {

    //done just have to link everything and do all that fun stuff
    Button coursesButton;
    Button assignmentsButton;
    Button accountButton;
    Button gradesButton;

    int userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        userId = getIntent().getIntExtra("userId", -1);

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
        i.putExtra("userId", userId);
        startActivity(i);
    }

    public void openAssignmentView(){
        Intent i = new Intent(this, ViewAssignmentActivity.class);
        i.putExtra("userId", userId);
        startActivity(i);
    }

    public void openAccountView(){
        Intent i = new Intent(this, AccountActivity.class);
        i.putExtra("userId", userId);
        startActivity(i);
    }

    public void openGradesView(){
        Intent i = new Intent(this, ViewGradesActivity.class);
        i.putExtra("userId", userId);
        startActivity(i);
    }
}
