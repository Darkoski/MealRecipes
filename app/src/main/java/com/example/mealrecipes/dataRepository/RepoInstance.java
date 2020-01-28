package com.example.mealrecipes.dataRepository;

import android.content.Context;

import com.example.mealrecipes.dataRepository.IdataBaseImplementation.IDataBase;
import com.example.mealrecipes.dataRepository.IdataBaseImplementation.iDataSource;
import com.example.mealrecipes.dataRepository.IdataBaseImplementation.iNetworkBase;
import com.example.mealrecipes.dataRepository.RepositoryMeal.MealRepoImpl;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RepoInstance {
    private static MealRepoImpl INSTANCE;

    public static MealRepoImpl getINSTANCE(Context context) {
        if(INSTANCE==null){
            Retrofit retrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://www.themealdb.com/api/json/v1/1/")
                    .build();
            iDataSource dataSource=new IDataBase(context);
            iDataSource networkSource=new iNetworkBase(retrofit);
            INSTANCE=new MealRepoImpl(dataSource,networkSource);
        }
        return INSTANCE;
    }
}
