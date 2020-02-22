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

import static java.sql.Types.NULL;

public class ViewAssignmentActivity extends AppCompatActivity {

    int userID;

    TextView mainDisplay;

    EditText assignmentIDET;

    AssignmentDAO mAssignmentDAO;
    List<Assignment> assignments;

    CourseDAO mCourseDAO;
    List<Course> courses;

    Button addButton;
    Button editButton;
    Button deleteButton;

    StudentAppDatabase db;

    Integer savedAssignmentID;

    Course c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_assignment);

        db = Room.databaseBuilder(getApplicationContext(), StudentAppDatabase.class, "db").allowMainThreadQueries().build();

        assignmentIDET = findViewById(R.id.assignmentID);

        //receive the user key
        userID = getIntent().getIntExtra("userId", -1);

        //receive the course
        c = db.getCourseDAO().getCourseByName(getIntent().getStringExtra("courseName"));

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
        if(c != null){
            assignments = db.getAssignmentDAO().getAssignmentByCourseAndUser(c.getCourseId(), userID);
        }else{
            assignments = db.getAssignmentDAO().getAssignmentByUser(userID);
        }
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

        //display all assignments with the courseID
        if(!assignments.isEmpty()){
            StringBuilder stringBuilder = new StringBuilder();
            for(Assignment a: assignments){
                stringBuilder.append(a.toString() + '\n');
            }
            mainDisplay.setText(stringBuilder.toString());
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("NO ASSIGNMENTS DUE");
            if(c != null) {
                stringBuilder.append(" FOR COURSE:" + c.getCourseName());
            }
            mainDisplay.setText(stringBuilder);
        }

    }

    public void addAssignment(){
        Intent intent = new Intent(this, addAssignment.class);
        intent.putExtra("userId", userID);
        if(c != null) {
            intent.putExtra("courseId", c.getCourseId());
        }
        startActivity(intent);
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
