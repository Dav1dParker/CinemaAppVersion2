package com.example.cinemaapp2.Activities;

import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.cinemaapp2.Adapters.ActorsListAdapter;
import com.example.cinemaapp2.Adapters.CategoryEachFilmListAdapter;
import com.example.cinemaapp2.Adapters.CategoryListAdapter;
import com.example.cinemaapp2.Domain.FilmItem;
import com.example.cinemaapp2.Domain.ListFilm;
import com.example.cinemaapp2.R;
import com.google.gson.Gson;

public class DetailActivity extends AppCompatActivity {
    private RequestQueue mRequestQueue;
    private StringRequest mStringRequest;
    private ProgressBar progressBar;
    private TextView titleTxt, movieRateTxt, movieTimeTxt, MovieSummeryInfo, movieActorsInfo;
    private int idFilm;
    private ImageView pic2, backImg;
    private RecyclerView.Adapter adapterActorList, adapterCategory;
    private RecyclerView recyclerViewActors, recyclerViewCategory;

    private NestedScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.detailActivity), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        idFilm = getIntent().getIntExtra("id", 0);
        initView();
        //Toast.makeText(this, idFilm + "", Toast.LENGTH_SHORT).show();
        sendRequest();
    }

    private void sendRequest() {

        mRequestQueue = Volley.newRequestQueue(this);
        progressBar.setVisibility(View.VISIBLE);
        scrollView.setVisibility(View.GONE);
        Log.d("1", "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");


        mStringRequest = new StringRequest(Request.Method.GET, "https://moviesapi.ir/api/v1/movies/" + idFilm, response -> {
            Log.d("2", "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            Gson gson = new Gson();
            progressBar.setVisibility(View.GONE);
            scrollView.setVisibility(View.VISIBLE);
            FilmItem item = gson.fromJson(response, FilmItem.class);
            Glide.with(DetailActivity.this)
                    .load(item.getPoster())
                    .into(pic2);
            titleTxt.setText(item.getTitle());
        movieRateTxt.setText(item.getImdbRating());
            movieTimeTxt.setText(item.getRuntime());
            MovieSummeryInfo.setText(item.getPlot());
            movieActorsInfo.setText(item.getActors());
            if (item.getImages() != null) {
                Log.d("4", "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                adapterActorList = new ActorsListAdapter(item.getImages());
                recyclerViewActors.setAdapter(adapterActorList);
            }
            else
            {
                Log.d("5", "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                Log.d("error1", "sendRequest: ");
            }
            if (item.getGenres() != null) {
                adapterCategory = new CategoryEachFilmListAdapter(item.getGenres());
                recyclerViewCategory.setAdapter(adapterCategory);
            }
            else {
                Log.d("error2", "sendRequest: ");
            }
        }, error -> {
            progressBar.setVisibility(View.GONE);
            scrollView.setVisibility(View.GONE);
            Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();
            //log
            Log.d("error", error.toString());
        });
        mRequestQueue.add(mStringRequest);
    }


    private void initView() {
        titleTxt = findViewById(R.id.movieNameTxt);
        movieRateTxt = findViewById(R.id.movieStar);
        movieTimeTxt = findViewById(R.id.movieTime);
        scrollView = findViewById(R.id.scrollView3);
        MovieSummeryInfo = findViewById(R.id.movieSummery);
        movieActorsInfo = findViewById(R.id.movieActorInfo);
        pic2 = findViewById(R.id.picDetail);
        backImg = findViewById(R.id.BackImg);
        recyclerViewActors = findViewById(R.id.imagesRecycler);
        recyclerViewCategory = findViewById(R.id.genreView);
        progressBar = findViewById(R.id.progressBarDetail);
        recyclerViewActors.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerViewCategory.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        backImg.setOnClickListener(v -> finish());
    }
}