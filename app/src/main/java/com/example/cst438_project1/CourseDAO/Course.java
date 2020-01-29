package com.example.cst438_project1.CourseDAO;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Course{
    @PrimaryKey
    public int courseId;

    @ColumnInfo(name = "course-name")
    public String courseName;
}
