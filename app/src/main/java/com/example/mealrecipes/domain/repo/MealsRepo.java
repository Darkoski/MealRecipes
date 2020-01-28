package com.example.mealrecipes.domain.repo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;

import com.example.mealrecipes.domain.data_source.db.DbDataSource;
import com.example.mealrecipes.domain.data_source.network.NetworkDataSource;
import com.example.mealrecipes.model.Meal;
import com.example.mealrecipes.model.MealSearch;

import java.util.List;

public class MealsRepo {

    private NetworkDataSource networkDataSource;
    private DbDataSource dbDataSource;

    public MealsRepo(NetworkDataSource networkDataSource, DbDataSource dbDataSource) {
        this.networkDataSource = networkDataSource;
        this.dbDataSource = dbDataSource;
    }

    public LiveData<List<Meal>> getAllMeals(String mealName) {
        final MediatorLiveData liveDataMerger = new MediatorLiveData<List<Meal>>();
        liveDataMerger.addSource(networkDataSource.getAllMeals(mealName), new Observer<MealSearch>() {
            @Override
            public void onChanged(MealSearch o) {
                liveDataMerger.setValue(o.getMeals());
            }
        });
        return liveDataMerger;
    }
}
