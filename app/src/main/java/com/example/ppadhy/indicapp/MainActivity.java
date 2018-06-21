package com.example.ppadhy.indicapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.ppadhy.indicapp.adapters.RecipeViewAdapter;
import com.example.ppadhy.indicapp.local.RecipeStore;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecipeViewAdapter recipeViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        recipeViewAdapter = new RecipeViewAdapter(new RecipeStore(MainActivity.this,"recipes"));
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView.setAdapter(recipeViewAdapter);
    }
}
