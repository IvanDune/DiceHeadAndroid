package com.example.diceheadproj.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.RenderEffect;
import android.graphics.Shader;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;

import com.example.diceheadproj.R;
import com.example.diceheadproj.adapter.CharacterAdapter;
import com.example.diceheadproj.domain.dnd.characters.Character_DND;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class LoginFirstActivity extends AppCompatActivity implements View.OnClickListener{
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

    ObjectMapper objectMapper = new ObjectMapper();
    CharacterAdapter characterAdapter;
    RecyclerView characterRec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_first);

        init();

        List<Character_DND> character_dndList = new ArrayList<>();

        characters_dr.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    String st = dataSnapshot.getValue().toString();
                    Character_DND character_dnd = new Character_DND();
                    try {
                        character_dnd = objectMapper.readValue(st,Character_DND.class);
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    }
                    String ch_em = character_dnd.getUserEmail();
                    String au_em = auth.getCurrentUser().getEmail().toString();

                    if (ch_em.equals(au_em)){
                        character_dndList.add(character_dnd);
                    }

                    }
                }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        setCharacterRecycler(character_dndList);
    }

    private void setCharacterRecycler(List<Character_DND> character_dndList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);

        characterRec = findViewById(R.id.characterRecycler);
        characterRec.setLayoutManager(layoutManager);

        characterAdapter = new CharacterAdapter(this, character_dndList);
        characterRec.setAdapter(characterAdapter);
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

        db = FirebaseDatabase.getInstance();
        characters_dr = db.getReference(CHARACTER_KEY);
        characteristics_dr = db.getReference(CHARACTERISTICS_KEY);
        skill_dr = db.getReference(SKILL_KEY);
        root = (ConstraintLayout) findViewById(R.id.constraintLayoutCharacter);
        auth = FirebaseAuth.getInstance();
        users_dr = db.getReference(USER_KEY); // Где хранятся пользователи

    }
}