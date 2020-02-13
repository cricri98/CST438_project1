package com.example.cst438_project1.Objects;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/*Contains personal data for user.
 *@author Joshua Click
 *Changelog:
 * 0.1: First created
 * 0.2: Added password
 */
@Entity
public class User {
    @PrimaryKey(autoGenerate = true)
    private int ID;

    @ColumnInfo(name = "name")
    private String name;

    //TODO:Password hashing!
    @ColumnInfo(name = "password")
    private String password;

    User(){
        this.name = "Dan Default";
        this.password = "password1";
    }
    User(String name, String password){
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

}
