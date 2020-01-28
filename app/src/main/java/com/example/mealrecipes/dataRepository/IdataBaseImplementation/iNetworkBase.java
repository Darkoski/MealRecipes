package com.example.mealrecipes.dataRepository.IdataBaseImplementation;

import android.widget.Toast;

import com.example.mealrecipes.Listeners.ListenerRepository;
import com.example.mealrecipes.adapters.MealsAdapter;
import com.example.mealrecipes.dataRepository.IdataBaseImplementation.iDataSource;
import com.example.mealrecipes.dataRepository.Retrofit.MealsApi;
import com.example.mealrecipes.model.Meal;
import com.example.mealrecipes.model.MealSearch;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class iNetworkBase implements iDataSource {

    private MealsApi mealsApi;
    public iNetworkBase(Retrofit retrofit) {
        mealsApi = retrofit.create(MealsApi.class);
    }

    @Override
    public void getAllData(ListenerRepository listenerRepository) {

    }

    @Override
    public void getDataByName(final String name, final ListenerRepository listenerRepository) {
        mealsApi.getAllMeals(name).enqueue(new Callback<MealSearch>() {
            @Override
            public void onResponse(Call<MealSearch> call, Response<MealSearch> response) {
                    listenerRepository.RepositoryReturn(response.body().getMeals());
            }

            @Override
            public void onFailure(Call<MealSearch> call, Throwable t) {
                listenerRepository.RepositoryReturn(null);
            }
        });
    }

    @Override
    public void insertMeal(Meal meal) {

    }
}
