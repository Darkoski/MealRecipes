package com.example.mealrecipes.dataRepository.RoomDatabase;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.mealrecipes.model.Meal;

@Database(entities = {Meal.class}, version = 1)
public abstract class MealDataBase extends RoomDatabase {
    static MealDataBase INSTANCE;
    public abstract MealDao mealDao();

    public static MealDataBase getINSTANCE(Context context) {
        if (INSTANCE == null) {
            synchronized (MealDataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context, MealDataBase.class, "db-meal").addCallback(new Callback() {
                        @Override
                        public void onOpen(@NonNull SupportSQLiteDatabase db) {
                            super.onOpen(db);
                        }
                    })
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public MealDao getMealDao() {
        return mealDao();
    }
}
