package com.example.cst438_project1;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.cst438_project1.Course;

import java.util.List;

@Dao
public interface CourseDAO {
    @Insert
    void insert(Course... courses);

    @Update
    void update(Course... courses);

    @Delete
    void delete(Course course);

    @Query("SELECT * FROM course")
    List<Course> getCourses();

    @Query("SELECT * FROM course WHERE mCourseId = :courseId")
    Course getCourseById(int courseId);
}

