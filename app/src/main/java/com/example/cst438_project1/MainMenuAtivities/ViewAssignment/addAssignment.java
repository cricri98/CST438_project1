package com.example.cst438_project1.MainMenuAtivities.ViewAssignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.cst438_project1.DB.StudentAppDatabase;
import com.example.cst438_project1.Objects.Assignment;
import com.example.cst438_project1.Objects.Course;
import com.example.cst438_project1.Objects.User;
import com.example.cst438_project1.R;

import java.util.ArrayList;
import java.util.List;

public class addAssignment extends AppCompatActivity {

    StudentAppDatabase db;

    EditText mDetails;
    EditText mAssignedDate;
    EditText mDueDate;
    Spinner mCourseID;
    EditText mMaxScore;
    EditText mEarnedScore;

    Button enter;

    int userId;
    int courseId;

    List<String> courseNames = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_assignment);

        db = Room.databaseBuilder(getApplicationContext(), StudentAppDatabase.class, "db").allowMainThreadQueries().build();

        mDetails = findViewById(R.id.a);
        mAssignedDate = findViewById(R.id.b);
        mDueDate = findViewById(R.id.c);
        mCourseID = findViewById(R.id.e);
        mMaxScore = findViewById(R.id.f);
        mEarnedScore = findViewById(R.id.g);

        userId = getIntent().getIntExtra("userId", -1);
        courseId = getIntent().getIntExtra("courseId", -1);

        enter = findViewById(R.id.h);

        setCourseNames();
        setSpinner();

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enterAssignmentInfo();
            }
        });

    }

    //enters assignment info assuming all editText are in
    public void enterAssignmentInfo(){
        String details = mDetails.getText().toString();
        float maxScore = Float.valueOf(mMaxScore.getText().toString());
        float earnedScore = Float.valueOf(mEarnedScore.getText().toString());

        //formatted like mmddyyyy
        String assignedDate = mAssignedDate.getText().toString();
        String dueDate = mDueDate.getText().toString();

        String courseName = mCourseID.getSelectedItem().toString();

        Integer courseID = db.getCourseDAO().getCourseByName(courseName).getCourseId();


        Assignment a = new Assignment(details, maxScore, earnedScore, assignedDate, dueDate, userId, courseID);

        db.getAssignmentDAO().insert(a);
        Toast.makeText(getApplicationContext(), "Assignment Created", Toast.LENGTH_LONG).show();



        finish();
    }

    void setCourseNames(){
        if(courseId != -1){
            courseNames.add(db.getCourseDAO().getCourseById(courseId).getCourseName());
        }else {
            List<Course> courseList = db.getCourseDAO().getCourses();

            for (Course c : courseList) {
                if(c.getStudentIds().contains(userId)) {
                    courseNames.add(c.getCourseName());
                }
            }
            if(courseNames.size() == 0){
                Toast.makeText(getApplicationContext(), "You aren't enrolled in any classes", Toast.LENGTH_LONG).show();
                onBackPressed();
            }
        }
    }

    void setSpinner(){

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, courseNames);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mCourseID.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent i = new Intent(this, ViewAssignmentActivity.class);
        i.putExtra("userId", userId);
        i.putExtra("courseName", db.getCourseDAO().getCourseById(courseId).getCourseName());
        startActivity(i);
        finish();
    }
}
