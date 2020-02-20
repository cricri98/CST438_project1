package com.example.cst438_project1.MainMenuAtivities.ViewAssignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cst438_project1.DB.AssignmentDAO;
import com.example.cst438_project1.DB.StudentAppDatabase;
import com.example.cst438_project1.Objects.Assignment;
import com.example.cst438_project1.R;

import java.util.List;

public class editAssignment extends AppCompatActivity {

    StudentAppDatabase db;

    EditText mMaxScore;
    EditText mEarnedScore;

    Button enter;

    Integer savedAssignmentID;

    AssignmentDAO mAssignmentDAO;
    List<Assignment> assignments;

    float maxScore;
    float earnedScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_assignment);

        db = Room.databaseBuilder(getApplicationContext(), StudentAppDatabase.class, "db").allowMainThreadQueries().build();

        //receive the user key
        Intent intent = getIntent();
        savedAssignmentID = intent.getIntExtra("assignmentKey", 0);

        mMaxScore = findViewById(R.id.mS);
        mEarnedScore = findViewById(R.id.eS);

        enter = findViewById(R.id.enter);

        mAssignmentDAO = Room.databaseBuilder(this, StudentAppDatabase.class, StudentAppDatabase.AName)
                .allowMainThreadQueries()
                .build()
                .getAssignmentDAO();

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateAssignmentInfo();
            }
        });
    }

    public void updateAssignmentInfo(){
        //get editText values
        if(mMaxScore.getText().toString().trim().isEmpty() || mEarnedScore.getText().toString().trim().isEmpty()){
            Toast.makeText(getApplicationContext(), "Enter Missing Values", Toast.LENGTH_LONG).show();
            return;
        } else{
            maxScore = Float.valueOf(mMaxScore.getText().toString());
            earnedScore = Float.valueOf(mEarnedScore.getText().toString());
        }

        assignments = db.getAssignmentDAO().getAssignments();

            for(Assignment a: assignments){
                if(a.getAssignmentID() == savedAssignmentID){
                    //update assignment values
                    db.getAssignmentDAO().updateUser(savedAssignmentID, maxScore, earnedScore);
                    Toast.makeText(getApplicationContext(), "Values Have Been Updated", Toast.LENGTH_LONG).show();
                    finish();
                }
            }

    }
}
