package com.example.cst438_project1;

import android.content.Context;

import androidx.room.Room;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Test;

import java.nio.charset.Charset;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/*Checks that DAO operations for User work.
 *@author Joshua Click
 */
public class CourseDAOTest {
    /*Checks that Course can be created and saved to Room
     */
    @Test
    public void CourseCreate(){
        Context c = InstrumentationRegistry.getInstrumentation().getContext();
        StudentAppDatabase db = Room.inMemoryDatabaseBuilder(c, StudentAppDatabase.class).build();

        Random r = new Random();
        int Iid = r.nextInt();
        Course test = new Course("Test", Iid, "1/1/2020", "2/2/2020", "blah blah");
        db.getCourseDAO().insert(test);
        assertNotNull( db.getCourseDAO().getCourseById(test.getCourseId()));
    }
    /*Checks that Course can be deleted from Room
     */
    @Test
    public void CourseDelete(){
        Context c = InstrumentationRegistry.getInstrumentation().getContext();
        StudentAppDatabase db = Room.inMemoryDatabaseBuilder(c, StudentAppDatabase.class).build();

        Random r = new Random();
        Course test = new Course("Test", r.nextInt(), "1/1/2020", "2/2/2020", "blah blah");
        db.getCourseDAO().insert(test);
        assertNotNull( db.getCourseDAO().getCourseById(test.getCourseId()));

        db.getCourseDAO().delete(test);
        assertNull(db.getCourseDAO().getCourseById(test.getCourseId()));
    }
    /*Checks that Course can be updated in Room
     */
    @Test
    public void CourseUpdate(){
        Context c = InstrumentationRegistry.getInstrumentation().getContext();
        StudentAppDatabase db = Room.inMemoryDatabaseBuilder(c, StudentAppDatabase.class).build();

        Random r = new Random();
        Course test = new Course("Test", r.nextInt(), "1/1/2020", "2/2/2020", "blah blah");
        db.getCourseDAO().insert(test);
        assertNotNull( db.getCourseDAO().getCourseById(test.getCourseId()));

        db.getCourseDAO().delete(test);
        assertNull(db.getCourseDAO().getCourseById(test.getCourseId()));

        //Generate a random string/"name"
        byte[] b = new byte[10];
        r.nextBytes(b);
        String name = new String(b, Charset.forName("UTF-8"));
        assertEquals(10, name.length());

        test.setCourseName(name);
        db.getCourseDAO().update(test);
        assertEquals(name, db.getUserDao().getUser(test.getCourseId())[0].getName());
    }
}
