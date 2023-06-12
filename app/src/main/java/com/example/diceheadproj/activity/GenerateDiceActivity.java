package com.example.diceheadproj.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.RenderEffect;
import android.graphics.Shader;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.diceheadproj.R;
import com.example.diceheadproj.logic.Randomizer;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.List;

public class GenerateDiceActivity extends AppCompatActivity implements View.OnClickListener{

    int numberOfDice;
    int modDice;
    int[] valueDice = {4,6,8,10,12,20};
    int value;

    ChipGroup chipGroup;
    ChipGroup chipGroupMod;
    GridLayout chipGroupValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_dice);

        numberOfDice = 0;
        modDice = 0;
        value = 0;

        ConstraintLayout constraintLayoutDiceStars = (ConstraintLayout) findViewById(R.id.constraintLayoutGenDiceStar);
        int childStars = constraintLayoutDiceStars.getChildCount();
        for(int i =0;i<childStars;i++){
            View v = constraintLayoutDiceStars.getChildAt(i);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                v.setRenderEffect(RenderEffect.createBlurEffect(3,3, Shader.TileMode.MIRROR));
            }
        }



        ImageView imageBackArrowDice = (ImageView) findViewById(R.id.imageBackArrowDice);
        imageBackArrowDice.setOnClickListener(this);

        Button buttonRoll = (Button) findViewById(R.id.buttonRollDice);
        buttonRoll.setOnClickListener(this);

        Button buttonClear = (Button) findViewById(R.id.buttonClearDice);
        buttonClear.setOnClickListener(this);

        chipGroup = findViewById(R.id.chipGroupNumberOfDice);
        chipGroupMod = findViewById(R.id.chipGroupMod);
        chipGroupValue= findViewById(R.id.chipGroupValue);

        for(int i=0; i<chipGroup.getChildCount(); i++) {
            Chip chip = (Chip) chipGroup.getChildAt(i);

            chip.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    numberOfDice=Integer.parseInt(chip.getText().toString());

                    for (int j=0;j<chipGroup.getChildCount();j++){
                        Chip chipColor = (Chip) chipGroup.getChildAt(j);
                        if (j+1==numberOfDice){
                            chip.setTextColor(Color.parseColor("#040719"));
                            chip.setChipBackgroundColor(ColorStateList.valueOf(Color.parseColor("#9C80E7")));
                        } else{
                            chipColor.setTextColor(Color.parseColor("#9C80E7"));
                            chipColor.setChipBackgroundColor(ColorStateList.valueOf(Color.parseColor("#040719")));
                        }
                    }
                }
            });
        }

        for(int i=0; i<chipGroupMod.getChildCount(); i++) {
            Chip chip = (Chip) chipGroupMod.getChildAt(i);

            chip.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    modDice=Integer.parseInt(chip.getText().toString());

                    for (int j=0;j<chipGroup.getChildCount();j++){
                        Chip chipColor = (Chip) chipGroupMod.getChildAt(j);
                        if (j+1==modDice){
                            chip.setTextColor(Color.parseColor("#040719"));
                            chip.setChipBackgroundColor(ColorStateList.valueOf(Color.parseColor("#9C80E7")));
                        } else{
                            chipColor.setTextColor(Color.parseColor("#9C80E7"));
                            chipColor.setChipBackgroundColor(ColorStateList.valueOf(Color.parseColor("#040719")));
                        }
                    }
                }
            });
        }

        for(int i=0; i<chipGroupValue.getChildCount(); i++) {
            Chip chip = (Chip) chipGroupValue.getChildAt(i);

            Integer finalI = i;
            chip.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    value=Integer.parseInt(chip.getText().toString().trim().substring(1));

                    for (int j=0;j<chipGroupValue.getChildCount();j++){
                        Chip chipColor = (Chip) chipGroupValue.getChildAt(j);
                        chipColor.setTextColor(Color.parseColor("#9C80E7"));
                        chipColor.setChipBackgroundColor(ColorStateList.valueOf(Color.parseColor("#040719")));
                    }
                    chip.setTextColor(Color.parseColor("#040719"));
                    chip.setChipBackgroundColor(ColorStateList.valueOf(Color.parseColor("#9C80E7")));

                }
            });
        }

    }
    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.imageBackArrowDice:
                Intent intentNoLogin = new Intent(this,NoLoginFirstActivity.class);
                startActivity(intentNoLogin);
                break;
            case R.id.buttonClearDice:
                numberOfDice = 0;
                for(int i=0; i<chipGroup.getChildCount(); i++) {
                    Chip chip = (Chip) chipGroup.getChildAt(i);
                    chip.setTextColor(Color.parseColor("#9C80E7"));
                    chip.setChipBackgroundColor(ColorStateList.valueOf(Color.parseColor("#040719")));
                }

                modDice=0;
                for(int i=0; i<chipGroupMod.getChildCount(); i++) {
                    Chip chip = (Chip) chipGroupMod.getChildAt(i);
                    chip.setTextColor(Color.parseColor("#9C80E7"));
                    chip.setChipBackgroundColor(ColorStateList.valueOf(Color.parseColor("#040719")));
                }

                value=0;
                for(int i=0; i<chipGroupValue.getChildCount(); i++) {
                    Chip chip = (Chip) chipGroupValue.getChildAt(i);
                    chip.setTextColor(Color.parseColor("#9C80E7"));
                    chip.setChipBackgroundColor(ColorStateList.valueOf(Color.parseColor("#040719")));
                }
                break;
            case R.id.buttonRollDice:
                int result = Randomizer.rand(value,modDice,numberOfDice);

                TextView diceChoice = (TextView) findViewById(R.id.textDiceChoice);
                diceChoice.setText(numberOfDice + "d" + value);

                TextView diceResult = (TextView) findViewById(R.id.diceResult);
                diceResult.setText(Integer.toString(result));

                break;
            default:
                break;
        }
    }
}