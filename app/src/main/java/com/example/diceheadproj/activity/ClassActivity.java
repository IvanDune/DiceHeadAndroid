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
//import com.example.diceheadproj.domain.Classes;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class ClassActivity extends AppCompatActivity implements View.OnClickListener{
//    RecyclerView recyclerViewClasses;
//    ChoiceAdapter choiceAdapter;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_class);
//
//        List<String> classes = new ArrayList<>();
//        Classes[] cl = Classes.values();
//        for(Classes c : cl){
//            classes.add(c.name());
//        }
//
//        ImageView imageViewBackArrow = (ImageView) findViewById(R.id.imageBackArrow);
//        imageViewBackArrow.setOnClickListener(this);
//
//        setChoiceRecycler(classes);
//    }
//
//    private void setChoiceRecycler(List<String> classes) {
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
//
//        recyclerViewClasses = findViewById(R.id.recyclerViewClasses);
//        recyclerViewClasses.setLayoutManager(layoutManager);
//
//        choiceAdapter = new ChoiceAdapter(this,classes);
//        recyclerViewClasses.setAdapter(choiceAdapter);
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