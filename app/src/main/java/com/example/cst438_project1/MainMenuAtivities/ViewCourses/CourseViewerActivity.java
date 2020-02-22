package com.example.cst438_project1.MainMenuAtivities.ViewCourses;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.cst438_project1.DB.StudentAppDatabase;
import com.example.cst438_project1.MainMenuAtivities.ViewAssignment.ViewAssignmentActivity;
import com.example.cst438_project1.MainMenuAtivities.ViewAssignment.editAssignment;
import com.example.cst438_project1.Objects.Assignment;
import com.example.cst438_project1.Objects.Course;
import com.example.cst438_project1.Objects.User;
import com.example.cst438_project1.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class CourseViewerActivity extends AppCompatActivity {

    StudentAppDatabase db;

    FloatingActionButton addCourseButton;
    FloatingActionButton pickupCourseButton;

    User u;

    RecyclerView recyclerView;
    private ArrayList<String> mCourseNames = new ArrayList<>();
    private ArrayList<String> mCourseDesc = new ArrayList<>();
    private ArrayList<String> mCourseGrades = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_viewer);

        db = Room.databaseBuilder(getApplicationContext(), StudentAppDatabase.class, "db").allowMainThreadQueries().build();

        addCourseButton = findViewById(R.id.courseAddButton);
        pickupCourseButton = findViewById(R.id.pickupClassButton);

        u = db.getUserDao().getUserById(getIntent().getIntExtra("userId", -1));

        initLists();

        addCourseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addCourseOpen();
            }
        });

        pickupCourseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPickupClass();
                initLists();
            }
        });

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0 && addCourseButton.getVisibility() == View.VISIBLE) {
                    pickupCourseButton.hide();
                    addCourseButton.hide();
                } else if (dy < 0 && addCourseButton.getVisibility() != View.VISIBLE) {
                    pickupCourseButton.show();
                    addCourseButton.show();
                }
            }
        });
    }

    void openPickupClass(){
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(this);
        View mView = getLayoutInflater().inflate(R.layout.pickupspinner, null);
        mBuilder.setTitle("Pickup a class");
        final Spinner mSpinner = mView.findViewById(R.id.pickupCourseSpinner);

        List<String> courseNames = new ArrayList<>();
        List<Course> courseList = db.getCourseDAO().getCourses();

        for(Course c : courseList){
            if(!u.getCourseList().contains(c.getCourseId())) {
                courseNames.add(c.getCourseName());
            }
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, courseNames);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(adapter);

        mBuilder.setPositiveButton("Pickup", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                pickupClass(mSpinner.getSelectedItem().toString());
                dialogInterface.dismiss();
            }
        });

        mBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        mBuilder.setView(mView);
        AlertDialog dialog = mBuilder.create();
        dialog.show();

    }

    void pickupClass(String s){
        Course c = db.getCourseDAO().getCourseByName(s);
        if(c.getMaxSize() != c.getStudentIds().size()) {
            u.getCourseList().add(c.getCourseId());
            c.getStudentIds().add(u.getID());

            db.getUserDao().updateUser(u);
            db.getCourseDAO().update(c);

            initLists();
        }else{
            Toast.makeText(this, "Class is full", Toast.LENGTH_LONG).show();
            return;
        }
    }

    void addCourseOpen(){
        Intent i = new Intent(this, CourseAdderActivity.class);
        i.putExtra("userId", u.getID());
        startActivity(i);
        finish();
    }

    private void initLists(){
        mCourseGrades = new ArrayList<>();
        mCourseNames = new ArrayList<>();
        mCourseDesc = new ArrayList<>();
        for(Course c : db.getCourseDAO().getCourses()){
            int avg = 0, maxAvg = 0;
            if(u.getCourseList().contains(c.getCourseId())) {
                mCourseNames.add(c.getCourseName());
                mCourseDesc.add(c.getDescription());
                for(Assignment a : db.getAssignmentDAO().getAssignmentByCourseAndUser(c.getCourseId(), u.getID())){
                    avg += a.getEarnedScore();
                    maxAvg += a.getMaxScore();
                }
                if(maxAvg == 0) {
                    mCourseGrades.add("N/A");
                }else{
                    DecimalFormat df2 = new DecimalFormat("#.##");
                    double average = (Double.valueOf(avg) / Double.valueOf(maxAvg) * 100);
                    mCourseGrades.add(df2.format(average));
                }
            }
        }
        initRecyclerView();
    }

    private void initRecyclerView(){
        recyclerView = findViewById(R.id.CourseViewRecycler);
        CourseRecyclerViewAdapter adapter = new CourseRecyclerViewAdapter(mCourseNames, mCourseDesc, mCourseGrades, getIntent().getIntExtra("userId", -1),this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
