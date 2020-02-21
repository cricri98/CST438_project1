package com.example.cst438_project1.DB.TypeConverters;

import androidx.room.TypeConverter;

import java.util.ArrayList;
import java.util.List;

public class IntegerListTypeConverter {
    @TypeConverter
    public String convertListToString(List<Integer> intArr){
        try {
            String arrString = "";
            for (int i : intArr) {
                arrString = arrString + i + ",";
            }

            arrString = arrString.substring(0, arrString.length() - 1);

            return arrString;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @TypeConverter
    public List<Integer> convertStringToList(String inS) {
        try {
            String[] sArr = inS.split(",");

            List<Integer> intArr = new ArrayList<>();

            for (int i = 0; i < sArr.length; i++) {
                intArr.add(Integer.parseInt(sArr[i]));
            }

        return intArr;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return new ArrayList<Integer>();
        }
    }
}
