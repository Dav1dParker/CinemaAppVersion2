package com.example.cinemaapp2.Activities;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ImageButton;

import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.cinemaapp2.databinding.ActivityCartBinding;

import com.example.cinemaapp2.R;

public class CartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cart);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.cart_main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initView();
    }

    private void initView() {
        ImageButton exploreBtn = findViewById(R.id.ExplorerBtnC);
        ImageButton accountBtn = findViewById(R.id.ProfileBtnC);
        ImageButton favoriteBtn = findViewById(R.id.FavoriteBtnC);

        exploreBtn.setOnClickListener(view -> {
            startActivity(new Intent(CartActivity.this, MainActivity.class));
            finish();
        });

        accountBtn.setOnClickListener(view -> {
            startActivity(new Intent(CartActivity.this, AccountActivity.class));
            finish();
        });

        favoriteBtn.setOnClickListener(view -> {
            startActivity(new Intent(CartActivity.this, FavoritesActivity.class));
            finish();
        });
    }
}