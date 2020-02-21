package com.example.cst438_project1.MainMenuAtivities.ViewCourses;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cst438_project1.DB.StudentAppDatabase;
import com.example.cst438_project1.Objects.Course;
import com.example.cst438_project1.R;

import java.util.Date;

public class CourseAdderActivity extends AppCompatActivity {

    StudentAppDatabase db;

    EditText addCourseName;
    EditText addCourseStartDate;
    EditText addCourseEndDate;
    EditText addCourseDesc;
    EditText addCourseSize;

    Button addCourseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_adder);

        db = Room.databaseBuilder(getApplicationContext(), StudentAppDatabase.class, "db").allowMainThreadQueries().build();

        addCourseName = findViewById(R.id.addCourseNameText);
        addCourseStartDate = findViewById(R.id.addCourseStartDate);
        addCourseEndDate = findViewById(R.id.addCourseEndDate);
        addCourseDesc = findViewById(R.id.addCourseDesc);
        addCourseSize = findViewById(R.id.addCourseMaxSize);

        addCourseButton = findViewById(R.id.addCourseButton);

        addCourseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startCourseAdd();
            }
        });
    }

    void startCourseAdd(){
        Date startDate = stringToDate(addCourseStartDate.getText().toString());
        Date endDate = stringToDate(addCourseEndDate.getText().toString());

        String name = addCourseName.getText().toString();
        String desc = addCourseDesc.getText().toString();

        int size = Integer.parseInt(addCourseSize.getText().toString());

        Course newCourse = new Course(name, startDate, endDate, desc, size);

        for(Course c : db.getCourseDAO().getCourses()){
            if(c.getCourseName().equals(newCourse.getCourseName())){
                Toast toast=Toast.makeText(getApplicationContext(),"Course name already taken",Toast.LENGTH_LONG);
                toast.show();

                return;
            }
        }
        db.getCourseDAO().insert(newCourse);

        onBackPressed();
    }

    Date stringToDate(String passedS){
        String[] sArr = passedS.split("/");
        int[] iArr = new int[3];

        for(int i = 0; i < 3; i++){
            iArr[i] = Integer.parseInt(sArr[i]);
        }

        return new Date(iArr[2], iArr[0], iArr[1]);
    };

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent i = new Intent(this, CourseViewerActivity.class);
        i.putExtra("userId", getIntent().getIntExtra("userId", -1));
        startActivity(i);

        finish();
    }


}
