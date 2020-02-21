package com.example.cst438_project1.Objects;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.example.cst438_project1.DB.StudentAppDatabase;

import java.util.List;

/*Contains personal data for user.
 *@author Joshua Click
 *Changelog:
 * 0.1: First created
 * 0.2: Added password
 */
@Entity(tableName = StudentAppDatabase.USER_TABLE)
public class User {
    @PrimaryKey(autoGenerate = true)
    private int ID;

    private String username;

    @ColumnInfo(name = "name")
    private String name;

    //TODO:Password hashing!
    @ColumnInfo(name = "password")
    private String password;

    private List<Integer> courseList;

    public User(String username, String name, String password) {
        this.username = username;
        this.name = name;
        this.password = password;
    }

    public int getID(){
       return ID;
    }
    /*Sets User ID.
     *NOTE:DON'T USE THIS METHOD.
     *@param ID the new ID
     */
    public void setID(int ID){
        this.ID = ID;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /*Returns true if the String matches the password
     *@param in The String to be checked.
     *@return boolean Does in match the password?
     */

    public boolean isPassword(String in){
        return in.equals(password);
    }

    /*Sets the password to new password and returns true if password_old matches the password, otherwise returns false
     *@param password_old The old password
     *@param password_new The new password
     *@return boolean Has the password been changed?
     */

    public boolean setPassword(String password_old, String password_new){
        if (password_old.equals(password)){
            password = password_new;
            return true;
        }
        return false;
    }

    public List<Integer> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Integer> courseList) {
        this.courseList = courseList;
    }

    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
