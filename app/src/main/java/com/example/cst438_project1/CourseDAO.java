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
    void insert(Enrollment... enrollments);

    @Update
    void update(Enrollment... enrollments);

    @Delete
    void delete(Enrollment enrollment);

    @Query("SELECT * FROM " + StudentAppDatabase.ENROLLMENT_TABLE)
    List<Course> getEnrollments();

    @Query("SELECT * FROM " + StudentAppDatabase.ENROLLMENT_TABLE + " WHERE mEnrollmentId = :enrollmentId")
    Course getEnrollmentById(int enrollmentId);

    @Query("SELECT * FROM " + StudentAppDatabase.ENROLLMENT_TABLE + " WHERE mStudentId = :studentId and WHERE mCourseId = :courseId")
    Course getEnrollmentByIds(int studentId, int courseId);
}

