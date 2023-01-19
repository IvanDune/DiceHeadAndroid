package com.example.diceheadproj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.content.Intent;
import android.graphics.RenderEffect;
import android.graphics.Shader;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class StartActivity extends AppCompatActivity implements View.OnTouchListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_page);

        ConstraintLayout constraintLayoutStarsStartPage = (ConstraintLayout) findViewById(R.id.constraintLayoutStarsStartPage);
        int childCountStars = constraintLayoutStarsStartPage.getChildCount();
        for(int i = 0;i<childCountStars;i++){
            View v = constraintLayoutStarsStartPage.getChildAt(i);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                v.setRenderEffect(RenderEffect.createBlurEffect(3,3, Shader.TileMode.MIRROR));
            }
        }

        ConstraintLayout constraintLayoutDicesStartPage = (ConstraintLayout) findViewById(R.id.constraintLayoutDicesStartPage);
        int childCountDices = constraintLayoutDicesStartPage.getChildCount();
        for(int i = 0;i<childCountDices;i++){
            View v = constraintLayoutDicesStartPage.getChildAt(i);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                v.setRenderEffect(RenderEffect.createBlurEffect(5,5, Shader.TileMode.MIRROR));
            }
        }

        ImageView imageD12 = findViewById(R.id.imageD12);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            imageD12.setRenderEffect(RenderEffect.createBlurEffect(2, 2, Shader.TileMode.MIRROR));
        }

        ImageView imageLight = (ImageView) findViewById(R.id.imageLight);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            imageLight.setRenderEffect(RenderEffect.createBlurEffect(25,25, Shader.TileMode.MIRROR));
        }
        ConstraintLayout startPageLayout = (ConstraintLayout) findViewById(R.id.startPageLayout);
        startPageLayout.setOnTouchListener(this);
//        setContentView(startPageLayout);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if(motionEvent.getAction()==MotionEvent.ACTION_DOWN){
            Intent intLog = new Intent(this, MainActivity.class);
            startActivity(intLog);
        }
        return false;
    }
}