package com.example.mealrecipes.adapters;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mealrecipes.R;
import com.example.mealrecipes.dataRepository.RepoInstance;
import com.example.mealrecipes.model.Meal;

import java.util.List;
import java.util.concurrent.Executor;


public class MyRecipesAdapter extends RecyclerView.Adapter<MyRecipesAdapter.ViewHolder> {

    private Context context;
    List<Meal> mealModelList;

    public MyRecipesAdapter(List<Meal> mealModelList, Context context) {
        this.mealModelList = mealModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipes_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Meal mealModel = mealModelList.get(holder.getAdapterPosition());
        holder.tvIdMeal.setText(mealModel.getIdMeal());
        holder.tvMeal.setText(mealModel.getStrMeal());
        holder.tvCategory.setText(mealModel.getStrCategory());
        holder.tvArea.setText(mealModel.getStrArea());
        holder.tvInstructions.setText(mealModel.getStrInstructions());
        Glide.with(context).load(mealModel.getStrMealThumb()).into(holder.strMealThumb);

    }
    public void addItems(List<Meal>newMeals){
        mealModelList.addAll(newMeals);
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        return mealModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView strMealThumb;
        TextView tvIdMeal;
        TextView tvMeal;
        TextView tvCategory;
        TextView tvArea;
        TextView tvInstructions;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            strMealThumb = itemView.findViewById(R.id.strMealThumb);
            tvIdMeal = itemView.findViewById(R.id.tvIdMeal);
            tvMeal = itemView.findViewById(R.id.tvMeal);
            tvCategory = itemView.findViewById(R.id.tvCategory);
            tvArea = itemView.findViewById(R.id.tvArea);
            tvInstructions = itemView.findViewById(R.id.tvInstructions);

        }
    }
}

