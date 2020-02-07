package com.example.cst438_project1.DB;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.cst438_project1.Assignment;
import com.example.cst438_project1.GradeCategory;

import java.util.List;

@Dao
public interface AssignmentDAO {
    @Insert
    void insert(Assignment... assignments);

    @Update
    void update(Assignment...assignments);

    @Delete
    void delete(Assignment assignment);

    @Query("SELECT * FROM " + AppDatabase.ASSIGNMENT_TABLE )
    List<Assignment> getAssignments();

    @Query("SELECT * FROM " + AppDatabase.ASSIGNMENT_TABLE + " WHERE mAssignmentID = :assignmentId")
    List<Assignment> getAssignmentById(Integer assignmentId);
}
