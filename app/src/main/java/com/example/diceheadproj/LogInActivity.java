package com.example.diceheadproj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.RenderEffect;
import android.graphics.Shader;
import android.os.Build;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class LogInActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        TextView textCreateAccountLogIn = (TextView) findViewById(R.id.textSignInLogIn);
        textCreateAccountLogIn.setOnClickListener(this);

        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.constraintLayoutStarsLogIn);
        int childCount = constraintLayout.getChildCount();
        for(int i=0;i<childCount;i++){
            View v = constraintLayout.getChildAt(i);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                v.setRenderEffect(RenderEffect.createBlurEffect(3,3, Shader.TileMode.MIRROR));
            }
        }

        ImageView imageLight = (ImageView) findViewById(R.id.imageLight);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            imageLight.setRenderEffect(RenderEffect.createBlurEffect(25,25, Shader.TileMode.MIRROR));
        }
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.textSignInLogIn:
                Intent intent = new Intent(this,SignInActivity.class);
                startActivity(intent);
                break;
            default:
                break;

        }
    }
}