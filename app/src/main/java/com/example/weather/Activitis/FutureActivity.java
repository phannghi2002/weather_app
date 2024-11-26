package com.example.weather.Activitis;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weather.Adapters.FutureAdapters;
import com.example.weather.Domains.FutureDomain;
import com.example.weather.R;

import java.util.ArrayList;
import java.util.concurrent.Future;

public class FutureActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapterTomorrow;
    public RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_future);

        initRecycleView();
        setVariable();

    }

    private void setVariable() {
//        ConstraintLayout backBtn = findViewById(R.id.backBtn);
        ImageView backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FutureActivity.this, MainActivity.class));
            }
        });

//        backBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivities(new Intent(FutureActivity.this, MainActivity.class));
//            }
//        });
    }

    private void initRecycleView() {
        ArrayList<FutureDomain> items = new ArrayList<>();

        items.add(new FutureDomain("Sat", "storm", "Storm", 25, 10));
        items.add(new FutureDomain("Sun", "cloudy", "Cloudy", 24, 16));
        items.add(new FutureDomain("Mon", "windy", "Windy", 29, 15));
        items.add(new FutureDomain("Tue", "cloudy_sunny", "Cloudy_Sunny", 22, 13));
        items.add(new FutureDomain("Wen", "sunny", "Sunny", 28, 11));
        items.add(new FutureDomain("Thu", "rainy", "Rainy", 23, 12));

        recyclerView = findViewById(R.id.view2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        adapterTomorrow = new FutureAdapters(items);
recyclerView.setAdapter(adapterTomorrow);

    }
}