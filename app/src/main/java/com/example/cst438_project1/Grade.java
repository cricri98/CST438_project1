package com.example.cst438_project1;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/*

 */
@Entity
public class Grade {
    @PrimaryKey(autoGenerate = true)
    private int mGradeId;

    // ColumnInfo name??
    //@ColumnInfo
    private int mScore;

    private int mAssignementId;

    private int mStudentId;

    private int mCourseId;

    //formatted  mmddyyyy
    private String mDateEarned;

    public Grade(int gradeId, int score, int assignementId, int studentId, int courseId, String dateEarned){
        this.mGradeId = gradeId;
        this.mScore = score;
        this.mAssignementId = assignementId;
        this.mStudentId = studentId;
        this.mCourseId = courseId;
        this.mDateEarned = dateEarned;
    }

    public int getGradeId() { return mGradeId; }
    public void setGradeId(int GradeId) { this.mGradeId = GradeId; }

    public int getScore() { return mScore; }
    public void setScore(int Score) { this.mScore = Score; }

    public int getAssignementId() { return mAssignementId; }
    public void setAssignementId(int mAssignementId) { this.mAssignementId = mAssignementId; }

    public int getStudentId() { return mStudentId; }
    public void setStudentId(int mStudentId) { this.mStudentId = mStudentId; }

    public int getCourseId() { return mCourseId; }
    public void setCourseId(int mCourseId) { this.mCourseId = mCourseId;}


   // public void setAssignementId(int mAssignementId) { this.mAssignementId = mAssignementId; }

    public String getDateEarned(){ return mDateEarned; }

    public void setDateEarned(String dateEarned) { mDateEarned = dateEarned; }
}
