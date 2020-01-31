package com.example.cst438_project1;

import android.app.Application;
import android.content.Context;
import android.content.pm.InstrumentationInfo;

import androidx.room.Room;

import org.junit.Test;

import java.nio.charset.Charset;
import java.util.Random;
import androidx.test.platform.app.InstrumentationRegistry;

import static org.junit.Assert.*;

/*Checks that DAO operations for User work.
 *@author Joshua Click
 */
public class UserDAOTest{
    /*Checks that User can be created and saved to Room
     */
    @Test
    public void UserCreate(){
        Context c = InstrumentationRegistry.getInstrumentation().getContext();
        StudentAppDatabase db = Room.inMemoryDatabaseBuilder(c, StudentAppDatabase.class).build();

        User test = new User();
        db.getUserDao().insertUser(test);
        assertNotNull( db.getUserDao().getUser(test.getID()));
    }
    /*Checks that User can be deleted from Room
     */
    @Test
    public void UserDelete(){
        Context c = InstrumentationRegistry.getInstrumentation().getContext();
        StudentAppDatabase db = Room.inMemoryDatabaseBuilder(c, StudentAppDatabase.class).build();

        User test = new User();
        db.getUserDao().insertUser(test);
        assertNotNull(db.getUserDao().getUser(test.getID()));

        db.getUserDao().deleteUser(test);
        assertEquals(0, db.getUserDao().getUser(test.getID()).length);
    }
    /*Checks that User can be updated in Room
     */
    @Test
    public void UserUpdate(){
        Context c = InstrumentationRegistry.getInstrumentation().getContext();
        StudentAppDatabase db = Room.inMemoryDatabaseBuilder(c, StudentAppDatabase.class).build();

        User test = new User();
        db.getUserDao().insertUser(test);
        assertNotNull(db.getUserDao().getUser(test.getID()));

        //Generate a random string/"name"
        Random r = new Random();
        byte[] b = new byte[10];
        r.nextBytes(b);
        String name = new String(b, Charset.forName("UTF-8"));
        assertEquals(10, name.length());

        test.setName(name);
        db.getUserDao().updateUser(test);
        assertEquals(name, db.getUserDao().getUser(test.getID())[0].getName());
    }
}
