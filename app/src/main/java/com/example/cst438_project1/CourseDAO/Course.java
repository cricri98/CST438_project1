package com.example.cst438_project1.CourseDAO;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Course{
    @PrimaryKey(autoGenerate = true)
    private int mCourseId;

    @ColumnInfo(name = "course-name")
    private String mCourseName;

    private int mInstructorId;

    //formatted like mmddyyyy
    private String mStartDate;
    private String mEndDate;

    private String mDescription;

    public Course(String courseName, int instructorId, String startDate, String endDate, String description) {
        mCourseName = courseName;
        mInstructorId = instructorId;
        mStartDate = startDate;
        mEndDate = endDate;
        mDescription = description;
    }

    public int getCourseId() {
        return mCourseId;
    }

    public void setCourseId(int courseId) {
        mCourseId = courseId;
    }

    public String getCourseName() {
        return mCourseName;
    }

    public void setCourseName(String courseName) {
        mCourseName = courseName;
    }

    public int getInstructorId() {
        return mInstructorId;
    }

    public void setInstructorId(int instructorId) {
        mInstructorId = instructorId;
    }

    public String getStartDate() {
        return mStartDate;
    }

    public void setStartDate(String startDate) {
        mStartDate = startDate;
    }

    public String getEndDate() {
        return mEndDate;
    }

    public void setEndDate(String endDate) {
        mEndDate = endDate;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }
}
