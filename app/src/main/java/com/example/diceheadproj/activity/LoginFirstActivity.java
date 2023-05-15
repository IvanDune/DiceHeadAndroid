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

public class LoginFirstActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_first);

        init();


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imageCreateCharacter:
                Intent intCreateChar = new Intent(this, CharacterActivity.class);
                startActivity(intCreateChar);
                break;
            case R.id.imageGenerateCharacter:
                Intent intGenChar = new Intent(this, GenerateDiceActivity.class);
                startActivity(intGenChar);
                break;
            case R.id.generateDiceLogin:
                Intent intGenDice = new Intent(this,GenerateDiceActivity.class);
                startActivity(intGenDice);
                break;
            default:
                break;
        }
    }

    private void init(){
        ImageView imageGenerateCharacter = findViewById(R.id.imageGenerateCharacter);
        ImageView imageCreateCharacter = findViewById(R.id.imageCreateCharacter);
        Button generateDice = (Button) findViewById(R.id.generateDiceLogin);

        imageGenerateCharacter.setOnClickListener(this);
        imageCreateCharacter.setOnClickListener(this);
        generateDice.setOnClickListener(this);

        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.constraintLayoutStarsLogin);
        int childStars = constraintLayout.getChildCount();
        for(int i =0; i< childStars;i++){
            View v = constraintLayout.getChildAt(i);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                v.setRenderEffect(RenderEffect.createBlurEffect(3,3, Shader.TileMode.MIRROR));
            }

        }
    }
}