package com.example.cst438_project1.MainMenuAtivities.ViewAssignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.cst438_project1.DB.AssignmentDAO;
import com.example.cst438_project1.DB.StudentAppDatabase;
import com.example.cst438_project1.MainMenuAtivities.ViewAssignment.addAssignment;
import com.example.cst438_project1.Objects.Assignment;
import com.example.cst438_project1.R;

import java.util.List;

public class ViewAssignmentActivity extends AppCompatActivity {

    //recieve the user key
    TextView mainDisplay;

    AssignmentDAO mAssignmentDAO;
    List<Assignment> assignments;

    Button addButton;
    Button editButton;
    Button deleteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_assignment);

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

    public void addAssignment(){
        Intent aA = new Intent(this, addAssignment.class);
        //pass user key
//        aA.putExtra();
        startActivity(aA);
        finish();
    }

    public void editAssignment(){
        Intent eA = new Intent(this, editAssignment.class);
        //pass user key
//        eA.putExtra();
        //pass assignment key
//        eA.putExtra();
        startActivity(eA);
        finish();
    }

    public void deleteAssignment(){
        Intent dA = new Intent(this, deleteAssignment.class);
        //pass user key
//        dA.putExtra();
        //pass assignment key
//        dA.putExtra();
        startActivity(dA);
        finish();
    }

}
