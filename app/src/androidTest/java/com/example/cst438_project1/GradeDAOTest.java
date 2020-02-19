package com.example.cst438_project1;
import android.content.Context;
import androidx.room.Room;
import androidx.test.platform.app.InstrumentationRegistry;


import com.example.cst438_project1.DB.StudentAppDatabase;
import com.example.cst438_project1.Objects.Grade;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
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
        Grade test = new Grade(70,r.nextInt(),r.nextInt(),r.nextInt(),"1/1/2020" );
        db.getGradeDAO().insertGrade(test);

        test = db.getGradeDAO().getGradeByStudentAssignmentId(test.getStudentId(), test.getAssignementId());

        assertNotNull(db.getGradeDAO().getGradeById(test.getGradeId()));
        assertNotNull(db.getGradeDAO().getGradeByStudentAssignmentId(test.getStudentId(), test.getAssignementId()));
    }

    @Test
    public void updateGrade() {
        Context c = InstrumentationRegistry.getInstrumentation().getContext();
        StudentAppDatabase db = Room.inMemoryDatabaseBuilder(c, StudentAppDatabase.class).build();

        Random r = new Random();
        Grade test = new Grade(70,r.nextInt(),r.nextInt(),r.nextInt(),"1/1/2020" );
        db.getGradeDAO().insertGrade(test);

        test = db.getGradeDAO().getGradeByStudentAssignmentId(test.getStudentId(), test.getAssignementId());

        assertNotNull(db.getGradeDAO().getGradeById(test.getGradeId()));

        int newScore = 90;

        test.setScore(newScore);
        db.getGradeDAO().updateGrade(test);
        assertEquals(newScore, db.getGradeDAO().getGradeById(test.getGradeId()).getScore());
    }

    @Test
    public void deleteGrade() {
        Context c = InstrumentationRegistry.getInstrumentation().getContext();
        StudentAppDatabase db = Room.inMemoryDatabaseBuilder(c, StudentAppDatabase.class).build();

        Random r = new Random();
        Grade test = new Grade(70,r.nextInt(),r.nextInt(),r.nextInt(),"1/1/2020" );
        db.getGradeDAO().insertGrade(test);

        test = db.getGradeDAO().getGradeByStudentAssignmentId(test.getStudentId(), test.getAssignementId());

        assertNotNull(db.getGradeDAO().getGradeById(test.getGradeId()));

        db.getGradeDAO().deleteGrade(test);
        assertNull(db.getGradeDAO().getGradeById(test.getGradeId()));
    }
}