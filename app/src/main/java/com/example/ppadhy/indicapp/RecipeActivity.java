package com.example.ppadhy.indicapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.ppadhy.indicapp.local.RecipeStore;
import com.example.ppadhy.indicapp.local.SharedPreferenceFavorite;
import com.example.ppadhy.indicapp.model.Recipe;

public class RecipeActivity extends AppCompatActivity {

    private static final String KEY_ID = "id";
    private TextView title;
    private TextView description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        title = findViewById(R.id.title);
        description = findViewById(R.id.description);
        Intent intent = getIntent();
        final String id  = intent.getStringExtra(KEY_ID);
        RecipeStore recipeStore = new RecipeStore(this,"recipes");
        Recipe recipe = recipeStore.getRecipe(id);
        if(recipe == null){
            title.setVisibility(View.GONE);
            description.setText(R.string.string_no_recipe_found);
            return;
        }
        title.setText(recipe.title);
        description.setText(recipe.description);
        final SharedPreferenceFavorite sharedPreferenceFavorite = new SharedPreferenceFavorite(this);
        boolean selected = sharedPreferenceFavorite.get(id);
        title.setSelected(selected);
        title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean selected = sharedPreferenceFavorite.toggle(id);
                title.setSelected(selected);
            }
        });
    }
}
