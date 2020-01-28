package com.example.mealrecipes.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Ignore;

import com.example.mealrecipes.Listeners.ListenerRepository;
import com.example.mealrecipes.Listeners.OpenSavedRecipesListener;
import com.example.mealrecipes.R;
import com.example.mealrecipes.RetrofitClient;
import com.example.mealrecipes.adapters.MealsAdapter;
import com.example.mealrecipes.dataRepository.RepoInstance;
import com.example.mealrecipes.domain.DependencyInjection;
import com.example.mealrecipes.domain.GetAllMealsUseCase;
import com.example.mealrecipes.domain.repo.MealsRepo;
import com.example.mealrecipes.model.Meal;
import com.example.mealrecipes.model.MealSearch;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    String getQueryText;
    MealsAdapter mealsAdapter;
    RecyclerView recyclerView;
    OpenSavedRecipesListener listener;

    GetAllMealsUseCase useCase;

    @Ignore
    public MainFragment() {
        // Required empty public constructor
    }


    public MainFragment(OpenSavedRecipesListener listener) {
        this.listener = listener;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_main, container, false);
         recyclerView = rootView.findViewById(R.id.rvRecyclerView);

        useCase = new GetAllMealsUseCase(DependencyInjection.getMealsRepo());

        Toolbar toolbar = rootView.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        setHasOptionsMenu(true);


        return rootView;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_search, menu);
        MenuItem menuItem = menu.findItem(R.id.mSearch);
        menu.findItem(R.id.myRecipeList).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                listener.open();
                return true;
            }
        });
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

                useCase.getMeals().observe(getViewLifecycleOwner(), new Observer<List<Meal>>() {
                    @Override
                    public void onChanged(List<Meal> meals) {
                        mealsAdapter = new MealsAdapter(meals, getContext());
                        recyclerView.setAdapter(mealsAdapter);
                    }
                });

                RepoInstance.getINSTANCE(getContext()).getMealsByName(query, new ListenerRepository() {
                    @Override
                    public void RepositoryReturn(List<Meal> mealList) {
                        mealsAdapter = new MealsAdapter(mealList, getContext());
                        recyclerView.setAdapter(mealsAdapter);
                    }
                });
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });



    }
}
