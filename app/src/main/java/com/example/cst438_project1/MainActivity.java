package com.example.cst438_project1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.app.Application;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.cst438_project1.DB.AppDatabase;
import com.example.cst438_project1.DB.AssignmentDAO;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    AssignmentDAO mAssignmentDAO;
    TextView mainDisplay;

    List<Assignment> mAssignments;

    EditText mDetails;
    EditText mMaxScore;
    EditText mEarnedScore;
    EditText mAssignedDate;
    EditText mDueDate;
    EditText mCategoryID;
    EditText mCourseID;
    EditText mAssignmentID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);
        mainDisplay = findViewById(R.id.textViewMain);

        mDetails = findViewById(R.id.text);
        mMaxScore = findViewById(R.id.text2);
        mEarnedScore = findViewById(R.id.text3);
        mAssignedDate = findViewById(R.id.text4);
        mDueDate = findViewById(R.id.text5);
        mCategoryID = findViewById(R.id.text6);
        mCourseID = findViewById(R.id.text7);
        mAssignmentID = findViewById(R.id.text8);

        mAssignmentDAO = Room.databaseBuilder(this, AppDatabase.class, AppDatabase.AName)
                .allowMainThreadQueries()
                .build()
                .getAssignmentDAO();

        refreshDisplay();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enter();
                refreshDisplay();
            }
        });
    }

    public void enter(){
        String details = mDetails.getText().toString();
        String assignedDate = mAssignedDate.getText().toString();
        String dueDate = mDueDate.getText().toString();

        int categoryID = Integer.parseInt(mCategoryID.getText().toString());
        int courseID = Integer.parseInt(mCourseID.getText().toString());
        int assignmentID = Integer.parseInt(mAssignmentID.getText().toString());

        float maxScore = Float.valueOf(mMaxScore.getText().toString());
        float earnedScore = Float.valueOf(mEarnedScore.getText().toString());

        mAssignmentDAO.insert(new Assignment(details, maxScore, earnedScore,
                assignedDate, dueDate, categoryID, courseID, assignmentID));
    }

    public void refreshDisplay(){
        mAssignments = mAssignmentDAO.getAssignments();

        if(! mAssignments.isEmpty()){
            StringBuilder stringBuilder = new StringBuilder();
            for(Assignment acc: mAssignments){
                stringBuilder.append(acc.toString());
            }
            mainDisplay.setText(stringBuilder.toString());
        } else {
            mainDisplay.setText("No Assignments Available");
        }
    }

}
