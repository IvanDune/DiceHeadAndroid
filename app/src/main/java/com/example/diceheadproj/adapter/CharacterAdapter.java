package com.example.diceheadproj.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.diceheadproj.domain.dnd.characters.Character_DND;
import com.google.firebase.database.core.Context;

import java.util.List;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>  {

    Context context;
    List<Character_DND> character_dndList;

    @NonNull
    @Override
    public CharacterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { // Дизайн
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterViewHolder holder, int position) { // Что подставлять в дизайн

    }

    @Override
    public int getItemCount() { // С какими полями
        return character_dndList.size();
    }

    public static final class CharacterViewHolder extends RecyclerView.ViewHolder{

        public CharacterViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
