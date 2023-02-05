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
import com.example.diceheadproj.domain.Outlook;

import java.util.ArrayList;
import java.util.List;

public class OutlookActivity extends AppCompatActivity implements View.OnClickListener{
    RecyclerView outlook;
    ChoiceAdapter choiceAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outlook);

        List<String> list = new ArrayList<>();
        Outlook[] outlooks = Outlook.values();
        for(Outlook o: outlooks){
            list.add(o.name());
        }

        ImageView imageViewBackArrow = (ImageView) findViewById(R.id.imageBackArrow);
        imageViewBackArrow.setOnClickListener(this);

        setChoiceAdapter(list);
    }

    private void setChoiceAdapter(List<String> list) {
        outlook = (RecyclerView) findViewById(R.id.recyclerViewOutlook);
        choiceAdapter = new ChoiceAdapter(this,list);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);

        outlook.setAdapter(choiceAdapter);
        outlook.setLayoutManager(layoutManager);
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