package com.example.cst438_project1.MainMenuAtivities.ViewCourses;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cst438_project1.DB.StudentAppDatabase;
import com.example.cst438_project1.Objects.Course;
import com.example.cst438_project1.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CourseEditActivity extends AppCompatActivity {

    StudentAppDatabase db;

    TextView addCourseHeader;

    EditText addCourseName;
    EditText addCourseStartDate;
    EditText addCourseEndDate;
    EditText addCourseDesc;
    EditText addCourseSize;

    Button addCourseButton;

    Course c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_adder);

        db = Room.databaseBuilder(getApplicationContext(), StudentAppDatabase.class, "db").allowMainThreadQueries().build();

        c = db.getCourseDAO().getCourseById(getIntent().getIntExtra("courseId", -1));

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");

        addCourseHeader = findViewById(R.id.addCourseHeader);

        addCourseName = findViewById(R.id.addCourseNameText);
        addCourseStartDate = findViewById(R.id.addCourseStartDate);
        addCourseEndDate = findViewById(R.id.addCourseEndDate);
        addCourseDesc = findViewById(R.id.addCourseDesc);
        addCourseSize = findViewById(R.id.addCourseMaxSize);

        addCourseSize.setVisibility(View.GONE);

        addCourseButton = findViewById(R.id.addCourseButton);

        addCourseHeader.setText("Edit Course");
        addCourseButton.setText("Edit Course");

        addCourseName.setText(c.getCourseName());
        addCourseStartDate.setText(simpleDateFormat.format(c.getStartDate()));
        addCourseEndDate.setText(simpleDateFormat.format(c.getEndDate()));
        addCourseDesc.setText(c.getDescription());

        addCourseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startCourseEdit();
            }
        });
    }

    void startCourseEdit(){
        Date startDate = stringToDate(addCourseStartDate.getText().toString());
        Date endDate = stringToDate(addCourseEndDate.getText().toString());

        String name = addCourseName.getText().toString();
        String desc = addCourseDesc.getText().toString();

        c.setCourseName(name);
        c.setDescription(desc);
        c.setStartDate(startDate);
        c.setEndDate(endDate);

        for(Course cLoop : db.getCourseDAO().getCourses()){
            if(cLoop.getCourseName().equals(c.getCourseName()) && c.getCourseId() != cLoop.getCourseId()){
                Toast toast=Toast.makeText(getApplicationContext(),"Course name already taken",Toast.LENGTH_LONG);
                toast.show();

                return;
            }
        }
        db.getCourseDAO().update(c);

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