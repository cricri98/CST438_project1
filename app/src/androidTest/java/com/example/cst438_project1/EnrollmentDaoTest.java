package com.example.cst438_project1;

import android.content.Context;

import androidx.room.Room;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Test;

import java.util.Date;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/*Checks that DAO operations for User work.
 *@author Joshua Click
 */
public class EnrollmentDaoTest {
    /*Checks that Course can be created and saved to Room
     */
    @Test
    public void EnrollmentCreate(){
        Context c = InstrumentationRegistry.getInstrumentation().getContext();
        StudentAppDatabase db = Room.inMemoryDatabaseBuilder(c, StudentAppDatabase.class).build();

        Random r = new Random();

        Date d = new Date(2020, 10, 10);

        Course testCourse = new Course("Test", r.nextInt(), "1/1/2020", "2/2/2020", "blah blah");
        db.getCourseDAO().insert(testCourse);
        testCourse = db.getCourseDAO().getCourseByName(testCourse.getCourseName());

        User testUser = new User("Jim bo", "notAPassword");
        db.getUserDao().insertUser(testUser);
        testUser = db.getUserDao().getUserByName(testUser.getName());

        Enrollment e = new Enrollment(testUser.getID(), testCourse.getCourseId(), d);

        db.getEnrollmentDAO().insert(e);

        assertNotNull(db.getEnrollmentDAO().getEnrollmentByIds(testUser.getID(), testCourse.getCourseId()));
    }
    /*Checks that Course can be deleted from Room
     */
    @Test
    public void EnrollmentDelete(){
        Context c = InstrumentationRegistry.getInstrumentation().getContext();
        StudentAppDatabase db = Room.inMemoryDatabaseBuilder(c, StudentAppDatabase.class).build();

        Random r = new Random();

        Date d = new Date(2020, 10, 10);

        Course testCourse = new Course("Test", r.nextInt(), "1/1/2020", "2/2/2020", "blah blah");
        db.getCourseDAO().insert(testCourse);
        testCourse = db.getCourseDAO().getCourseByName(testCourse.getCourseName());

        User testUser = new User("Jim bo", "notAPassword");
        db.getUserDao().insertUser(testUser);
        testUser = db.getUserDao().getUserByName(testUser.getName());

        Enrollment e = new Enrollment(testUser.getID(), testCourse.getCourseId(), d);

        db.getEnrollmentDAO().insert(e);

        e = db.getEnrollmentDAO().getEnrollmentByDate(d).get(0);

        db.getEnrollmentDAO().delete(e);

        assertNull(db.getEnrollmentDAO().getEnrollmentById(e.getEnrollmentId()));

    }
    /*Checks that Course can be updated in Room
     */
    @Test
    public void EnrollmentUpdate(){
        ontext c = InstrumentationRegistry.getInstrumentation().getContext();
        StudentAppDatabase db = Room.inMemoryDatabaseBuilder(c, StudentAppDatabase.class).build();

        Random r = new Random();

        Date d = new Date(2020, 10, 10);

        Course testCourse = new Course("Test", r.nextInt(), "1/1/2020", "2/2/2020", "blah blah");
        db.getCourseDAO().insert(testCourse);
        testCourse = db.getCourseDAO().getCourseByName(testCourse.getCourseName());

        User testUser = new User("Jim bo", "notAPassword");
        db.getUserDao().insertUser(testUser);
        testUser = db.getUserDao().getUserByName(testUser.getName());

        Enrollment e = new Enrollment(testUser.getID(), testCourse.getCourseId(), d);

        db.getEnrollmentDAO().insert(e);

        e = db.getEnrollmentDAO().getEnrollmentByDate(d).get(0);

        String name = "new name";

        e.s
    }
}
