package com.example.cst438_project1.CourseDAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CourseDAO {
    @Insert
    void insert(Course... courses);

    @Update
    void update(Course... courses);

    @Delete
    void delete(Course Course);

    @Query("SELECT * FROM " + AppDatabase.COURSE_TABLE)
    List<Course> getCourses();

    @Query("SELECT * FROM " + AppDatabase.COURSE_TABLE + " WHERE mCourseId = :courseId")
    Course getCourseById(int courseId);

    @Query("SELECT * FROM " + AppDatabase.COURSE_TABLE + " WHERE mCourseId = :courseId")
    Course getCourseById(int courseId);
}

