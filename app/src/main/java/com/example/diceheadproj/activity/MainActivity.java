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
import android.widget.TextView;
import android.widget.Toast;

import com.example.diceheadproj.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);

        Button butCreate = (Button) findViewById(R.id.createButton);
        TextView textSignIn = (TextView) findViewById(R.id.textLogIn);
        TextView textRegistNo = (TextView) findViewById(R.id.textRegistNo);
        // создаем обработчик нажатия

        butCreate.setOnClickListener(this);
        textSignIn.setOnClickListener(this);
        textRegistNo.setOnClickListener(this);


        ConstraintLayout constraintLayoutStars = (ConstraintLayout) findViewById(R.id.constraintLayoutStars);
        int childCountStars = constraintLayoutStars.getChildCount();
        for(int i = 0;i<childCountStars;i++){
            View v = constraintLayoutStars.getChildAt(i);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                v.setRenderEffect(RenderEffect.createBlurEffect(3,3, Shader.TileMode.MIRROR));
            }
        }

        ConstraintLayout constraintLayoutDices = (ConstraintLayout) findViewById(R.id.constraintLayoutDices);
        int childCountDices = constraintLayoutDices.getChildCount();
        for(int i = 0;i<childCountDices;i++){
            View v = constraintLayoutDices.getChildAt(i);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                v.setRenderEffect(RenderEffect.createBlurEffect(5,5, Shader.TileMode.MIRROR));
            }
        }


        ImageView imageD20 = findViewById(R.id.imageD20);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            imageD20.setRenderEffect(RenderEffect.createBlurEffect(2, 2, Shader.TileMode.MIRROR));
        }

        ImageView imageLight = findViewById(R.id.imageLight);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            imageLight.setRenderEffect(RenderEffect.createBlurEffect(25,25, Shader.TileMode.MIRROR));
}


    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.textLogIn:
                Toast.makeText(this, "Переход на экран Входа", Toast.LENGTH_SHORT).show();
                Intent intLog = new Intent(this, SignInActivity.class);
                startActivity(intLog);
                break;
            case R.id.createButton:
                Intent intSign = new Intent(this, LogInActivity.class);
                startActivity(intSign);
                break;
            case R.id.textRegistNo:
                Intent intRegistNo = new Intent(this, NoLoginFirstActivity.class);
                startActivity(intRegistNo);
                break;
            default:
                break;

        }
        }
}