package com.example.diceheadproj.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.diceheadproj.R;
import com.example.diceheadproj.adapter.WeaponAdapter;
import com.example.diceheadproj.domain.WeaponMin;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.android.material.snackbar.Snackbar;

import java.util.LinkedList;
import java.util.List;

public class WeaponActivity extends AppCompatActivity implements View.OnClickListener {

    RecyclerView weaponRec;
    WeaponAdapter weaponAdapter;
    View root;

    ObjectMapper objectMapper = new ObjectMapper();
    List<WeaponMin> weaponMinList = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weapon);
        init();

        // Надо достать список оружия пользователя и передать в setWeaponRecycler;

    }

    private void setWeaponRecycler(List<WeaponMin> weaponMins) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);

        weaponRec = findViewById(R.id.recyclerViewWeapon);
        weaponRec.setLayoutManager(layoutManager);

        weaponAdapter = new WeaponAdapter(this, weaponMins);
        weaponRec.setAdapter(weaponAdapter);
    }

    private void init(){
        ImageView backArrow = (ImageView) findViewById(R.id.imageBackArrow);
        backArrow.setOnClickListener(this);

        Button buttonAdd = (Button) findViewById(R.id.saveAddButton);
        buttonAdd.setOnClickListener(this);

        TextView textAdd = (TextView) findViewById(R.id.textViewAdd);
        textAdd.setOnClickListener(this);

        TextView textAddNFC = (TextView) findViewById(R.id.textViewAddNFC);
        textAddNFC.setOnClickListener(this);

        root = findViewById(R.id.constraintWeaponLayout);

        setWeaponRecycler(weaponMinList);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imageBackArrow://Back to character
                Intent intentBackCharacter = new Intent(this,CharacterActivity.class);
                startActivity(intentBackCharacter);
                break;
            case R.id.saveAddButton://Save changes
                String json = null;
                try {
                    json = objectMapper.writeValueAsString(weaponMinList);
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
                Intent intentBackCharacterSave = new Intent(this,CharacterActivity.class);
                intentBackCharacterSave.putExtra("weapon", json);
                intentBackCharacterSave.putExtra("genChar", 0);
                startActivity(intentBackCharacterSave);
                break;
            case R.id.textViewAdd://Add weapon
                showAddWindow();
                break;
            case R.id.textViewAddNFC://Add weapon with NFC
                break;
            default:
                break;
        }

    }
    private void showAddWindow(){
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Добавьте оружие");
        dialog.setMessage("Здесь вы можете добавить новый артефакт или новое оружие");
        LayoutInflater inflater = LayoutInflater.from(this);
        View addWindow = inflater.inflate(R.layout.weapon_add_window,null);
        dialog.setView(addWindow);

        EditText name = addWindow.findViewById(R.id.textName);
        EditText mod = addWindow.findViewById(R.id.textMod);
        EditText desc = addWindow.findViewById(R.id.textDescription);

        dialog.setNegativeButton("Отменить", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                dialogInterface.dismiss();
            }
        });

        dialog.setPositiveButton("Добавить", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                if (TextUtils.isEmpty(name.getText().toString())){
                    Snackbar.make(root,"Введите название оружия", Snackbar.LENGTH_LONG).show();
                    return;
                }
                if (TextUtils.isEmpty(mod.getText().toString())){
                    Snackbar.make(root,"Введите тип оружия", Snackbar.LENGTH_LONG).show();
                    return;
                }
                if (TextUtils.isEmpty(desc.getText().toString())){
                    Snackbar.make(root,"Введите описание оружия", Snackbar.LENGTH_LONG).show();
                    return;
                }
                WeaponMin weaponMin = new WeaponMin(name.getText().toString(),mod.getText().toString(),desc.getText().toString());
                weaponMinList.add(weaponMin);
                setWeaponRecycler(weaponMinList);

            }
        });
        dialog.show();
    }
}