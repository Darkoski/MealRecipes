package com.example.mealrecipes.dataRepository.RoomDatabase;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.mealrecipes.model.Meal;

import java.util.List;

@Dao
public interface MealDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMeal(Meal meal);

    @Query("SELECT * FROM Meal")
    List<Meal> getAllMeals();


}
