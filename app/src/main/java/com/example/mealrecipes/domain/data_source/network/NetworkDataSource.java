package com.example.mealrecipes.domain.data_source.network;

import androidx.lifecycle.LiveData;

import com.example.mealrecipes.dataRepository.Retrofit.MealsApi;
import com.example.mealrecipes.model.Meal;
import com.example.mealrecipes.model.MealSearch;

import java.util.List;

import retrofit2.Retrofit;

public class NetworkDataSource {
    private MealsApi mealsApi;

    public NetworkDataSource(Retrofit retrofit) {
        mealsApi = retrofit.create(MealsApi.class);
    }

    public NetworkDataSource(MealsApi mealsApi) {
        this.mealsApi = mealsApi;
    }

    public LiveData<MealSearch> getAllMeals(String mealName) {
        return mealsApi.searchMeals(mealName);
    }
}
