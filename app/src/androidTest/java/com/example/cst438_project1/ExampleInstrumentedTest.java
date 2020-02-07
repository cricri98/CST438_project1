package com.example.cst438_project1;

import android.content.Context;

import androidx.room.Room;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.cst438_project1.DB.AppDatabase;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        assertEquals("com.example.cst438_project1", appContext.getPackageName());
    }

    /*Checks that Assignment can be created using Room
     */
    @Test
    public void AssignmentCreate(){
        Context c = InstrumentationRegistry.getInstrumentation().getContext();
        AppDatabase db = Room.inMemoryDatabaseBuilder(c, AppDatabase.class).build();

        Random r = new Random();
        Assignment test = new Assignment("ie1", r.nextFloat(), r.nextFloat(), "ie2",
                "ie3", r.nextInt(), r.nextInt(), r.nextInt());

        db.getAssignmentDAO().insert(test);
        assertNotNull( db.getAssignmentDAO().getAssignmentById(test.getAssignmentID()));
    }

    /*Checks that Assignment can be deleted from Room
     */
    @Test
    public void AssignmentDelete(){
        Context c = InstrumentationRegistry.getInstrumentation().getContext();
        AppDatabase db = Room.inMemoryDatabaseBuilder(c, AppDatabase.class).build();

        Random r = new Random();
        Assignment test = new Assignment("ie1", r.nextFloat(), r.nextFloat(), "ie2",
                "ie3", r.nextInt(), r.nextInt(), r.nextInt());

        db.getAssignmentDAO().insert(test);
        assertNotNull( db.getAssignmentDAO().getAssignmentById(test.getAssignmentID()));

        db.getAssignmentDAO().delete(test);
        assertNotNull( db.getAssignmentDAO().getAssignmentById(test.getAssignmentID()));
    }

    /*Checks that GradeCategory can be created using Room
     */
    @Test
    public void GradeCategoryCreate(){
        Context c = InstrumentationRegistry.getInstrumentation().getContext();
        AppDatabase db = Room.inMemoryDatabaseBuilder(c, AppDatabase.class).build();

        Random r = new Random();
        GradeCategory test = new GradeCategory("ie", r.nextInt(), r.nextInt(), r.nextInt());

        db.getGradeCategoryDAO().insert(test);
        assertNotNull( db.getGradeCategoryDAO().getGradeCategorytById(test.getTitle()));
    }

    /*Checks that GradeCategory can be deleted from Room
     */
    @Test
    public void GradeCategoryDelete(){
        Context c = InstrumentationRegistry.getInstrumentation().getContext();
        AppDatabase db = Room.inMemoryDatabaseBuilder(c, AppDatabase.class).build();

        Random r = new Random();
        GradeCategory test = new GradeCategory("ie", r.nextInt(), r.nextInt(), r.nextInt());

        db.getGradeCategoryDAO().insert(test);
        assertNotNull( db.getGradeCategoryDAO().getGradeCategorytById(test.getTitle()));

        db.getGradeCategoryDAO().delete(test);
        assertNotNull( db.getGradeCategoryDAO().getGradeCategorytById(test.getTitle()));
    }

}
