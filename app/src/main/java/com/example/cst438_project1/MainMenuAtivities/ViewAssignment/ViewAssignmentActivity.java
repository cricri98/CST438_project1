package com.example.cst438_project1.MainMenuAtivities.ViewAssignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cst438_project1.DB.AssignmentDAO;
import com.example.cst438_project1.DB.CourseDAO;
import com.example.cst438_project1.DB.EnrollmentDAO;
import com.example.cst438_project1.DB.StudentAppDatabase;
import com.example.cst438_project1.MainMenuAtivities.ViewAssignment.addAssignment;
import com.example.cst438_project1.Objects.Assignment;
import com.example.cst438_project1.Objects.Course;
import com.example.cst438_project1.Objects.Enrollment;
import com.example.cst438_project1.R;

import java.util.ArrayList;
import java.util.List;

public class ViewAssignmentActivity extends AppCompatActivity {

    int userID;

    TextView mainDisplay;

    EditText assignmentIDET;

    AssignmentDAO mAssignmentDAO;
    List<Assignment> assignments;

    EnrollmentDAO mEnrollmentDAO;
    List<Enrollment> enrollments;

    CourseDAO mCourseDAO;
    List<Course> courses;

    Button addButton;
    Button editButton;
    Button deleteButton;

    StudentAppDatabase db;

    Integer savedAssignmentID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_assignment);

        db = Room.databaseBuilder(getApplicationContext(), StudentAppDatabase.class, "db").allowMainThreadQueries().build();

        assignmentIDET = findViewById(R.id.assignmentID);

        //receive the user key
        Intent intent = getIntent();
        userID = intent.getIntExtra("userId", 0);

        mainDisplay = findViewById(R.id.assignmentDisplay);
        mainDisplay.setMovementMethod(new ScrollingMovementMethod());

        addButton = (Button) findViewById(R.id.add);
        deleteButton = (Button) findViewById(R.id.delete);
        editButton = (Button) findViewById(R.id.edit);

        mAssignmentDAO = Room.databaseBuilder(this, StudentAppDatabase.class, StudentAppDatabase.AName)
                .allowMainThreadQueries()
                .build()
                .getAssignmentDAO();

        refreshDisplay();

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addAssignment();
            }
        });

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editAssignment();
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteAssignment();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    private void refreshDisplay(){
        assignments = db.getAssignmentDAO().getAssignments();
        enrollments = db.getEnrollmentDAO().getEnrollments();
        courses = db.getCourseDAO().getCourses();

        List<Integer> coursesEnrolledIn = new ArrayList<>();

//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append(userID);
//        mainDisplay.setText(stringBuilder.toString());

        //retrieve all the classes the current user is enrolled in
//        if(!enrollments.isEmpty()){
//            for(Enrollment e: enrollments){
//                if(e.getStudentId() == userID){
//                    coursesEnrolledIn.add(e.getCourseId());
//                }
//            }
//        }
//
//
//        //iterate through all the assignments and pull any of the ones that
//        // have courseID that match any of the courses the user is enrolled in
//        if(!assignments.isEmpty()){
//            StringBuilder stringBuilder = new StringBuilder();
//
//            for(Assignment a: assignments){
//                for(Integer cE: coursesEnrolledIn){
//                    if(a.getCourseID() == cE){
//                        stringBuilder.append(assignments.toString());
//                    }
//                }
//            }
//            mainDisplay.setText(stringBuilder.toString());
//        } else {
//            mainDisplay.setText("NO ASSIGNMENTS DUE");
//        }

        //for now list all of the assignments in the DB
        if(!assignments.isEmpty()){
            StringBuilder stringBuilder = new StringBuilder();
            for(Assignment a: assignments){
                    stringBuilder.append(a.toString());
                }
            mainDisplay.setText(stringBuilder.toString());
        } else {
            mainDisplay.setText("NO ASSIGNMENTS DUE");
        }

    }

    public void addAssignment(){
        Intent aA = new Intent(this, addAssignment.class);
        //pass user key
//        aA.putExtra();
        //pass course key
//        aA.putExtra();
        startActivity(aA);
        finish();
    }

    public void editAssignment(){
        if(assignmentIDET.getText().toString().trim().isEmpty()){
            Toast.makeText(getApplicationContext(), "Enter an Assignment ID to Edit", Toast.LENGTH_LONG).show();
            return;
        } else{
            savedAssignmentID = Integer.parseInt(assignmentIDET.getText().toString());
        }

        //search for assignment
        if(!assignments.isEmpty()){
            for(Assignment a: assignments){
                if(a.getAssignmentID() == savedAssignmentID){
                    Intent dA = new Intent(this, editAssignment.class);
                    //pass user key
                    // dA.putExtra();

                    //pass assignment key
                    dA.putExtra("assignmentKey", savedAssignmentID);
                    startActivity(dA);
                    finish();
                    return;
                }
            }
            Toast.makeText(getApplicationContext(), "Invalid assignment ID", Toast.LENGTH_LONG).show();
        }
    }

    public void deleteAssignment(){
        if(assignmentIDET.getText().toString().trim().isEmpty()){
            Toast.makeText(getApplicationContext(), "Enter an Assignment ID to Delete", Toast.LENGTH_LONG).show();
            return;
        } else{
            savedAssignmentID = Integer.parseInt(assignmentIDET.getText().toString());
        }

        //search for assignment
        if(!assignments.isEmpty()){
            for(Assignment a: assignments){
                if(a.getAssignmentID() == savedAssignmentID){
//                    Intent dA = new Intent(this, deleteAssignment.class);
//                    //pass user key
//                    // dA.putExtra();
//
//                    //pass assignment key
//                    dA.putExtra("assignmentKey", savedAssignmentID);
//                    startActivity(dA);
                    //delete assignment
                    db.getAssignmentDAO().delete(a);
                    Toast.makeText(getApplicationContext(), "Assignment #" + savedAssignmentID + " deleted", Toast.LENGTH_LONG).show();
                    refreshDisplay();
                    return;
                }
            }
            Toast.makeText(getApplicationContext(), "Invalid assignment ID", Toast.LENGTH_LONG).show();
        }
    }

}
