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

import static org.junit.Assert.*;
/*
    Tests the DAO operations
    author Christopher Jimenez
 */

public class GradeDAOTest {

    @Test
    public void insertGrade() {
        Context c = InstrumentationRegistry.getInstrumentation().getContext();
        StudentAppDatabase db = Room.inMemoryDatabaseBuilder(c, StudentAppDatabase.class).build();

        Random r = new Random();
        Grade test = new Grade(r.nextInt(), 70,r.nextInt(),r.nextInt(),r.nextInt(),"1/1/2020" );
        db.getGradeDAO().insertGrade(test);
        assertNotNull(db.getGradeDAO().getGradeById(test.getGradeId()));
    }

    @Test
    public void updateGrade() {
        Context c = InstrumentationRegistry.getInstrumentation().getContext();
        StudentAppDatabase db = Room.inMemoryDatabaseBuilder(c, StudentAppDatabase.class).build();

        Random r = new Random();
        Grade test = new Grade(r.nextInt(), 70,r.nextInt(),r.nextInt(),r.nextInt(),"1/1/2020" );
        db.getGradeDAO().insertGrade(test);
        assertNotNull(db.getGradeDAO().getGradeById(test.getGradeId()));

        db.getGradeDAO().deleteGrade(test);
        assertNull(db.getGradeDAO().getGradeById(test.getGradeId()));

        int test_update = r.nextInt();

        test.setScore(test_update);
        db.getGradeDAO().updateGrade(test);
        assertEquals(test_update,db.getGradeDAO().getGradeById(test.getGradeId()).getScore());
    }

    @Test
    public void deleteGrade() {
        Context c = InstrumentationRegistry.getInstrumentation().getContext();
        StudentAppDatabase db = Room.inMemoryDatabaseBuilder(c, StudentAppDatabase.class).build();

        Random r = new Random();
        Grade test = new Grade(r.nextInt(), 70,r.nextInt(),r.nextInt(),r.nextInt(),"1/1/2020" );
        db.getGradeDAO().insertGrade(test);
        assertNotNull(db.getGradeDAO().getGradeById(test.getGradeId()));

        db.getGradeDAO().deleteGrade(test);
        assertNull(db.getGradeDAO().getGradeById(test.getGradeId()));
    }
}