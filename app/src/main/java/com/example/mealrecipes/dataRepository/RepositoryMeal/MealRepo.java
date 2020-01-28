package com.example.mealrecipes.dataRepository.RepositoryMeal;

import com.example.mealrecipes.Listeners.ListenerRepository;
import com.example.mealrecipes.model.Meal;

public interface MealRepo {
    void getAllMealFromDateBase(ListenerRepository listenerRepository);
    void getMealsByName(String name, ListenerRepository listenerRepository);
    void insert(Meal meal);
}

