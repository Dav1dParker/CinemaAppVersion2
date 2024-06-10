package com.example.cinemaapp2.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cinemaapp2.Adapters.CartItemsAdapter;
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

        ProgressBar loading;
        RecyclerView recyclerViewCartItems = findViewById(R.id.favoriteRecyclerView);
        recyclerViewCartItems.setLayoutManager(new LinearLayoutManager(this));
        int[] cartItems = {R.drawable.wide, R.drawable.wide1, R.drawable.wide3}; // Replace with actual drawable resource IDs
        CartItemsAdapter adapter = new CartItemsAdapter(this, cartItems);
        recyclerViewCartItems.setAdapter(adapter);
        loading=findViewById(R.id.progressBarFavorite);
        loading.setVisibility(View.GONE);
    }
}