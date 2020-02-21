package com.example.cst438_project1;

import android.content.Context;

import androidx.room.Room;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.cst438_project1.DB.StudentAppDatabase;
import com.example.cst438_project1.Objects.Assignment;
import com.example.cst438_project1.Objects.GradeCategory;

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
public class AssignmentDAOTest {
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
        StudentAppDatabase db = Room.inMemoryDatabaseBuilder(c, StudentAppDatabase.class).build();

        Random r = new Random();

        String assignDesc = "ie1";

        Assignment test = new Assignment("ie1", r.nextFloat(), r.nextFloat(), "ie2",
                "ie3", r.nextInt(), r.nextInt());

        db.getAssignmentDAO().insert(test);
        test = db.getAssignmentDAO().getAssignmentByDesc(assignDesc).get(0);

        assertNotNull( db.getAssignmentDAO().getAssignmentById(Math.toIntExact(test.getAssignmentID())));
    }

    /*Checks that Assignment can be deleted from Room
     */
    @Test
    public void AssignmentDelete(){
        Context c = InstrumentationRegistry.getInstrumentation().getContext();
        StudentAppDatabase db = Room.inMemoryDatabaseBuilder(c, StudentAppDatabase.class).build();

        Random r = new Random();

        String assignDesc = "ie1";

        Assignment test = new Assignment("ie1", r.nextFloat(), r.nextFloat(), "ie2",
                "ie3", r.nextInt(), r.nextInt());

        db.getAssignmentDAO().insert(test);
        test = db.getAssignmentDAO().getAssignmentByDesc(assignDesc).get(0);

        assertNotNull( db.getAssignmentDAO().getAssignmentById(test.getAssignmentID()));

        db.getAssignmentDAO().delete(test);
        assertNotNull( db.getAssignmentDAO().getAssignmentById(test.getAssignmentID()));
    }

    /*Checks that GradeCategory can be created using Room
     */
    @Test
    public void GradeCategoryCreate(){
        Context c = InstrumentationRegistry.getInstrumentation().getContext();
        StudentAppDatabase db = Room.inMemoryDatabaseBuilder(c, StudentAppDatabase.class).build();

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
        StudentAppDatabase db = Room.inMemoryDatabaseBuilder(c, StudentAppDatabase.class).build();

        Random r = new Random();
        GradeCategory test = new GradeCategory("ie", r.nextInt(), r.nextInt(), r.nextInt());

        db.getGradeCategoryDAO().insert(test);
        assertNotNull( db.getGradeCategoryDAO().getGradeCategorytById(test.getTitle()));

        db.getGradeCategoryDAO().delete(test);
        assertNotNull( db.getGradeCategoryDAO().getGradeCategorytById(test.getTitle()));
    }

}
