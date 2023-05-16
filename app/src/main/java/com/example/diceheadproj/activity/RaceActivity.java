//package com.example.diceheadproj.activity;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.ImageView;
//
//import com.example.diceheadproj.R;
//import com.example.diceheadproj.adapter.ChoiceAdapter;
//import com.example.diceheadproj.domain.Races;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class RaceActivity extends AppCompatActivity implements View.OnClickListener{
//    RecyclerView races;
//    ChoiceAdapter choiceAdapter;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_race);
//
//        List<String> rcs = new ArrayList<>();
//        Races[] rcEnum = Races.values();
//        for(Races r : rcEnum){
//            rcs.add(r.name());
//        }
//
//        ImageView imageViewBackArrow = (ImageView) findViewById(R.id.imageBackArrow);
//        imageViewBackArrow.setOnClickListener(this);
//
//
//        setChoiceRecycler(rcs);
//    }
//
//    private void setChoiceRecycler(List<String> rcs) {
//        choiceAdapter = new ChoiceAdapter(this,rcs);
//        races = (RecyclerView) findViewById(R.id.recyclerViewRaces);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
//
//        races.setAdapter(choiceAdapter);
//        races.setLayoutManager(layoutManager);
//    }
//
//    @Override
//    public void onClick(View view) {
//        switch(view.getId()){
//            case R.id.imageBackArrow:
//                Intent intentBackCharacter = new Intent(this,CharacterActivity.class);
//                startActivity(intentBackCharacter);
//                break;
//        }
//    }
//}