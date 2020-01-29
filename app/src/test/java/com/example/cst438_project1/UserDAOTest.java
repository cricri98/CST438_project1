package com.example.cst438_project1;

import android.content.Context;

import androidx.room.Room;

import org.junit.Test;

import java.nio.charset.Charset;
import java.util.Random;

import static org.junit.Assert.*;

public class UserDAOTest {
    /*Checks that User can be created and saved to Room
     **No params
     */
    @Test
    public void UserCreate(){
        StudentAppDatabase db = Room.databaseBuilder(this, StudentAppDatabase.class, StudentAppDatabase.UserName).build();
        User test = new User();
        db.getUserDao().insertUser(test);
        assertNotNull( db.getUserDao().getUser(test.getID()));

        db = null;
    }
    /*Checks that User can be deleted from Room
    **No params
     */
    @Test
    public void UserDelete(){
        User test = new User();
        db.UserDAO.insertUser(test);
        assertNotNull(db.UserDAO.getUser(test.getID()));

        db.UserDAO.deleteUser(test);
        assertNull(db.UserDAO.getUser(test.getID()));
    }
    /*Checks that User can be updated in Room
     **No params
     */
    @Test
    public void UserUpdate(){
        User test = new User();
        db.UserDAO.insertUser(test);
        assertNotNull(db.UserDAO.getUser(test.getID()));

        //Generate a random string/"name"
        Random r = new Random();
        byte[] b = new byte[10];
        r.nextBytes(b);
        String name = new String(b, Charset.defaultCharset());
        assertEquals(10, name.length());

        test.setName(name);
        db.UserDAO.updateUser(test);
        assertTrue(db.UserDAO.getUser(test.getID()).getName() == name);
    }
}
