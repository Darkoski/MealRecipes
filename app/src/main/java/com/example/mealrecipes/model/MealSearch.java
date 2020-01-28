package com.example.mealrecipes.model;

import java.util.List;

public class MealSearch {
    List<Meal> meals;

    public MealSearch(List<Meal> mealSearchList) {
        this.meals = mealSearchList;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }
}
