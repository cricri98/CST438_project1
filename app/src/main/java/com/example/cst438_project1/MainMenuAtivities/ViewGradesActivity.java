package com.example.cst438_project1.MainMenuAtivities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.cst438_project1.R;

public class ViewGradesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_grades);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}