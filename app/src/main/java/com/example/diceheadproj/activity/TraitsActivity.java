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

public class TraitsActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traits);

        ImageView imageViewBackArrow = (ImageView) findViewById(R.id.imageBackArrow);
        Button buttonSave = (Button) findViewById(R.id.buttonSave);

        ConstraintLayout constraintLayoutTraitsStars = (ConstraintLayout) findViewById(R.id.constraintLayoutTraitsStars);
        int childStars = constraintLayoutTraitsStars.getChildCount();
        for(int i =0;i<childStars;i++){
            View v = constraintLayoutTraitsStars.getChildAt(i);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                v.setRenderEffect(RenderEffect.createBlurEffect(3,3, Shader.TileMode.MIRROR));
            }
        }

        imageViewBackArrow.setOnClickListener(this);
        buttonSave.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.imageBackArrow:
                Intent intentBackCharacter = new Intent(this,CharacterActivity.class);
                startActivity(intentBackCharacter);
                break;
            case R.id.buttonSave:
                Intent intentSave = new Intent(this,CharacterActivity.class);
                startActivity(intentSave);
                break;
            default:
                break;


        }

    }
}