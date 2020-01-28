package com.example.mealrecipes;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.mealrecipes.Listeners.OpenSavedRecipesListener;
import com.example.mealrecipes.fragments.MainFragment;
import com.example.mealrecipes.fragments.MyRecipes;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        OpenSavedRecipesListener openSavedRecipesListener = new OpenSavedRecipesListener() {
            @Override
            public void open() {
                MyRecipes myRecipes = new MyRecipes();
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.frameLayout,myRecipes );
                ft.addToBackStack(null);
                ft.commit();
            }
        };

        MainFragment mainFragment = new MainFragment(openSavedRecipesListener);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frameLayout, mainFragment);
        ft.commit();


    }


}
