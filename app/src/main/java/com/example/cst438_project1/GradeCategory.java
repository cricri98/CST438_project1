//Grade Category Object
//        o Title
//        o Weight
//        o GradeID
//        o AssignedDate
//        o categoryID
//TODO create the type converter for assignedDate
package com.example.cst438_project1;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.cst438_project1.DB.AppDatabase;

@Entity(tableName = AppDatabase.GRADECATEGORY_TABLE)
public class GradeCategory {

    @PrimaryKey
    @NonNull
    private String mTitle;

    private Integer mWeight;
    private Integer mGradeID;
//    private Date mAssignedDate;
    private Integer mCategoryID;

    public GradeCategory(String title, Integer weight, Integer gradeID, Integer categoryID) {
        mTitle = title;
        mWeight = weight;
        mGradeID = gradeID;
        mCategoryID = categoryID;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public Integer getWeight() {
        return mWeight;
    }

    public void setWeight(Integer mWeight) {
        this.mWeight = mWeight;
    }

    public Integer getGradeID() {
        return mGradeID;
    }

    public void setGradeID(Integer mGradeID) {
        this.mGradeID = mGradeID;
    }

    public Integer getCategoryID() {
        return mCategoryID;
    }

    public void setCategoryID(Integer mCategoryID) {
        this.mCategoryID = mCategoryID;
    }

    @Override
    public String toString() {
        return "GradeCategory{" +
                "mTitle='" + mTitle + '\'' +
                ", mWeight=" + mWeight +
                ", mGradeID=" + mGradeID +
                ", mCategoryID=" + mCategoryID +
                '}';
    }
}
