package com.example.mealrecipes.domain;

import androidx.lifecycle.LiveData;

import com.example.mealrecipes.dataRepository.RepositoryMeal.MealRepo;
import com.example.mealrecipes.domain.repo.MealsRepo;
import com.example.mealrecipes.model.Meal;

import java.util.List;

public class GetAllMealsUseCase {

    private MealsRepo repo;

    private String mealName;

    public GetAllMealsUseCase(MealsRepo repo) {
        this.repo = repo;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public LiveData<List<Meal>> getMeals() {
        return repo.getAllMeals(mealName);
    }
}
