package com.example.cst438_project1.MainMenuAtivities.ViewAssignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cst438_project1.DB.StudentAppDatabase;
import com.example.cst438_project1.Objects.Assignment;
import com.example.cst438_project1.Objects.User;
import com.example.cst438_project1.R;

public class addAssignment extends AppCompatActivity {

    StudentAppDatabase db;

    EditText mDetails;
    EditText mAssignedDate;
    EditText mDueDate;
    EditText mCategoryID;
    EditText mCourseID;
    EditText mMaxScore;
    EditText mEarnedScore;

    Button enter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_assignment);

        db = Room.databaseBuilder(getApplicationContext(), StudentAppDatabase.class, "db").allowMainThreadQueries().build();

        mDetails = findViewById(R.id.a);
        mAssignedDate = findViewById(R.id.b);
        mDueDate = findViewById(R.id.c);
        mCategoryID = findViewById(R.id.d);
        mCourseID = findViewById(R.id.e);
        mMaxScore = findViewById(R.id.f);
        mEarnedScore = findViewById(R.id.g);

        enter = findViewById(R.id.h);

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

        Integer categoryID = Integer.parseInt(mCategoryID.getText().toString());
        Integer courseID = Integer.parseInt(mCourseID.getText().toString());

        Assignment a = new Assignment(details, maxScore, earnedScore, assignedDate, dueDate, categoryID, courseID);

        db.getAssignmentDAO().insert(a);
        Toast.makeText(getApplicationContext(), "Assignment Created", Toast.LENGTH_LONG).show();

        finish();
    }

}
