package com.example.diceheadproj.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.RenderEffect;
import android.graphics.Shader;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.diceheadproj.R;

public class GenerateDiceActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_dice);

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
    }
    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.imageBackArrowDice:
                Intent intentNoLogin = new Intent(this,NoLoginFirstActivity.class);
                startActivity(intentNoLogin);
                break;
            default:
                break;
        }
    }
}