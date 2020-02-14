package com.example.cst438_project1;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

public class LoginActivity extends AppCompatActivity {
    StudentAppDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("LoginActivity", "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        database = Room.databaseBuilder(this, StudentAppDatabase.class, "database").build();

        final EditText username = findViewById(R.id.username);
        final EditText password = findViewById(R.id.password);
        final Button login = findViewById(R.id.login);
        final TextView login_output = findViewById(R.id.login_output);

        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                final String name = username.getText().toString();
                final String pass = password.getText().toString();
                new Thread(new Runnable(){
                    public void run() {
                        User[] user = database.getUserDao().getUserbyName(name);
                        for (User u : user) {
                            if (u.isPassword(pass)) {
                                currentUser.set(u);
                                break;
                            }
                        }
                    }
                });
                if (currentUser.get() == null){
                    login_output.setText(R.string.login_fail);
                }
                else {
                    login_output.setText(R.string.login_succeed);
                    finish();
                }

            }

        });
        login.setEnabled(true);
    }


}
