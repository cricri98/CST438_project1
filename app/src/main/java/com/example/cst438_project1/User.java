package com.example.cst438_project1;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/*Contains personal data for user.
 *
 *
 */
@Entity
public class User {
    @PrimaryKey
    private int ID;

    @ColumnInfo(name = "name")
    private String name;

    User(){
        this.ID = 0;
        this.name = "Dan Default";
    }

    User(int ID){
        this.ID = ID;
        this.name = "ID Default";
    }

    User(int ID, String name){
        this.ID = ID;
        this.name = name;
    }

    public int getID(){
       return ID;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
}
