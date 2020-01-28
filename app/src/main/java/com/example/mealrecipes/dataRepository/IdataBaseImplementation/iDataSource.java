package com.example.mealrecipes.dataRepository.IdataBaseImplementation;

import com.example.mealrecipes.Listeners.ListenerRepository;
import com.example.mealrecipes.model.Meal;

public interface iDataSource {
    void getAllData(ListenerRepository listenerRepository);

    void getDataByName(String name, ListenerRepository listenerRepository);

    void insertMeal(Meal meal);
}
