package com.example.diceheadproj.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.RenderEffect;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.diceheadproj.R;
import com.example.diceheadproj.domain.Backstory;
import com.example.diceheadproj.domain.Classes;
import com.example.diceheadproj.domain.Outlook;
import com.example.diceheadproj.domain.Races;
import com.example.diceheadproj.domain.dnd.characters.Character_DND;
import com.example.diceheadproj.domain.dnd.characters.CharacterSkill;
import com.example.diceheadproj.domain.dnd.characters.Characteristics;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.core.utilities.PushIdGenerator;
import com.google.firebase.database.snapshot.ChildKey;

import java.util.ArrayList;
import java.util.List;

public class CharacterActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imageLife1, imageLife2, imageLife3, imageDeath1, imageDeath2, imageDeath3 ;

    private ImageView imageHistory, imageSleight, imageMagic, imageMedicine, imageDeception, imageNature, imageInsight, imageReligion;
    private ImageView imageSecrecy, imageConviction, imageAnimal;
    private ImageView imageAcrobatics, imageAnalise, imageAthletics, imagePerception, imageSurvival, imagePerformance, imageIntimidation;

    private Spinner spinnerRace;
    private Spinner spinnerOutlook;
    private Spinner spinnerBack;
    private Spinner spinnerClasses;

    private Characteristics characteristics;

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
        setContentView(R.layout.activity_character);

        ConstraintLayout constraintLayoutStars = (ConstraintLayout) findViewById(R.id.constraintLayoutCharacterStars);
        int childCount = constraintLayoutStars.getChildCount();
        for (int i=0;i<childCount;i++){
            View v = constraintLayoutStars.getChildAt(i);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                v.setRenderEffect(RenderEffect.createBlurEffect(3,3, Shader.TileMode.MIRROR));
            }
        }

        init();


        db = FirebaseDatabase.getInstance();
        characters_dr = db.getReference(CHARACTER_KEY);
        characteristics_dr = db.getReference(CHARACTERISTICS_KEY);
        skill_dr = db.getReference(SKILL_KEY);
        root = (ConstraintLayout) findViewById(R.id.constraintLayoutCharacter);
        auth = FirebaseAuth.getInstance();
        users_dr = db.getReference(USER_KEY); // Где хранятся пользователи

        Button saveCharacterButton = (Button) findViewById(R.id.saveCharacterButton);

        try{
            String st = auth.getCurrentUser().getUid();
            saveCharacterButton.setOnClickListener(this);
            saveCharacterButton.setText("Сохранить изменения");

        } catch (Exception e){
            saveCharacterButton.setText("Авторизируйтесь");

        }


    }

    @SuppressLint("RestrictedApi")
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imageBackArrow:
                Intent noLoginFirst = new Intent(this,NoLoginFirstActivity.class);
                startActivity(noLoginFirst);
                break;
            case R.id.linearLayoutTraits:
                Intent intentTraits = new Intent(this,TraitsActivity.class);
                startActivity(intentTraits);
                break;
//            case R.id.constraintLayoutRace:
//                Intent intentRace = new Intent(this, RaceActivity.class);
//                startActivity(intentRace);
//                break;
//            case R.id.constraintLayoutClass:
//                Intent intentClass = new Intent(this, ClassActivity.class);
//                startActivity(intentClass);
//                break;
//            case R.id.constraintLayoutOutlook:
//                Intent intentOutlook = new Intent(this, OutlookActivity.class);
//                startActivity(intentOutlook);
//                break;
//            case R.id.constraintLayoutBack:
//                Intent intentBack = new Intent(this, BackActivity.class);
//                startActivity(intentBack);
//                break;
            case R.id.imageLife1:
                if(imageLife1.getAlpha()==0F)
                    imageLife1.ALPHA.set(imageLife1,1F);
                else
                    imageLife1.ALPHA.set(imageLife1,0F);
                break;
            case R.id.imageLife2:
                if(imageLife2.getAlpha()==0F)
                    imageLife2.ALPHA.set(imageLife2,1F);
                else
                    imageLife2.ALPHA.set(imageLife2,0F);
                break;
            case R.id.imageLife3:
                if(imageLife3.getAlpha()==0F)
                    imageLife3.ALPHA.set(imageLife3,1F);
                else
                    imageLife3.ALPHA.set(imageLife3,0F);
                break;
            case R.id.imageDeath1:
                if(imageDeath1.getAlpha()==0F)
                    imageDeath1.ALPHA.set(imageDeath1,1F);
                else
                    imageDeath1.ALPHA.set(imageDeath1,0F);
                break;
            case R.id.imageDeath2:
                if(imageDeath2.getAlpha()==0F)
                    imageDeath2.ALPHA.set(imageDeath2,1F);
                else
                    imageDeath2.ALPHA.set(imageDeath2,0F);
                break;
            case R.id.imageDeath3:
                if(imageDeath3.getAlpha()==0F)
                    imageDeath3.ALPHA.set(imageDeath3,1F);
                else
                    imageDeath3.ALPHA.set(imageDeath3,0F);
                break;

            case R.id.imageCheckAcrobatics:
                if(imageAcrobatics.getAlpha()==0F)
                    imageAcrobatics.ALPHA.set(imageAcrobatics,1F);
                else
                    imageAcrobatics.ALPHA.set(imageAcrobatics,0F);
                break;
            case R.id.imageCheckAnalise:
                if(imageAnalise.getAlpha()==0F)
                    imageAnalise.ALPHA.set(imageAnalise,1F);
                else
                    imageAnalise.ALPHA.set(imageAnalise,0F);
                break;
            case R.id.imageCheckAthletics:
                if(imageAthletics.getAlpha()==0F)
                    imageAthletics.ALPHA.set(imageAthletics,1F);
                else
                    imageAthletics.ALPHA.set(imageAthletics,0F);
                break;
            case R.id.imageCheckPerception:
                if(imagePerception.getAlpha()==0F)
                    imagePerception.ALPHA.set(imagePerception,1F);
                else
                    imagePerception.ALPHA.set(imagePerception,0F);
                break;
            case R.id.imageCheckSurvival:
                if(imageSurvival.getAlpha()==0F)
                    imageSurvival.ALPHA.set(imageSurvival,1F);
                else
                    imageSurvival.ALPHA.set(imageSurvival,0F);
                break;
            case R.id.imageCheckPerformance:
                if(imagePerformance.getAlpha()==0F)
                    imagePerformance.ALPHA.set(imagePerformance,1F);
                else
                    imagePerformance.ALPHA.set(imagePerformance,0F);
                break;
            case R.id.imageCheckIntimidation:
                if(imageIntimidation.getAlpha()==0F)
                    imageIntimidation.ALPHA.set(imageIntimidation,1F);
                else
                    imageIntimidation.ALPHA.set(imageIntimidation,0F);
                break;
            case R.id.imageCheckHistory:
                if(imageHistory.getAlpha()==0F)
                    imageHistory.ALPHA.set(imageHistory,1F);
                else
                    imageHistory.ALPHA.set(imageHistory,0F);
                break;
            case R.id.imageCheckSleight:
                if(imageSleight.getAlpha()==0F)
                    imageSleight.ALPHA.set(imageSleight,1F);
                else
                    imageSleight.ALPHA.set(imageSleight,0F);
                break;
            case R.id.imageCheckMagic:
                if(imageMagic.getAlpha()==0F)
                    imageMagic.ALPHA.set(imageMagic,1F);
                else
                    imageMagic.ALPHA.set(imageMagic,0F);
                break;
            case R.id.imageCheckMedicine:
                if(imageMedicine.getAlpha()==0F)
                    imageMedicine.ALPHA.set(imageMedicine,1F);
                else
                    imageMedicine.ALPHA.set(imageMedicine,0F);
                break;
            case R.id.imageCheckDeception:
                if(imageDeception.getAlpha()==0F)
                    imageDeception.ALPHA.set(imageDeception,1F);
                else
                    imageDeception.ALPHA.set(imageDeception,0F);
                break;
            case R.id.imageCheckNature:
                if(imageNature.getAlpha()==0F)
                    imageNature.ALPHA.set(imageNature,1F);
                else
                    imageNature.ALPHA.set(imageNature,0F);
                break;
            case R.id.imageCheckInsight:
                if(imageInsight.getAlpha()==0F)
                    imageInsight.ALPHA.set(imageInsight,1F);
                else
                    imageInsight.ALPHA.set(imageInsight,0F);
                break;
            case R.id.imageCheckReligion:
                if(imageReligion.getAlpha()==0F)
                    imageReligion.ALPHA.set(imageReligion,1F);
                else
                    imageReligion.ALPHA.set(imageReligion,0F);
                break;
            case R.id.imageCheckSecrecy:
                if(imageSecrecy.getAlpha()==0F)
                    imageSecrecy.ALPHA.set(imageSecrecy,1F);
                else
                    imageSecrecy.ALPHA.set(imageSecrecy,0F);
                break;
            case R.id.imageCheckConviction:
                if(imageConviction.getAlpha()==0F)
                    imageConviction.ALPHA.set(imageConviction,1F);
                else
                    imageConviction.ALPHA.set(imageConviction,0F);
                break;
            case R.id.imageCheckAnimal:
                if(imageAnimal.getAlpha()==0F)
                    imageAnimal.ALPHA.set(imageAnimal,1F);
                else
                    imageAnimal.ALPHA.set(imageAnimal,0F);
                break;
            case R.id.saveCharacterButton:
                String st = auth.getCurrentUser().getUid();
                String email = auth.getCurrentUser().getEmail();
//                if (spinnerOutlook.getSelectedItem().toString()=="Мировоззрение"||spinnerBack.getSelectedItem().toString()=="Предыстория"||
//                        spinnerRace.getSelectedItem().toString()=="Раса"||spinnerClasses.getSelectedItem().toString()=="Класс"){
//                    Toast toast = Toast.makeText(getApplicationContext(),"Вы не сделали правильный выбор", Toast.LENGTH_SHORT);
//                    toast.show();
//                    break;
//                }

                // Сбор информации
                TextView textCharacterName = findViewById(R.id.textCharacterName);
                EditText editTextNumberStrength = findViewById(R.id.editTextNumberStrength);
                EditText editTextNumberDexterity = findViewById(R.id.editTextNumberDexterity);
                EditText editTextNumberConstitution = findViewById(R.id.editTextNumberConstitution);
                EditText editTextNumberWisdom = findViewById(R.id.editTextNumberWisdom);
                EditText editTextNumberIntelligence = findViewById(R.id.editTextNumberIntelligence);
                EditText editTextNumberCharisma = findViewById(R.id.editTextNumberCharisma);

                // Значение характеристик
                String str = editTextNumberStrength.getText().toString();
                String dex = editTextNumberDexterity.getText().toString();
                String con = editTextNumberConstitution.getText().toString();
                String wis = editTextNumberWisdom.getText().toString();
                String intl = editTextNumberIntelligence.getText().toString();
                String cha = editTextNumberCharisma.getText().toString();

                // Создание их значение
                int strengthValue;
                int dexterityValue;
                int constitutionValue;
                int wisdomValue;
                int intelligenceValue;
                int charismaValue;

//                if (str.equals("")||dex.equals("")||con.equals("")||wis.equals("")||intl.equals("")||cha.equals("")){
//                    Toast toast = Toast.makeText(getApplicationContext(),"Одна из характеристик не заполнена", Toast.LENGTH_SHORT);
//                    toast.show();
//                    break;
//                } else{
//                    strengthValue = Integer.parseInt(str);
//                    dexterityValue = Integer.parseInt(dex);
//                    constitutionValue = Integer.parseInt(con);
//                    wisdomValue = Integer.parseInt(wis);
//                    intelligenceValue = Integer.parseInt(intl);
//                    charismaValue = Integer.parseInt(cha);
//                }

                // Характеристики персонажа
//                characteristics = new Characteristics(
//                        strengthValue, Characteristics.characteristicMod(strengthValue),
//                        dexterityValue, Characteristics.characteristicMod(dexterityValue),
//                        constitutionValue, Characteristics.characteristicMod(constitutionValue),
//                        wisdomValue, Characteristics.characteristicMod(wisdomValue),
//                        intelligenceValue, Characteristics.characteristicMod(intelligenceValue),
//                        charismaValue, Characteristics.characteristicMod(charismaValue));


                EditText editTextNumberAcrobatics = (EditText) findViewById(R.id.editTextNumberAcrobatics);
                EditText editTextNumberAnimal = (EditText) findViewById(R.id.editTextNumberAnimal);
                EditText editTextNumberAnalise = (EditText) findViewById(R.id.editTextNumberAnalise);
                EditText editTextNumberAthletics = (EditText) findViewById(R.id.editTextNumberAthletics);
                EditText editTextNumberDeception = (EditText) findViewById(R.id.editTextNumberDeception);
                EditText editTextNumberHistory = (EditText) findViewById(R.id.editTextNumberHistory);
                EditText editTextNumberInsight = (EditText) findViewById(R.id.editTextNumberInsight);
                EditText editTextNumberIntimidation = (EditText) findViewById(R.id.editTextNumberIntimidation);
                EditText editTextNumberMagic = (EditText) findViewById(R.id.editTextNumberMagic);
                EditText editTextNumberMedicine = (EditText) findViewById(R.id.editTextNumberMedicine);
                EditText editTextNumberNature = (EditText) findViewById(R.id.editTextNumberNature);
                EditText editTextNumberPerception = (EditText) findViewById(R.id.editTextNumberPerception);
                EditText editTextNumberPerformance = (EditText) findViewById(R.id.editTextNumberPerformance);
                EditText editTextNumberConviction = (EditText) findViewById(R.id.editTextNumberConviction);
                EditText editTextNumberReligion = (EditText) findViewById(R.id.editTextNumberReligion);
                EditText editTextNumberSlight = (EditText) findViewById(R.id.editTextNumberSleight);
                EditText editTextNumberSecrecy = (EditText) findViewById(R.id.editTextNumberSecrecy);
                EditText editTextNumberSurvival = (EditText) findViewById(R.id.editTextNumberSurvival);


                CharacterSkill characterSkill = new CharacterSkill();
//                try{
//                    characterSkill.setACROBATICS(Integer.parseInt(editTextNumberAcrobatics.getText().toString()));
//                    characterSkill.setANIMAL_HANDLING(Integer.parseInt(editTextNumberAnimal.getText().toString()));
//                    characterSkill.setMAGIC(Integer.parseInt(editTextNumberMagic.getText().toString()));
//                    characterSkill.setATHLETICS(Integer.parseInt(editTextNumberAthletics.getText().toString()));
//                    characterSkill.setDECEPTION(Integer.parseInt(editTextNumberDeception.getText().toString()));
//                    characterSkill.setHISTORY(Integer.parseInt(editTextNumberHistory.getText().toString()));
//                    characterSkill.setINSIGHT(Integer.parseInt(editTextNumberInsight.getText().toString()));
//                    characterSkill.setINTIMIDATION(Integer.parseInt(editTextNumberIntimidation.getText().toString()));
//                    characterSkill.setANALISE(Integer.parseInt(editTextNumberAnalise.getText().toString()));
//                    characterSkill.setMEDICINE(Integer.parseInt(editTextNumberMedicine.getText().toString()));
//                    characterSkill.setNATURE(Integer.parseInt(editTextNumberNature.getText().toString()));
//                    characterSkill.setPERCEPTION(Integer.parseInt(editTextNumberPerception.getText().toString()));
//                    characterSkill.setPERFORMANCE(Integer.parseInt(editTextNumberPerformance.getText().toString()));
//                    characterSkill.setCONVICTION(Integer.parseInt(editTextNumberConviction.getText().toString()));
//                    characterSkill.setRELIGION(Integer.parseInt(editTextNumberReligion.getText().toString()));
//                    characterSkill.setSLEIGHT_OF_HAND(Integer.parseInt(editTextNumberSlight.getText().toString()));
//                    characterSkill.setSECRECY(Integer.parseInt(editTextNumberSecrecy.getText().toString()));
//                    characterSkill.setSURVIVAL(Integer.parseInt(editTextNumberSurvival.getText().toString()));
//                } catch (NumberFormatException e){
//                    Snackbar.make(root, "Одно из полей навыков не заполнено" + e.getMessage(),Snackbar.LENGTH_LONG).show();
//                    break;
//                }

//                Character_DND newCharacter = new Character_DND(textCharacterName.toString(),spinnerOutlook.getSelectedItem().toString(),
//                        spinnerRace.getSelectedItem().toString(),spinnerClasses.getSelectedItem().toString(),
//                        spinnerBack.getSelectedItem().toString(),characteristics, "0"); // auth.getCurrentUser().getEmail()
//                newCharacter.setCharacterSkill(characterSkill);


                String email_St = auth.getCurrentUser().getEmail().toString();

                Intent loginFirstSave = new Intent(this,LoginFirstActivity.class);
                Characteristics ch = new Characteristics(0,0,0,0,0,0,0,0,0,0,0,0);
                CharacterSkill ch_sk = new CharacterSkill(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
                Character_DND nc = new Character_DND(textCharacterName.toString(),spinnerRace.getSelectedItem().toString(),
                        spinnerClasses.getSelectedItem().toString(),spinnerBack.getSelectedItem().toString(),
                        spinnerOutlook.getSelectedItem().toString(), ch, email_St);




                nc.setCharacteristics(ch);
                nc.setCharacterSkill(ch_sk);
                characters_dr.push().setValue(nc);
                startActivity(loginFirstSave);



                break;




            default:
                break;
        }
    }
    public class CustomAdapter implements AdapterView.OnItemSelectedListener {
        @Override
        public void onNothingSelected(AdapterView<?> parent) {
        }

        @Override
        public void onItemSelected(AdapterView<?> parent, View view,
                                   int pos, long id) {
            ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
            ((TextView) parent.getChildAt(0)).setTextSize(12);
            ((TextView) parent.getChildAt(0)).setGravity(Gravity.CENTER);
            Typeface face = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                face = getResources().getFont(R.font.helvetica_bold);
            }
            ((TextView) parent.getChildAt(0)).setTypeface(face);
        }
    }

    private void init(){


        ImageView backArrow = (ImageView) findViewById(R.id.imageBackArrow);
        backArrow.setOnClickListener(this);

        LinearLayout linearLayoutTraits = (LinearLayout) findViewById(R.id.linearLayoutTraits);
        linearLayoutTraits.setOnClickListener(this);

        ConstraintLayout constraintLayoutRace = (ConstraintLayout) findViewById(R.id.constraintLayoutRace);
        constraintLayoutRace.setOnClickListener(this);

        ConstraintLayout constraintLayoutClass = (ConstraintLayout) findViewById(R.id.constraintLayoutClass);
        constraintLayoutClass.setOnClickListener(this);

        ConstraintLayout constraintLayoutOutlook = (ConstraintLayout) findViewById(R.id.constraintLayoutOutlook);
        constraintLayoutOutlook.setOnClickListener(this);

        ConstraintLayout constraintLayoutBack = (ConstraintLayout) findViewById(R.id.constraintLayoutBack);
        constraintLayoutBack.setOnClickListener(this);

        spinnerRace = findViewById(R.id.spinnerRace);
        spinnerOutlook = findViewById(R.id.spinnerOutlook);
        spinnerBack = findViewById(R.id.spinnerBack);
        spinnerClasses = findViewById(R.id.spinnerClasses);

        spinnerRace.setOnItemSelectedListener(new CustomAdapter());
        spinnerOutlook.setOnItemSelectedListener(new CustomAdapter());
        spinnerBack.setOnItemSelectedListener(new CustomAdapter());
        spinnerClasses.setOnItemSelectedListener(new CustomAdapter());




        imageLife1 = (ImageView) findViewById(R.id.imageLife1);
        imageLife1.setOnClickListener(this);

        imageLife2 = (ImageView) findViewById(R.id.imageLife2);
        imageLife2.setOnClickListener(this);

        imageLife3 = (ImageView) findViewById(R.id.imageLife3);
        imageLife3.setOnClickListener(this);

        imageDeath1 = (ImageView) findViewById(R.id.imageDeath1);
        imageDeath1.setOnClickListener(this);

        imageDeath2 = (ImageView) findViewById(R.id.imageDeath2);
        imageDeath2.setOnClickListener(this);

        imageDeath3 = (ImageView) findViewById(R.id.imageDeath3);
        imageDeath3.setOnClickListener(this);

        imageAcrobatics = (ImageView) findViewById(R.id.imageCheckAcrobatics);
        imageAcrobatics.setOnClickListener(this);

        imageAnalise = (ImageView) findViewById(R.id.imageCheckAnalise);
        imageAnalise.setOnClickListener(this);

        imageAthletics = (ImageView) findViewById(R.id.imageCheckAthletics);
        imageAthletics.setOnClickListener(this);

        imagePerception = (ImageView) findViewById(R.id.imageCheckPerception);
        imagePerception.setOnClickListener(this);

        imageSurvival = (ImageView) findViewById(R.id.imageCheckSurvival);
        imageSurvival.setOnClickListener(this);

        imagePerformance = (ImageView) findViewById(R.id.imageCheckPerformance);
        imagePerformance.setOnClickListener(this);

        imageIntimidation = (ImageView) findViewById(R.id.imageCheckIntimidation);
        imageIntimidation.setOnClickListener(this);

        imageHistory = (ImageView) findViewById(R.id.imageCheckHistory);
        imageHistory.setOnClickListener(this);

        imageSleight = (ImageView) findViewById(R.id.imageCheckSleight);
        imageSleight.setOnClickListener(this);

        imageMagic = (ImageView) findViewById(R.id.imageCheckMagic);
        imageMagic.setOnClickListener(this);

        imageMedicine = (ImageView) findViewById(R.id.imageCheckMedicine);
        imageMedicine.setOnClickListener(this);

        imageDeception = (ImageView) findViewById(R.id.imageCheckDeception);
        imageDeception.setOnClickListener(this);

        imageNature = (ImageView) findViewById(R.id.imageCheckNature);
        imageNature.setOnClickListener(this);

        imageInsight = (ImageView) findViewById(R.id.imageCheckInsight);
        imageInsight.setOnClickListener(this);

        imageReligion = (ImageView) findViewById(R.id.imageCheckReligion);
        imageReligion.setOnClickListener(this);

        imageSecrecy = (ImageView) findViewById(R.id.imageCheckSecrecy);
        imageSecrecy.setOnClickListener(this);

        imageConviction = (ImageView) findViewById(R.id.imageCheckConviction);
        imageConviction.setOnClickListener(this);

        imageAnimal = (ImageView) findViewById(R.id.imageCheckAnimal);
        imageAnimal.setOnClickListener(this);

        List<String> rcs = new ArrayList<>();
        Races[] rcEnum = Races.values();
        rcs.add("Раса");
        for(Races r : rcEnum){
            rcs.add(r.name());
        }

        List<String> back = new ArrayList<>();
        Backstory[] bckEnum = Backstory.values();
        back.add("Предыстория");
        for(Backstory b : bckEnum){
            back.add(b.name());
        }

        List<String> outlook = new ArrayList<>();
        Outlook[] outlookEnum = Outlook.values();
        outlook.add("Мировоззрение");
        for(Outlook o : outlookEnum){
            outlook.add(o.name());
        }

        List<String> classes = new ArrayList<>();
        Classes[] classesEnum = Classes.values();
        classes.add("Класс");
        for(Classes c : classesEnum){
            classes.add(c.name());
        }

        ArrayAdapter<String> adapterRace = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, rcs);
        adapterRace.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> adapterOutlook = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, outlook);
        adapterOutlook.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> adapterBack = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, back);
        adapterBack.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> adapterClasses = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, classes);
        adapterClasses.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerRace.setAdapter(adapterRace);
        spinnerOutlook.setAdapter(adapterOutlook);
        spinnerBack.setAdapter(adapterBack);
        spinnerClasses.setAdapter(adapterClasses);

    }


}