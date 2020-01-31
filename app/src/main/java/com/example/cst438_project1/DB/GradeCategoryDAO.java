package com.example.cst438_project1.DB;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.cst438_project1.GradeCategory;

import java.util.List;

@Dao
public interface GradeCategoryDAO {
    @Insert
    void insert(GradeCategory... gradeCategories);

    @Update
    void update(GradeCategory...gradeCategories);

    @Delete
    void delete(GradeCategory gradeCategories);

    @Query("SELECT * FROM " + AppDatabase.GRADECATEGORY_TABLE )
    List<GradeCategory> getGradeCategories();
}
