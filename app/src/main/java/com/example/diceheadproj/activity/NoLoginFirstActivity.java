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
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NoLoginFirstActivity extends AppCompatActivity implements View.OnClickListener {
    private String CHARACTER_KEY = "Characters";
    private String CHARACTERISTICS_KEY = "Characteristic";
    private String SKILL_KEY = "Skills";
    private String USER_KEY = "Users";

    ConstraintLayout root;
    FirebaseAuth auth;
    FirebaseDatabase db;
    DatabaseReference users_dr;
    DatabaseReference characters_dr;
    DatabaseReference characteristics_dr;
    DatabaseReference skill_dr;

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

        db = FirebaseDatabase.getInstance();
        characters_dr = db.getReference(CHARACTER_KEY);
        characteristics_dr = db.getReference(CHARACTERISTICS_KEY);
        skill_dr = db.getReference(SKILL_KEY);
        root = (ConstraintLayout) findViewById(R.id.constraintLayoutNoLoggin);
        auth = FirebaseAuth.getInstance();
        users_dr = db.getReference(USER_KEY); // Где хранятся пользователи

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
                intCreateChar.putExtra("genChar",0);
                intCreateChar.putExtra("weapon","");
                startActivity(intCreateChar);
                break;
            case R.id.imageGenerateCharacter:
                Intent intGenChar = new Intent(this, CharacterActivity.class);
                intGenChar.putExtra("genChar",1);
                intGenChar.putExtra("weapon","");
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