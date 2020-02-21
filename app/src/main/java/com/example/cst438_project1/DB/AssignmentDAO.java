package com.example.cst438_project1.DB;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.cst438_project1.Objects.Assignment;

import java.util.List;

@Dao
public interface AssignmentDAO {
    @Insert
    void insert(Assignment... assignments);

    @Update
    void update(Assignment...assignments);

    @Delete
    void delete(Assignment assignment);

    @Query("SELECT * FROM " + StudentAppDatabase.ASSIGNMENT_TABLE )
    List<Assignment> getAssignments();

    @Query("SELECT * FROM " + StudentAppDatabase.ASSIGNMENT_TABLE + " WHERE mDetails = :desc")
    List<Assignment> getAssignmentByDesc(String desc);

    @Query("SELECT * FROM " + StudentAppDatabase.ASSIGNMENT_TABLE + " WHERE mAssignmentID = :assignmentId")
    Assignment getAssignmentById(Integer assignmentId);

    @Query("SELECT * FROM " + StudentAppDatabase.ASSIGNMENT_TABLE + " WHERE mCourseID = :courseId")
    List<Assignment> getAssignmentByCourse(Integer courseId);

    @Query("UPDATE Assignment SET mMaxScore =:maxScore ,mEarnedScore=:earnedScore WHERE mAssignmentID =:assignmentId")
    void updateUser(Integer assignmentId,float maxScore, float earnedScore);
}
