package com.example.ppadhy.indicapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.ppadhy.indicapp.R;
import com.example.ppadhy.indicapp.RecipeActivity;
import com.example.ppadhy.indicapp.local.RecipeStore;
import com.example.ppadhy.indicapp.model.Recipe;

public class RecipeViewAdapter extends RecyclerView.Adapter<RecipeViewAdapter.RecipeViewHolder> {

    private RecipeStore recipeStore;
    private Context context;

    public RecipeViewAdapter(RecipeStore recipeStore){
        this.recipeStore = recipeStore;
    }

    @NonNull
    @Override
    public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);
        return new RecipeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder holder, int position) {
        Recipe recipe = recipeStore.recipeList.get(position);
        holder.textViewInItem.setText(recipe.title);
    }

    @Override
    public int getItemCount() {
        return recipeStore.recipeList.size();
    }

    class RecipeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView textViewInItem;

        public RecipeViewHolder(View itemView) {
            super(itemView);
            textViewInItem = itemView.findViewById(R.id.textViewInItem);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, RecipeActivity.class);
            intent.putExtra(RecipeActivity.KEY_ID,recipeStore.recipeList.get(getAdapterPosition()).id);
            context.startActivity(intent);
        }
    }
}
