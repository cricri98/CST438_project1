package com.example.cst438_project1.DB;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.cst438_project1.Objects.User;

import java.util.List;

@Dao
public interface UserDAO {

    @Query("Select * from User WHERE ID = :id")
    User getUserById(int id);

    @Query("Select * from User")
    User[] getAll();

    @Query("Select * from User WHERE username = :username")
    User getUserByUsername(String username);

    @Update
    void updateUser(User... users);

    @Insert
    void insertUser(User... users);

    @Delete
    void deleteUser(User... users);

    @Query("DELETE FROM " + StudentAppDatabase.COURSE_TABLE)
    void nuke();
}
