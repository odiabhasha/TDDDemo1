package com.example.ppadhy.indicapp.local;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceFavorite {

    private SharedPreferences sharedPreferences;

    public SharedPreferenceFavorite(Context context) {
        this.sharedPreferences = context.getSharedPreferences("favourite",Context.MODE_PRIVATE);
    }

    public boolean get(String id){
        return sharedPreferences.getBoolean(id,false);
    }

    public void put(String id, boolean favorite){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if (favorite)
            editor.putBoolean(id,true);
        else
            editor.remove(id);
        editor.apply();
    }

    public boolean toggle(String id){
        boolean fav = get(id);
        put(id,!fav);
        return !fav;
    }
}
