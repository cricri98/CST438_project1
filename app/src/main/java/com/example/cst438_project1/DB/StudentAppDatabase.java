package com.example.cst438_project1.DB;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.cst438_project1.DB.TypeConverters.DateTypeConverter;
import com.example.cst438_project1.DB.TypeConverters.IntListTypeConverter;
import com.example.cst438_project1.Objects.Assignment;
import com.example.cst438_project1.Objects.Course;
import com.example.cst438_project1.Objects.Enrollment;
import com.example.cst438_project1.Objects.Grade;
import com.example.cst438_project1.Objects.GradeCategory;
import com.example.cst438_project1.Objects.User;

import java.io.Serializable;

@Database(entities = {GradeCategory.class, Assignment.class, User.class, Course.class, Enrollment.class, Grade.class}, version =1, exportSchema = false)
@TypeConverters({DateTypeConverter.class, IntListTypeConverter.class})
public abstract class StudentAppDatabase extends RoomDatabase implements Serializable{
    //grade category
    public static final String GCName = "db-gradecategory";
    public static final String GRADECATEGORY_TABLE = "gradecategory";

    //assignment
    public static final String AName = "db-assignment";
    public static final String ASSIGNMENT_TABLE = "assignment";

    //User
    public static final String UserName ="db-user";
    public static final String USER_TABLE ="user";

    //Course
    public static final String CourseName ="db-course";
    public static final String COURSE_TABLE ="course";

    //Enrollment
    public static final String EnrollmentName = "db-enrollment";
    public static final String ENROLLMENT_TABLE = "enrollment";

    //Grades
    public static final String GradeName ="db-grade";
    public static final String GRADE_TABLE ="grade";

    public abstract GradeCategoryDAO getGradeCategoryDAO();
    public abstract AssignmentDAO getAssignmentDAO();
    public abstract UserDAO getUserDao();
    public abstract CourseDAO getCourseDAO();
    public abstract EnrollmentDAO getEnrollmentDAO();
    public abstract GradeDAO getGradeDAO();
}
