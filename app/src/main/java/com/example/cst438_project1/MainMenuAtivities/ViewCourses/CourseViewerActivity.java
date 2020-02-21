package com.example.cst438_project1.MainMenuAtivities.ViewCourses;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.cst438_project1.DB.StudentAppDatabase;
import com.example.cst438_project1.Objects.Course;
import com.example.cst438_project1.Objects.User;
import com.example.cst438_project1.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class CourseViewerActivity extends AppCompatActivity {

    StudentAppDatabase db;

    FloatingActionButton addCourseButton;

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

        u = db.getUserDao().getUserById(getIntent().getIntExtra("userId", -1));

        initLists();

        addCourseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addCourseOpen();
            }
        });

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0 && addCourseButton.getVisibility() == View.VISIBLE) {
                    addCourseButton.hide();
                } else if (dy < 0 && addCourseButton.getVisibility() != View.VISIBLE) {
                    addCourseButton.show();
                }
            }
        });
    }

    void addCourseOpen(){
        Intent i = new Intent(this, CourseAdderActivity.class);
        i.putExtra("userId", u.getID());
        startActivity(i);
        finish();
    }

    private void initLists(){
        for(Course c : db.getCourseDAO().getCourses()){
            mCourseNames.add(c.getCourseName());
            mCourseDesc.add(c.getDescription());
            mCourseGrades.add("N/A");
        }
        initRecyclerView();
    }

    private void initRecyclerView(){
        recyclerView = findViewById(R.id.CourseViewRecycler);
        CourseRecyclerViewAdapter adapter = new CourseRecyclerViewAdapter(mCourseNames, mCourseDesc, mCourseGrades, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
