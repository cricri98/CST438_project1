package com.example.cst438_project1.MainMenuAtivities;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.cst438_project1.DB.StudentAppDatabase;
import com.example.cst438_project1.Objects.User;
import com.example.cst438_project1.R;

public class EA extends AppCompatActivity {

    Button saveAccountButton;

    StudentAppDatabase db;

    int userId;
    User currentUser;

    EditText username;
    EditText name;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_account);
    }
}