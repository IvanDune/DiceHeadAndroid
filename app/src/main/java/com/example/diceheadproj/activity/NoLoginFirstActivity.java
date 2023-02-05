package com.example.diceheadproj.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.RenderEffect;
import android.graphics.Shader;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.diceheadproj.R;

public class NoLoginFirstActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_loggin_first);

        ImageView imageGenerateCharacter = findViewById(R.id.imageGenerateCharacter);
        ImageView imageCreateCharacter = findViewById(R.id.imageCreateCharacter);
        ConstraintLayout constraintLayoutCreateProfile = findViewById(R.id.constraintLayoutCreateProfile);
        Button generateButton = findViewById(R.id.generateDice);


        generateButton.setOnClickListener(this);
        imageGenerateCharacter.setOnClickListener(this);
        imageCreateCharacter.setOnClickListener(this);
        constraintLayoutCreateProfile.setOnClickListener(this);

        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.constraintLayoutStarsNoLogIn);
        int childStars = constraintLayout.getChildCount();
        for(int i =0; i< childStars;i++){
            View v = constraintLayout.getChildAt(i);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                v.setRenderEffect(RenderEffect.createBlurEffect(3,3, Shader.TileMode.MIRROR));
            }

        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.generateDice:
                Intent intGenDice = new Intent(this,GenerateDiceActivity.class);
                startActivity(intGenDice);
                break;
            case R.id.imageCreateCharacter:
                Intent intCreateChar = new Intent(this, CharacterActivity.class);
                startActivity(intCreateChar);
                break;
            case R.id.imageGenerateCharacter:
                Intent intGenChar = new Intent(this, GenerateDiceActivity.class);
                startActivity(intGenChar);
                break;
            case R.id.constraintLayoutCreateProfile:
                Intent intCreateProfile = new Intent(this,LogInActivity.class);
                startActivity(intCreateProfile);
                break;
            default:
                break;
        }

    }
}