package com.example.diceheadproj.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.diceheadproj.R;
import com.example.diceheadproj.domain.WeaponMin;

import java.util.List;

public class WeaponAdapter extends RecyclerView.Adapter<WeaponAdapter.WeaponViewHolder> {
    Context context;
    List<WeaponMin> weapon;

    public WeaponAdapter(Context context, List<WeaponMin> weapon) {
        this.context = context;
        this.weapon = weapon;
    }

    @NonNull
    @Override
    public WeaponAdapter.WeaponViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View weaponItems = LayoutInflater.from(context).inflate(R.layout.weapon_item,parent,false);
        return new WeaponAdapter.WeaponViewHolder(weaponItems);
    }

    @Override
    public void onBindViewHolder(@NonNull WeaponAdapter.WeaponViewHolder holder, int position) {
        holder.weaponName.setText(weapon.get(position).getName().toString());
        holder.weaponDesc.setText(weapon.get(position).getDescription().toString());
        holder.weaponType.setText(weapon.get(position).getType().toString());
    }

    @Override
    public int getItemCount() {
        return weapon.size();
    }

    public static final class WeaponViewHolder extends RecyclerView.ViewHolder{
        TextView weaponName;
        TextView weaponDesc;
        TextView weaponType;

        public WeaponViewHolder(@NonNull View itemView) {
            super(itemView);
            weaponName = (TextView) itemView.findViewById(R.id.weaponName);
            weaponDesc = (TextView) itemView.findViewById(R.id.weaponDescription);
            weaponType = (TextView) itemView.findViewById(R.id.weaponType);
        }
    }
}
