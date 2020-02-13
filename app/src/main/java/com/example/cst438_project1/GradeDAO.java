package com.example.cst438_project1;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface GradeDAO {
    @Insert
    void insertGrade(Grade... grade);

    @Update
    void updatGrade(Grade... grade);

    @Delete
    void deleteGrade(Grade... grade);

    @Query("SELECT * FROM grade WHERE mGradeId = :gradeId")
    Grade getGradeById(int gradeId);
}