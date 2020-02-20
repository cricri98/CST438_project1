package com.example.cst438_project1.Objects;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity
public class Course{
    @PrimaryKey(autoGenerate = true)
    private int mCourseId;

    @ColumnInfo(name = "course-name")
    private String mCourseName;

    private int mInstructorId;

    private Date mStartDate;
    private Date mEndDate;

    private String mDescription;

    private int[] mStudentIds;
    private int mMaxSize;

    public Course(String courseName, int instructorId, Date startDate, Date endDate, String description, int maxSize) {
        mCourseName = courseName;
        mInstructorId = instructorId;
        mStartDate = startDate;
        mEndDate = endDate;
        mDescription = description;
        mMaxSize = maxSize;
        mStudentIds = new int[maxSize];
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

    public Date getStartDate() {
        return mStartDate;
    }

    public void setStartDate(Date startDate) {
        mStartDate = startDate;
    }

    public Date getEndDate() {
        return mEndDate;
    }

    public void setEndDate(Date endDate) {
        mEndDate = endDate;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public int[] getStudentIds() {
        return mStudentIds;
    }

    public void setStudentIds(int[] studentIds) {
        mStudentIds = studentIds;
    }

    public int getMaxSize() {
        return mMaxSize;
    }

    public void setMaxSize(int maxSize) {
        mMaxSize = maxSize;
    }
}
