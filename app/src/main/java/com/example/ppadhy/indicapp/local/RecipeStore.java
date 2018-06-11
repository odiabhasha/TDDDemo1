package com.example.ppadhy.indicapp.local;

import android.content.Context;
import android.content.res.AssetManager;

import com.example.ppadhy.indicapp.model.Recipe;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RecipeStore {

    public List<Recipe> recipeList = new ArrayList<>();
    private HashMap<String,Recipe> map = new HashMap<>();

    public RecipeStore(Context context, String directory){
        List<InputStream> list = getAssetStreams(context.getAssets(),directory);
        for(InputStream inputStream : list){
            Recipe recipe = Recipe.getRecipe(inputStream);
            recipeList.add(recipe);
            map.put(recipe.id,recipe);
        }
    }

    public static List<InputStream> getAssetStreams(AssetManager assetManager, String directoryName){
        String [] files = getFileNames(assetManager,directoryName);

        List<InputStream> inputStreamList = new ArrayList<>();

        for (String file : files){
            try {
                File streamFile = new File(directoryName,file);
                InputStream inputStream = assetManager.open(streamFile.getPath());
                inputStreamList.add(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return inputStreamList;
    }


    public static String[] getFileNames(AssetManager assetManager,String directoryName){
        if(directoryName == null){
            return new String[0];
        }
        try {
            return assetManager.list(directoryName);
        } catch (IOException e) {
            return new String[0];
        }
    }

    public Recipe getRecipe(String recipeId) {
        return map.get(recipeId);
    }
}
