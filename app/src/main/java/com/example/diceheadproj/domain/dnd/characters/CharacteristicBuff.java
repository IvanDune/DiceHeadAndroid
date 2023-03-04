package com.example.diceheadproj.domain.dnd.characters;



public class CharacteristicBuff  {
    private Long id;

    private String name;

    private int mod;
    CharacteristicBuff(){


    }

    public CharacteristicBuff(String name, int mod) {
        this.name = name;
        this.mod = mod;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMod() {
        return mod;
    }

    public void setMod(int mod) {
        this.mod = mod;
    }
}
