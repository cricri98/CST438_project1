package com.example.cst438_project1.DB;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.cst438_project1.GradeCategory;

@Database(entities = {GradeCategory.class}, version =1)
public abstract class AppDatabase extends RoomDatabase {
    public static final String GCName = "db-gradecategory";
    public static final String GRADECATEGORY_TABLE = "gradecategory";

    public abstract GradeCategoryDAO getGradeCategoryDAO();
}
