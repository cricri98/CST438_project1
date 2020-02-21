package com.example.cst438_project1.MainMenuAtivities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.cst438_project1.DB.StudentAppDatabase;
import com.example.cst438_project1.MainMenuAtivities.ViewAssignment.ViewAssignmentActivity;
import com.example.cst438_project1.Objects.User;
import com.example.cst438_project1.R;

public class AccountActivity extends AppCompatActivity {

    boolean edit;
    int userId;
    User u;
    StudentAppDatabase db;

    TextView userIdView;
    TextView usernameView;
    TextView nameView;
    TextView passwordView;

    Button editAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        db = Room.databaseBuilder(getApplicationContext(), StudentAppDatabase.class, "db").allowMainThreadQueries().build();

        userId = getIntent().getIntExtra("userId", -1);

        u = db.getUserDao().getUserById(userId);

        usernameView = findViewById(R.id.usernameView);
        nameView = findViewById(R.id.nameView);
        userIdView = findViewById(R.id.userIdView);

        editAccount = findViewById(R.id.editAccount);
        editAccount.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                editAccount();
            }
        });
        updateViews();
        edit = false;
    }

    void updateViews(){
        Toast.makeText(getApplicationContext(), "update!", Toast.LENGTH_LONG).show();
        try {
            usernameView.setText(u.getUsername());
            nameView.setText(u.getName());
            userIdView.setText(Integer.toString(u.getID()));
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), R.string.error, Toast.LENGTH_LONG).show();
            finish();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    public void editAccount(){
        if (edit){
            usernameView.setFocusable(false);
            nameView.setFocusable(false);
            passwordView.setFocusable(false);

        }else {

        }
    }
}
