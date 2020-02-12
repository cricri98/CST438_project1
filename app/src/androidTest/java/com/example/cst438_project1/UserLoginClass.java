package com.example.cst438_project1;

import android.content.Context;

import androidx.room.Room;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNull;

public class UserLoginClass {
    @Test
    public void current_user(){
        currentUser.reset();
        assertNull(currentUser.get());
        User user = new User();
        currentUser.set(user);
        assertEquals(user, currentUser.get());
        currentUser.reset();
    }
}
