package com.example.diceheadproj.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.diceheadproj.R;
import com.example.diceheadproj.domain.dnd.characters.Character_DND;

import java.util.List;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>  {

    Context context;
    List<Character_DND> character_dndList;

    public CharacterAdapter(Context context, List<Character_DND> character_dndList){
        this.context = context;
        this.character_dndList = character_dndList;
    }

    @NonNull
    @Override
    public CharacterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { // Дизайн
        View characterItems = LayoutInflater.from(context).inflate(R.layout.character_item,parent,false);
        return new CharacterAdapter.CharacterViewHolder(characterItems);
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterViewHolder holder, int position) { // Что подставлять в дизайн

        holder.characterName.setText(character_dndList.get(position).getName().toString());
        holder.raceName.setText(character_dndList.get(position).getRaceName().toString());
        holder.className.setText(character_dndList.get(position).getClassName().toString());

        holder.level.setText(Integer.toString(character_dndList.get(position).getLevel()));
        holder.masterBonus.setText(Integer.toString(character_dndList.get(position).getMasterBonus()));

        holder.strengthCount.setText(Integer.toString(character_dndList.get(position).getCharacteristics().getStrength()));
        holder.dexterityCount.setText(Integer.toString(character_dndList.get(position).getCharacteristics().getDexterity()));
        holder.constitutionCount.setText(Integer.toString(character_dndList.get(position).getCharacteristics().getConstitution()));
        holder.intelligenceCount.setText(Integer.toString(character_dndList.get(position).getCharacteristics().getIntelligence()));
        holder.wisdomCount.setText(Integer.toString(character_dndList.get(position).getCharacteristics().getWisdom()));
        holder.charismaCount.setText(Integer.toString(character_dndList.get(position).getCharacteristics().getCharisma()));
    }

    @Override
    public int getItemCount() { // С какими полями
        return character_dndList.size();
    }

    public static final class CharacterViewHolder extends RecyclerView.ViewHolder{

        TextView characterName;
        TextView raceName;
        TextView className;

        TextView strengthCount, dexterityCount, constitutionCount,intelligenceCount;
        TextView wisdomCount, charismaCount;

        TextView level;
        TextView masterBonus;


        public CharacterViewHolder(@NonNull View itemView) {
            super(itemView);

            characterName = itemView.findViewById(R.id.textCharacterName);
            raceName = itemView.findViewById(R.id.textRace);
            className = itemView.findViewById(R.id.textClass);

            strengthCount = itemView.findViewById(R.id.textStrength);
            dexterityCount = itemView.findViewById(R.id.textDexterity);
            constitutionCount = itemView.findViewById(R.id.textConstitution);
            intelligenceCount = itemView.findViewById(R.id.textIntelligence);
            wisdomCount = itemView.findViewById(R.id.textWisdom);
            charismaCount = itemView.findViewById(R.id.textCharisma);

            level = itemView.findViewById(R.id.textLevel);
            masterBonus = itemView.findViewById(R.id.textMasterBonus);

        }
    }
}
