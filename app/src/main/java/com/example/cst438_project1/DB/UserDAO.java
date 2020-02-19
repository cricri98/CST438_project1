package com.example.cst438_project1.DB;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.cst438_project1.Objects.User;

@Dao
public interface UserDAO {

    @Query("Select * from User WHERE ID = :id")
    User getUser(int id);

    @Query("Select * from User WHERE name = :name")
    User getUser(String name);

    @Update
    void updateUser(User... users);
    @Insert
    void insertUser(User... users);

    @Delete
    void deleteUser(User... users);
}
