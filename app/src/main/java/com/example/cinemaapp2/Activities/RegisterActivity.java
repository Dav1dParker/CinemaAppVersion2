package com.example.cinemaapp2.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.cinemaapp2.Database.MyDatabase;
import com.example.cinemaapp2.R;

public class RegisterActivity extends AppCompatActivity {

    private EditText username, password, password2;
    private MyDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        Intent intent = getIntent();
        setContentView(R.layout.activity_register);
        username = findViewById(R.id.usernameR);
        password = findViewById(R.id.passwordR);
        password2 = findViewById(R.id.passwordR2);
        db = new MyDatabase(this);
        Button registerBtn = findViewById(R.id.register_Btn);
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(username.getText().toString())) {
                    Toast.makeText(RegisterActivity.this, "Please, enter login", Toast.LENGTH_LONG).show();
                } else if (TextUtils.isEmpty(password.getText().toString())) {
                    Toast.makeText(RegisterActivity.this, "Please, enter password", Toast.LENGTH_LONG).show();
                } else if (!password.getText().toString().equals(password2.getText().toString()))
                {
                    Toast.makeText(RegisterActivity.this, "Your passwords don't match", Toast.LENGTH_LONG).show();
                }

                else {
                    db.insertToUserDB(username.getText().toString(), password.getText().toString());
                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        db.OpenDBUsers();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        db.CloseDBUsers();
    }
}