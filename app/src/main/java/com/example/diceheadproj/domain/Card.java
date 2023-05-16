package com.example.diceheadproj.domain;

import com.example.diceheadproj.domain.dnd.characters.Characteristics;

public class Card {
    private String name;

    private int level;

    private int  mod;

    private int id;

    private Characteristics characteristics;

    private String class_name;

    private String race_name;

    public Card(String name, int level, int mod, int id, Characteristics characteristics, String class_name, String race_name) {
        this.name = name;
        this.level = level;
        this.mod = mod;
        this.id = id;
        this.characteristics = characteristics;
        this.class_name = class_name;
        this.race_name = race_name;
    }

    public Card(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getMod() {
        return mod;
    }

    public void setMod(int mod) {
        this.mod = mod;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Characteristics getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(Characteristics characteristics) {
        this.characteristics = characteristics;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public String getRace_name() {
        return race_name;
    }

    public void setRace_name(String race_name) {
        this.race_name = race_name;
    }
}
