package com.example.cinemaapp2.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.cinemaapp2.R;

public class LoginActivity extends AppCompatActivity {

    private EditText userEdt, passEdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.login_layout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initView();
    }

    private void initView() {
        userEdt = findViewById(R.id.username);
        passEdt = findViewById(R.id.password);
        Button loginBtn = findViewById(R.id.login_button);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (userEdt.getText().toString().isEmpty() || passEdt.getText().toString().isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Please, enter your login and password above", Toast.LENGTH_SHORT).show();
                }
                else if (userEdt.getText().toString().equals("1") && passEdt.getText().toString().equals("1"))
                {
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                }
                else
                {
                    Toast.makeText(LoginActivity.this, "Your username or password is incorrect, try again", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}