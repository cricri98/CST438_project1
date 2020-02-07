package com.example.cst438_project1;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.Date;
import java.util.List;

@Dao
public interface EnrollmentDAO {
    @Insert
    void insert(Enrollment... enrollments);

    @Update
    void update(Enrollment... enrollments);

    @Delete
    void delete(Enrollment enrollment);

    @Query("SELECT * FROM " + StudentAppDatabase.ENROLLMENT_TABLE)
    List<Enrollment> getEnrollments();

    @Query("SELECT * FROM " + StudentAppDatabase.ENROLLMENT_TABLE + " WHERE mEnrollmentId = :enrollmentId")
    Enrollment getEnrollmentById(int enrollmentId);

    @Query("SELECT * FROM " + StudentAppDatabase.ENROLLMENT_TABLE + " WHERE mStudentId = :studentId and mCourseId = :courseId")
    List<Enrollment> getEnrollmentByIds(int studentId, int courseId);

    @Query("SELECT * FROM " + StudentAppDatabase.ENROLLMENT_TABLE + " WHERE mDate = :date")
    List<Enrollment> getEnrollmentByDate(Date date);


}

