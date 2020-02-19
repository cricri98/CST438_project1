package com.example.cst438_project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class mainMenu extends AppCompatActivity {

    //done just have to link everything and do all that fun stuff
    Button viewCoursesButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        viewCoursesButton = findViewById(R.id.viewCoursesButton);

        viewCoursesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCourseView();
            }
        });
    }

    public void openCourseView(){
        Intent i = new Intent(this, CourseViewerActivity.class);
        startActivity(i);
    }
}
