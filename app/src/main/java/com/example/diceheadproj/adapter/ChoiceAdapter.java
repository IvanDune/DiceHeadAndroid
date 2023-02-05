package com.example.diceheadproj.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.diceheadproj.R;

import java.util.List;

public class ChoiceAdapter extends RecyclerView.Adapter<ChoiceAdapter.ChoiceViewHolder> {
    Context context;
    List<String> choices;

    public ChoiceAdapter(Context context, List<String> choices) {
        this.context = context;
        this.choices = choices;
    }

    @NonNull
    @Override
    public ChoiceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View choiceItem = LayoutInflater.from(context).inflate(R.layout.choice_item,parent,false);
        return new ChoiceViewHolder(choiceItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ChoiceViewHolder holder, int position) {
        holder.choiceItem.setText(choices.get(position));
    }

    @Override
    public int getItemCount() {
        return choices.size();
    }

    public static final class ChoiceViewHolder extends RecyclerView.ViewHolder{
        TextView choiceItem;

        public ChoiceViewHolder(@NonNull View itemView) {
            super(itemView);
            choiceItem = itemView.findViewById(R.id.choiceItem);
        }
    }
}
