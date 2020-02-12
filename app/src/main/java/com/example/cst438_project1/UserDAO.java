package com.example.cst438_project1;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao

public interface UserDAO {

    @Query("Select * from User WHERE ID = :id")
    User[] getUser(int id);

    @Query("Select * from " + StudentAppDatabase.USER_TABLE + " WHERE name = :name")
    User getUserByName(String name);

    @Update
    void updateUser(User... users);
    @Insert
    void insertUser(User... users);

    @Delete
    void deleteUser(User... users);
}
