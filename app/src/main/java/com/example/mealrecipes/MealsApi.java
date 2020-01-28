package com.example.mealrecipes;

import com.example.mealrecipes.model.MealSearch;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MealsApi {
    @GET("search.php")
    Call<MealSearch> getAllMeals(@Query("s") String mealName);

}
