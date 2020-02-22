//Assignment Object
    //o Details
    //o Max Score
    //o Earned Score
    //o Assigned date
    //o Due date
    //o CategoryID
    //o CourseID
    //o AssignmentID

package com.example.cst438_project1.Objects;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.cst438_project1.DB.StudentAppDatabase;

@Entity(tableName = StudentAppDatabase.ASSIGNMENT_TABLE)
public class Assignment {

    //unique ID?
    @PrimaryKey
    private Integer mAssignmentID;

    private String mDetails;
    private float mMaxScore;
    private float mEarnedScore;

    //formatted like mmddyyyy
    private String mAssignedDate;
    private String mDueDate;

    private Integer mUserId;
    private Integer mCourseID;

    public Assignment(String details, float maxScore, float earnedScore, String assignedDate,
                      String dueDate, Integer userId, Integer courseID) {
        mDetails = details;
        mMaxScore = maxScore;
        mEarnedScore = earnedScore;
        mAssignedDate = assignedDate;
        mDueDate = dueDate;
        mUserId = userId;
        mCourseID = courseID;
    }

    public String getDetails() {
        return mDetails;
    }

    public void setDetails(String mDetails) {
        this.mDetails = mDetails;
    }

    public float getMaxScore() {
        return mMaxScore;
    }

    public void setMaxScore(float mMaxScore) {
        this.mMaxScore = mMaxScore;
    }

    public float getEarnedScore() {
        return mEarnedScore;
    }

    public void setEarnedScore(float mEarnedScore) {
        this.mEarnedScore = mEarnedScore;
    }

    public String getAssignedDate() {
        return mAssignedDate;
    }

    public void setAssignedDate(String mAssignedDate) {
        this.mAssignedDate = mAssignedDate;
    }

    public String getDueDate() {
        return mDueDate;
    }

    public void setDueDate(String mDueDate) {
        this.mDueDate = mDueDate;
    }

    public Integer getUserId() {
        return mUserId;
    }

    public void setUserId(Integer userId) {
        mUserId = userId;
    }

    public Integer getCourseID() {
        return mCourseID;
    }

    public void setCourseID(Integer mCourseID) {
        this.mCourseID = mCourseID;
    }

    public Integer getAssignmentID() {
        return mAssignmentID;
    }

    public void setAssignmentID(Integer mAssignmentID) {
        this.mAssignmentID = mAssignmentID;
    }

    @Override
    public String toString() {
        return  "--------------------------------------------------------------------\n" +
                "Details: " + mDetails + "\n" +
                "Max Score: " + mMaxScore + " || Earned Score: " + mEarnedScore + "\n" +
                "Assigned Date: " + mAssignedDate + " || Due Date: " + mDueDate + "\n" + " || Course ID: " + mCourseID + " || Assignment ID: " + mAssignmentID + "\n";
    }


}
