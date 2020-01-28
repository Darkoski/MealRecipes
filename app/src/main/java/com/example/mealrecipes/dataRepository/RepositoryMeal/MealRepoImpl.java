package com.example.mealrecipes.dataRepository.RepositoryMeal;

import com.example.mealrecipes.Listeners.ListenerRepository;
import com.example.mealrecipes.dataRepository.IdataBaseImplementation.iDataSource;
import com.example.mealrecipes.model.Meal;

import java.util.ArrayList;
import java.util.List;

public class MealRepoImpl implements MealRepo {
    private iDataSource databaseSource;
    private iDataSource networkSource;

    public MealRepoImpl(iDataSource databaseSource, iDataSource networkSource) {
        this.databaseSource = databaseSource;
        this.networkSource = networkSource;
    }


    @Override
    public void getAllMealFromDateBase(ListenerRepository listenerRepository) {
        databaseSource.getAllData(listenerRepository);
    }

    @Override
    public void getMealsByName(String name, final ListenerRepository listenerRepository) {
        ListenerRepository listener = new ListenerRepository() {
            @Override
            public void RepositoryReturn(List<Meal> mealList) {
                if ( mealList == null){
                    listenerRepository.RepositoryReturn(new ArrayList<Meal>());
                } else {
                    listenerRepository.RepositoryReturn(mealList);
                }
            }
        };
        networkSource.getDataByName(name, listener);
    }

    @Override
    public void insert(Meal meal) {
        databaseSource.insertMeal(meal);
    }
}
