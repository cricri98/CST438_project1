package com.example.cst438_project1.MainMenuAtivities.ViewCourses;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.cst438_project1.DB.StudentAppDatabase;
import com.example.cst438_project1.Objects.Course;
import com.example.cst438_project1.Objects.User;
import com.example.cst438_project1.R;

import java.util.ArrayList;
import java.util.List;

public class CourseViewerActivity extends AppCompatActivity {

    StudentAppDatabase db;

    private ArrayList<String> mCourseNames = new ArrayList<>();
    private ArrayList<String> mCourseDesc = new ArrayList<>();
    private ArrayList<String> mCourseGrades = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_viewer);

        db = Room.databaseBuilder(getApplicationContext(), StudentAppDatabase.class, "db").allowMainThreadQueries().build();

        initLists();
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
        RecyclerView recyclerView = findViewById(R.id.CourseViewRecycler);
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
