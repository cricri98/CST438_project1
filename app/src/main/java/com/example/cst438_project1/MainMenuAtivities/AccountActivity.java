package com.example.cst438_project1.MainMenuAtivities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cst438_project1.R;

public class AccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
