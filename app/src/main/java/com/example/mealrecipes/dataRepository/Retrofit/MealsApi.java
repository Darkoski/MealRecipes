package com.example.mealrecipes.dataRepository.Retrofit;

import androidx.lifecycle.LiveData;

import com.example.mealrecipes.model.MealSearch;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MealsApi {
    @GET("search.php")
    Call<MealSearch> getAllMeals(@Query("s") String mealName);

    @GET("search.php")
    LiveData<MealSearch> searchMeals(@Query("s") String mealName);

}
