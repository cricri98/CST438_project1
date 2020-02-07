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


    public Enrollment(int studentId, int courseId, Date date) {
        mStudentId = studentId;
        mCourseId = courseId;
        mDate = date;
    }

    public int getEnrollmentId() {
        return mEnrollmentId;
    }

    public void setEnrollmentId(int enrollmentId) {
        mEnrollmentId = enrollmentId;
    }

    public int getStudentId() {
        return mStudentId;
    }

    public void setStudentId(int studentId) {
        mStudentId = studentId;
    }

    public int getCourseId() {
        return mCourseId;
    }

    public void setCourseId(int courseId) {
        mCourseId = courseId;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }
}
