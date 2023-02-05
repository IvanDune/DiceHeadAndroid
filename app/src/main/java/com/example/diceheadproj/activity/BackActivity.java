package com.example.diceheadproj.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.diceheadproj.R;
import com.example.diceheadproj.adapter.ChoiceAdapter;
import com.example.diceheadproj.domain.Backstory;
import com.example.diceheadproj.domain.Outlook;

import java.util.ArrayList;
import java.util.List;

public class BackActivity extends AppCompatActivity implements View.OnClickListener {
    RecyclerView back;
    ChoiceAdapter choiceAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back);

        List<String> list = new ArrayList<>();
        Backstory[] backs = Backstory.values();
        for(Backstory o: backs){
            list.add(o.name());
        }


        ImageView imageViewBackArrow = (ImageView) findViewById(R.id.imageBackArrow);
        imageViewBackArrow.setOnClickListener(this);

        setChoiceAdapter(list);
    }
    private void setChoiceAdapter(List<String> list) {
        back = (RecyclerView) findViewById(R.id.recyclerViewBack);
        choiceAdapter = new ChoiceAdapter(this,list);
        back.setAdapter(choiceAdapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);

        back.setLayoutManager(layoutManager);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.imageBackArrow:
                Intent intentBackCharacter = new Intent(this,CharacterActivity.class);
                startActivity(intentBackCharacter);
                break;
        }
    }
}