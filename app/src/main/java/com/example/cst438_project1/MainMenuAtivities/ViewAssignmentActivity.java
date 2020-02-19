package com.example.cst438_project1.MainMenuAtivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.example.cst438_project1.DB.AssignmentDAO;
import com.example.cst438_project1.DB.StudentAppDatabase;
import com.example.cst438_project1.Objects.Assignment;
import com.example.cst438_project1.R;

import java.util.List;

public class ViewAssignmentActivity extends AppCompatActivity {

    TextView mainDisplay;

    AssignmentDAO mAssignmentDAO;
    List<Assignment> assignments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_assignment);

        mainDisplay = findViewById(R.id.assignmentDisplay);
        mainDisplay.setMovementMethod(new ScrollingMovementMethod());

        mAssignmentDAO = Room.databaseBuilder(this, StudentAppDatabase.class, StudentAppDatabase.AName)
                .allowMainThreadQueries()
                .build()
                .getAssignmentDAO();

        refreshDisplay();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    private void refreshDisplay(){
        assignments = mAssignmentDAO.getAssignments();

        if(!assignments.isEmpty()){
            StringBuilder stringBuilder = new StringBuilder();

            for(Assignment a: assignments){
                stringBuilder.append(assignments.toString());
            }

            mainDisplay.setText(stringBuilder.toString());
        } else {
            mainDisplay.setText("NO ASSIGNMENTS DUE");
        }
    }
}
