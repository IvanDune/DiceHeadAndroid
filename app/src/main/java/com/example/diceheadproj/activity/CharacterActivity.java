package com.example.diceheadproj.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.RenderEffect;
import android.graphics.Shader;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.diceheadproj.R;

public class CharacterActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character);

        ConstraintLayout constraintLayoutStars = (ConstraintLayout) findViewById(R.id.constraintLayoutCharacterStars);
        int childCount = constraintLayoutStars.getChildCount();
        for (int i=0;i<childCount;i++){
            View v = constraintLayoutStars.getChildAt(i);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                v.setRenderEffect(RenderEffect.createBlurEffect(3,3, Shader.TileMode.MIRROR));
            }
        }

        LinearLayout linearLayoutTraits = (LinearLayout) findViewById(R.id.linearLayoutTraits);
        ConstraintLayout constraintLayoutRace = (ConstraintLayout) findViewById(R.id.constraintLayoutRace);
        ConstraintLayout constraintLayoutClass = (ConstraintLayout) findViewById(R.id.constraintLayoutClass);
        ConstraintLayout constraintLayoutOutlook = (ConstraintLayout) findViewById(R.id.constraintLayoutOutlook);
        ConstraintLayout constraintLayoutBack = (ConstraintLayout) findViewById(R.id.constraintLayoutBack);

        linearLayoutTraits.setOnClickListener(this);
        constraintLayoutRace.setOnClickListener(this);
        constraintLayoutClass.setOnClickListener(this);
        constraintLayoutOutlook.setOnClickListener(this);
        constraintLayoutBack.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.linearLayoutTraits:
                Intent intentTraits = new Intent(this,TraitsActivity.class);
                startActivity(intentTraits);
                break;
            case R.id.constraintLayoutRace:
                Intent intentRace = new Intent(this, RaceActivity.class);
                startActivity(intentRace);
                break;
            case R.id.constraintLayoutClass:
                Intent intentClass = new Intent(this, ClassActivity.class);
                startActivity(intentClass);
                break;
            case R.id.constraintLayoutOutlook:
                Intent intentOutlook = new Intent(this, OutlookActivity.class);
                startActivity(intentOutlook);
                break;
            case R.id.constraintLayoutBack:
                Intent intentBack = new Intent(this, BackActivity.class);
                startActivity(intentBack);
                break;
            default:
                break;
        }
    }
}