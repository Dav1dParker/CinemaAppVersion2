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

public class FavoritesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_favorites);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.favorite_activity), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initView();
    }

    private void initView() {
        ImageButton exploreBtn = findViewById(R.id.ExplorerBtnF);
        ImageButton accountBtn = findViewById(R.id.ProfileBtnF);
        ImageButton cartBtn = findViewById(R.id.CartBtnF);

        exploreBtn.setOnClickListener(view -> {
            startActivity(new Intent(FavoritesActivity.this, MainActivity.class));
            finish();
        });

        accountBtn.setOnClickListener(view -> {
            startActivity(new Intent(FavoritesActivity.this, AccountActivity.class));
            finish();
        });

        cartBtn.setOnClickListener(view -> {
            startActivity(new Intent(FavoritesActivity.this, CartActivity.class));
            finish();
        });
    }
}