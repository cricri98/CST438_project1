package com.example.cst438_project1;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = StudentAppDatabase.ENROLLMENT_TABLE)
public class Enrollment{

    @PrimaryKey(autoGenerate = true)
    private int mEnrollmentId;

    private int mStudentId;
    private int mCourseId;

    private Date mDate;
}
