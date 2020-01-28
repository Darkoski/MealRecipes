package com.example.mealrecipes.fragments;


import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mealrecipes.Listeners.ListenerRepository;
import com.example.mealrecipes.Listeners.OpenSavedRecipesListener;
import com.example.mealrecipes.R;
import com.example.mealrecipes.adapters.MealsAdapter;
import com.example.mealrecipes.adapters.MyRecipesAdapter;
import com.example.mealrecipes.dataRepository.RepoInstance;
import com.example.mealrecipes.model.Meal;

import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executor;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyRecipes extends Fragment {


    public MyRecipes() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_my_recipes, container, false);


        final RecyclerView recyclerView = rootView.findViewById(R.id.myRecipesRV);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        new Thread(new Runnable() {
            @Override
            public void run() {
                RepoInstance.getINSTANCE(getContext()).getAllMealFromDateBase(new ListenerRepository() {
                    @Override
                    public void RepositoryReturn(final List<Meal> mealList) {
                        getActivity().runOnUiThread(new Runnable() {

                            @Override
                            public void run() {
                                final MyRecipesAdapter mealsAdapter = new MyRecipesAdapter(mealList, getContext());
                                recyclerView.setAdapter(mealsAdapter);
                            }
                        });

                    }
                });
            }
        }).start();
        return rootView;

    }

}
