package com.example.ppadhy.indicapp.model;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Recipe {

    private static final String PREFIX_ID = "id=";
    private static final String PREFIX_TITLE = "title=";
    public final String id;
    public final String title;
    public final String description;

    private Recipe(String id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public static Recipe getRecipe(InputStream inputStream){
        String id = null;
        String title = null;
        StringBuilder description = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line = null;
        try{
            while ((line = bufferedReader.readLine())!=null)
            {
                if(line.startsWith(PREFIX_ID)){
                    id = line.substring(PREFIX_ID.length());
                    continue;
                }

                if(line.startsWith(PREFIX_TITLE)){
                    title = line.substring(PREFIX_TITLE.length());
                    continue;
                }

                if(description.length() > 0){
                    description.append("\n");
                }
                description.append(line);
            }
        }catch (Exception e){
            return null;
        }
        return new Recipe(id,title,description.toString());
    }
}
