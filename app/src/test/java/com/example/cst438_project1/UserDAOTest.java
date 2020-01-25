package com.example.cst438_project1;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserDAOTest {
    /*Checks that User can be created and saved to Room
     **No params
     */
    @Test
    public void UserCreate(){
        User test = new User();
        insertUser(test);
        assertTrue();
    }
    /*Checks that User can be deleted from Room
    **No params
     */
    @Test
    public void UserDelete(){
        User test = new User();
        insertUser(test);
        assertTrue();

        deleteUser(test);
        assertFalse();
    }
    /*Checks that User can be updated in Room
     **No params
     */
    @Test
    public void UserUpdate(){
        User test = new User();
        insertUser(test);
        assertTrue();
        updateUser(test);
        assertTrue();
    }
}
