package com.example.cst438_project1.DB;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.cst438_project1.Objects.Course;

import java.util.List;

@Dao
public interface CourseDAO {
    @Insert
    void insert(Course... courses);

    @Update
    void update(Course... courses);

    @Delete
    void delete(Course course);

    @Query("SELECT * FROM " + StudentAppDatabase.COURSE_TABLE)
    List<Course> getCourses();

    @Query("SELECT * FROM " + StudentAppDatabase.COURSE_TABLE + " WHERE mCourseId = :courseId")
    Course getCourseById(int courseId);

    @Query("SELECT * FROM " + StudentAppDatabase.COURSE_TABLE + " WHERE `course-name` = :courseName")
    Course getCourseByName(String courseName);

    @Query("DELETE FROM " + StudentAppDatabase.COURSE_TABLE)
    void nuke();
}

