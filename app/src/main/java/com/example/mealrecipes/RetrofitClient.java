package com.example.mealrecipes;

import com.example.mealrecipes.dataRepository.Retrofit.MealsApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    public static final String BASE_URL = "https://www.themealdb.com/api/json/v1/1/";

    private MealsApi mealsApi;
    private static RetrofitClient INSTANCE;

    public static RetrofitClient getInstance(){
        if (INSTANCE == null){
            INSTANCE = new RetrofitClient();
            Retrofit retrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .build();
            MealsApi mealsApi = retrofit.create(MealsApi.class);
            INSTANCE.setMealsApi(mealsApi);
        }
        return INSTANCE;
    }

    public MealsApi getMealsApi() {
        return mealsApi;
    }

    public void setMealsApi(MealsApi mealsApi) {
        this.mealsApi = mealsApi;
    }
}
