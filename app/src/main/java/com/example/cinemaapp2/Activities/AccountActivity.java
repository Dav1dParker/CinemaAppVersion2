package com.example.cinemaapp2.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.cinemaapp2.R;

public class AccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_account);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.AccountLayout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initView();
    }

    private void initView() {
        ImageButton exploreBtn = findViewById(R.id.ExplorerBtnP);
        ImageButton favoriteBtn = findViewById(R.id.FavoriteBtnP);
        ImageButton cartBtn = findViewById(R.id.CartBtnP);

        exploreBtn.setOnClickListener(view -> {
            startActivity(new Intent(AccountActivity.this, MainActivity.class));
            finish();
        });

        favoriteBtn.setOnClickListener(view -> {
            startActivity(new Intent(AccountActivity.this, FavoritesActivity.class));
            finish();
        });

        cartBtn.setOnClickListener(view -> {
            startActivity(new Intent(AccountActivity.this, CartActivity.class));
            finish();
        });
    }
}