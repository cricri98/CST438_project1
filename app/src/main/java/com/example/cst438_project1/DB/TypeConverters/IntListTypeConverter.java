package com.example.cst438_project1.DB.TypeConverters;

import androidx.room.TypeConverter;

import java.util.Date;

public class IntListTypeConverter {
    @TypeConverter
    public String convertArrToString(int[] intArr){
        String arrString = "";
        for(int i : intArr){
            arrString = arrString + i + ",";
        }

        arrString = arrString.substring(0, arrString.length() - 1);

        return arrString;
    }

    @TypeConverter
    public int[] convertStringToArr(String inS){
        String[] sArr = inS.split(",");

        int[] intArr = new int[sArr.length];

        for(int i = 0; i < sArr.length; i++){
            intArr[i] = Integer.parseInt(sArr[i]);
        }

        return intArr;
    }
}
