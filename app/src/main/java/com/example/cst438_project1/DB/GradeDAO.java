package com.example.cst438_project1.DB;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.cst438_project1.Objects.Grade;

@Dao
public interface GradeDAO {
    @Insert
    void insertGrade(Grade... grade);

    @Update
    void updateGrade(Grade... grade);

    @Delete
    void deleteGrade(Grade... grade);

    @Query("SELECT * FROM " + StudentAppDatabase.GRADE_TABLE + " WHERE mGradeId = :gradeId")
    Grade getGradeById(int gradeId);

    @Query("SELECT * FROM " + StudentAppDatabase.GRADE_TABLE + " WHERE mStudentId = :studentId AND mAssignementId = :assignmentId")
    Grade getGradeByStudentAssignmentId(int studentId, int assignmentId);
}
