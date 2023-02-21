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
import android.widget.LinearLayout;

import com.example.diceheadproj.R;

public class CharacterActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView imageLife1 ;
    ImageView imageLife2 ;
    ImageView imageLife3 ;
    ImageView imageDeath1;
    ImageView imageDeath2;
    ImageView imageDeath3;

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
        linearLayoutTraits.setOnClickListener(this);

        ConstraintLayout constraintLayoutRace = (ConstraintLayout) findViewById(R.id.constraintLayoutRace);
        constraintLayoutRace.setOnClickListener(this);

        ConstraintLayout constraintLayoutClass = (ConstraintLayout) findViewById(R.id.constraintLayoutClass);
        constraintLayoutClass.setOnClickListener(this);

        ConstraintLayout constraintLayoutOutlook = (ConstraintLayout) findViewById(R.id.constraintLayoutOutlook);
        constraintLayoutOutlook.setOnClickListener(this);

        ConstraintLayout constraintLayoutBack = (ConstraintLayout) findViewById(R.id.constraintLayoutBack);
        constraintLayoutBack.setOnClickListener(this);

        imageLife1 = (ImageView) findViewById(R.id.imageLife1);
        imageLife1.setOnClickListener(this);

        imageLife2 = (ImageView) findViewById(R.id.imageLife2);
        imageLife2.setOnClickListener(this);

        imageLife3 = (ImageView) findViewById(R.id.imageLife3);
        imageLife3.setOnClickListener(this);

        imageDeath1 = (ImageView) findViewById(R.id.imageDeath1);
        imageDeath1.setOnClickListener(this);

        imageDeath2 = (ImageView) findViewById(R.id.imageDeath2);
        imageDeath2.setOnClickListener(this);

        imageDeath3 = (ImageView) findViewById(R.id.imageDeath3);
        imageDeath3.setOnClickListener(this);

        ImageView backArrow = (ImageView) findViewById(R.id.imageBackArrow);
        backArrow.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imageBackArrow:
                Intent noLoginFirst = new Intent(this,NoLoginFirstActivity.class);
                startActivity(noLoginFirst);
                break;
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
            case R.id.imageLife1:
                if(imageLife1.getAlpha()==0F)
                    imageLife1.ALPHA.set(imageLife1,1F);
                else
                    imageLife1.ALPHA.set(imageLife1,0F);
                break;
            case R.id.imageLife2:
                if(imageLife2.getAlpha()==0F)
                    imageLife2.ALPHA.set(imageLife2,1F);
                else
                    imageLife2.ALPHA.set(imageLife2,0F);
                break;
            case R.id.imageLife3:
                if(imageLife3.getAlpha()==0F)
                    imageLife3.ALPHA.set(imageLife3,1F);
                else
                    imageLife3.ALPHA.set(imageLife3,0F);
                break;
            case R.id.imageDeath1:
                if(imageDeath1.getAlpha()==0F)
                    imageDeath1.ALPHA.set(imageDeath1,1F);
                else
                    imageDeath1.ALPHA.set(imageDeath1,0F);
                break;
            case R.id.imageDeath2:
                if(imageDeath1.getAlpha()==0F)
                    imageDeath2.ALPHA.set(imageDeath2,1F);
                else
                    imageDeath2.ALPHA.set(imageDeath2,0F);
                break;
            case R.id.imageDeath3:
                if(imageDeath1.getAlpha()==0F)
                    imageDeath3.ALPHA.set(imageDeath3,1F);
                else
                    imageDeath3.ALPHA.set(imageDeath3,0F);
                break;
            default:
                break;
        }
    }
}