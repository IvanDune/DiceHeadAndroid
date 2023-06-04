package com.example.diceheadproj.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.diceheadproj.R;

public class WeaponActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weapon);
        init();
    }

    private void init(){
        ImageView backArrow = (ImageView) findViewById(R.id.imageBackArrow);
        backArrow.setOnClickListener(this);

        Button buttonAdd = (Button) findViewById(R.id.saveAddButton);
        buttonAdd.setOnClickListener(this);

        TextView textAdd = (TextView) findViewById(R.id.textViewAdd);
        textAdd.setOnClickListener(this);

        TextView textAddNFC = (TextView) findViewById(R.id.textViewAddNFC);
        textAddNFC.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imageBackArrow://Back to character
                Intent intentBackCharacter = new Intent(this,CharacterActivity.class);
                startActivity(intentBackCharacter);
                break;
            case R.id.saveAddButton://Save changes
                Intent intentBackCharacterSave = new Intent(this,CharacterActivity.class);
                startActivity(intentBackCharacterSave);
                break;
            case R.id.textViewAdd://Add weapon
                break;
            case R.id.textViewAddNFC://Add weapon with NFC
                break;
            default:
                break;
        }

    }
}