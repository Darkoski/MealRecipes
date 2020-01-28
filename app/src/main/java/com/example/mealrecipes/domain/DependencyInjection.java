package com.example.mealrecipes.domain;

import com.example.mealrecipes.domain.data_source.db.DbDataSource;
import com.example.mealrecipes.domain.data_source.network.NetworkDataSource;
import com.example.mealrecipes.domain.repo.MealsRepo;

import retrofit2.Retrofit;

public class DependencyInjection {

    private static Retrofit retrofit;
    private static NetworkDataSource networkDataSource;
    private static DbDataSource dbDataSource;
    private static MealsRepo mealsRepo;


    public static Retrofit getRetrofit() {
        if (retrofit == null) {

        }
        return retrofit;
    }

    public static NetworkDataSource getNetworkDataSource() {
        if (networkDataSource == null) {
            networkDataSource = new NetworkDataSource(getRetrofit());
        }
        return networkDataSource;
    }

    public static MealsRepo getMealsRepo() {
        return null;
    }
}
