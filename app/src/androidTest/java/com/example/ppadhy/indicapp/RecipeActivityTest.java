package com.example.ppadhy.indicapp;

import android.content.Intent;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;

public class RecipeActivityTest {

    @Rule
    public ActivityTestRule<RecipeActivity> activityTestRule =
            new ActivityTestRule<RecipeActivity>(
                    RecipeActivity.class,
                    true, /* Launch with touch mode*/
                    false /* Auto Launch Off, We will use an Intent instead*/
            );

    @Test
    public void recipeNotFound(){
        activityTestRule.launchActivity(null);// Without intent
        onView(withId(R.id.description))
                .check(matches(withText(R.string.string_no_recipe_found)));
        onView(withId(R.id.title))
                .check(matches(not(isDisplayed())));
    }

    @Test
    public void clickToFavourite(){
        Intent intent = new Intent();
        intent.putExtra(RecipeActivity.KEY_ID,"creamed_carrots");
        activityTestRule.launchActivity(intent);

        onView(withId(R.id.title))
                .check(matches(R.id.))
    }





}