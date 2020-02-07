package com.example.cst438_project1;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao

public interface UserDAO {

    @Query("Select * from User WHERE ID = :id")
    User[] getUserbyID(int id);
    @Query("Select * from User Where name = :name")
    User[] getUserbyName(String name);

    @Update
    void updateUser(User... users);
    @Insert
    void insertUser(User... users);

    @Delete
    void deleteUser(User... users);
}
