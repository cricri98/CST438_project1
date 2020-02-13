package com.example.cst438_project1.DB;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.cst438_project1.Objects.Assignment;
import com.example.cst438_project1.Objects.Course;
import com.example.cst438_project1.Objects.GradeCategory;
import com.example.cst438_project1.Objects.User;

@Database(entities = {GradeCategory.class, Assignment.class, User.class, Course.class}, version =1)
public abstract class StudentAppDatabase extends RoomDatabase {
    //grade category
    public static final String GCName = "db-gradecategory";
    public static final String GRADECATEGORY_TABLE = "gradecategory";

    //assignment
    public static final String AName = "db-assignment";
    public static final String ASSIGNMENT_TABLE = "assignment";

    public static final String UserName ="db-user";
    public static final String USER_TABLE ="user";

    public static final String CourseName ="db-course";
    public static final String COURSE_TABLE ="course";

    public abstract GradeCategoryDAO getGradeCategoryDAO();
    public abstract AssignmentDAO getAssignmentDAO();
    abstract public UserDAO getUserDao();
    abstract public CourseDAO getCourseDAO();
}
