package com.example.ppadhy.indicapp.local;

import android.content.Context;
import android.support.test.InstrumentationRegistry;

import com.example.ppadhy.indicapp.model.Recipe;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class RecipeStoreTest {

    @Test
    public void nullDirectoryTest(){
        Context context = InstrumentationRegistry.getTargetContext();
        RecipeStore recipeStore = new RecipeStore(context,null);
        assertNotNull(recipeStore);
        assertNotNull(recipeStore.recipeList);
        assertEquals(0,recipeStore.recipeList.size());
    }

    @Test
    public void countTest(){
        Context context = InstrumentationRegistry.getTargetContext();
        RecipeStore recipeStore = new RecipeStore(context,"recipes");
        assertNotNull(recipeStore);
        assertNotNull(recipeStore.recipeList);
        assertEquals(4,recipeStore.recipeList.size());
    }

    @Test
    public void getChocolatePuddingTest(){
        Context context = InstrumentationRegistry.getTargetContext();
        RecipeStore recipeStore = new RecipeStore(context,"recipes");
        Recipe recipe = recipeStore.getRecipe("chocolate_pudding");
        assertNotNull(recipe);
        assertEquals("chocolate_pudding",recipe.id);
        assertEquals("Chocolate Pudding",recipe.title);
        assertEquals("2 tablespoons chocolate\n" +
                "yolks of 4 eggs\n" +
                "1 cup sugar\n" +
                "1 quart milk\n" +
                "1 whole egg\n" +
                "2 tablespoons corn starch\n" +
                "\n" +
                "Cook until it thickens, beat whites of eggs and put on top, put in oven to brown. Serve with cream, if preferred.",recipe.description);
    }
}