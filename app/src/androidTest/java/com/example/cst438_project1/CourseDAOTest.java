package com.example.cst438_project1;

import android.content.Context;

import androidx.room.Room;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Test;

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
        Course test = new Course("Test", r.nextInt(), "1/1/2020", "2/2/2020", "blah blah");
        db.getCourseDAO().insert(test);
        assertNotNull( db.getCourseDAO().getCourseByName(test.getCourseName()));
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
        assertNotNull( db.getCourseDAO().getCourseByName(test.getCourseName()));

        Course temp = db.getCourseDAO().getCourseByName(test.getCourseName());

        db.getCourseDAO().delete(temp);
        assertNull(db.getCourseDAO().getCourseByName(temp.getCourseName()));
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
        assertNotNull( db.getCourseDAO().getCourseByName(test.getCourseName()));

        Course temp = db.getCourseDAO().getCourseByName(test.getCourseName());

//        //Generate a random string/"name"
//        byte[] b = new byte[10];
//        new Random().nextBytes(b);
//        String name = new String(b, Charset.forName("UTF-8"));

        String name = "new name";

        temp.setCourseName(name);
        db.getCourseDAO().update(temp);
        assertEquals(name, db.getCourseDAO().getCourseByName(name).getCourseName());
    }
}
