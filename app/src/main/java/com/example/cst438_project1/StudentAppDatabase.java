package com.example.cst438_project1;


import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(version = 1, entities = {User.class, Course.class})
public abstract class StudentAppDatabase extends RoomDatabase {
    public static final String UserName ="db-user";
    public static final String USER_TABLE ="user";

    public static final String CourseName ="db-course";
    public static final String COURSE_TABLE ="course";

    abstract public UserDAO getUserDao();
    abstract public CourseDAO getCourseDAO();
}

