package com.example.cst438_project1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.cst438_project1.DB.AppDatabase;
import com.example.cst438_project1.DB.GradeCategoryDAO;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    GradeCategoryDAO mGradeCategoryDAO;
    List<GradeCategory> mGradeCategories;

    TextView mainDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);
        mainDisplay = findViewById(R.id.textViewMain);
        mGradeCategoryDAO = Room.databaseBuilder(this, AppDatabase.class, AppDatabase.GCName)
                .allowMainThreadQueries()
                .build()
                .getGradeCategoryDAO();

        refreshDisplay();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainMenu();
                refreshDisplay();
            }
        });
    }

    public void openMainMenu(){
        EditText gradeID = findViewById(R.id.text);
        Integer savedGradeID = Integer.parseInt(gradeID.getText().toString());

        EditText gradeTitle = findViewById(R.id.text2);
        String savedTitle = gradeTitle.getText().toString();

        mGradeCategoryDAO.insert(new GradeCategory(savedTitle, savedGradeID, savedGradeID, savedGradeID));
    }

    public void refreshDisplay(){

        mGradeCategories = mGradeCategoryDAO.getGradeCategories();

        if(! mGradeCategories.isEmpty()){
            StringBuilder stringBuilder = new StringBuilder();
            for(GradeCategory acc: mGradeCategories){
                stringBuilder.append(acc.toString());
            }
            mainDisplay.setText(stringBuilder.toString());
        } else {
            mainDisplay.setText("Database is Empty");
        }
    }

}
