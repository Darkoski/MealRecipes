package com.example.mealrecipes.dataRepository.IdataBaseImplementation;

import android.content.Context;

import com.example.mealrecipes.Listeners.ListenerRepository;
import com.example.mealrecipes.dataRepository.RoomDatabase.MealDataBase;
import com.example.mealrecipes.model.Meal;

import java.util.List;

public class IDataBase implements iDataSource {
    Context context;
    public IDataBase(Context context) {
        this.context=context;
    }


    @Override
    public void getAllData(ListenerRepository listenerRepository) {
        List<Meal> mealList = MealDataBase.getINSTANCE(context).getMealDao().getAllMeals();
        listenerRepository.RepositoryReturn(mealList);
    }

    @Override
    public void getDataByName(String name, ListenerRepository listenerRepository) {

    }

    @Override
    public void insertMeal(Meal meal) {
        MealDataBase.getINSTANCE(context).getMealDao().insertMeal(meal);
    }


}
