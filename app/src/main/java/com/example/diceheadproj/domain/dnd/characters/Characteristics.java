package com.example.diceheadproj.domain.dnd.characters;


import java.io.Serializable;
import java.util.UUID;

public class Characteristics implements Serializable {

    private long id;

    private long essenceId;

    private int strength;

    private int strengthMod;

    private int dexterity;

    private int dexterityMod;

    private int constitution;

    private int constitutionMod;

    private int wisdom;

    private int wisdomMod;

    private int intelligence;

    private int intelligenceMod;

    private int charisma;

    private int charismaMod;

    public Characteristics(){

    }

    public Characteristics(int strength, int strengthMod,
                           int dexterity, int dexterityMod, int constitution,
                           int constitutionMod, int wisdom, int wisdomMod,
                           int intelligence, int intelligenceMod, int charisma,
                           int charismaMod) {
        this.strength = strength;
        this.strengthMod = strengthMod;
        this.dexterity = dexterity;
        this.dexterityMod = dexterityMod;
        this.constitution = constitution;
        this.constitutionMod = constitutionMod;
        this.wisdom = wisdom;
        this.wisdomMod = wisdomMod;
        this.intelligence = intelligence;
        this.intelligenceMod = intelligenceMod;
        this.charisma = charisma;
        this.charismaMod = charismaMod;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEssenceId() {
        return essenceId;
    }

    public void setEssenceId(Long essenceId) {
        this.essenceId = essenceId;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getStrengthMod() {
        return strengthMod;
    }

    public void setStrengthMod(int strengthMod) {
        this.strengthMod = strengthMod;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getDexterityMod() {
        return dexterityMod;
    }

    public void setDexterityMod(int dexterityMod) {
        this.dexterityMod = dexterityMod;
    }

    public int getConstitution() {
        return constitution;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public int getConstitutionMod() {
        return constitutionMod;
    }

    public void setConstitutionMod(int constitutionMod) {
        this.constitutionMod = constitutionMod;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public int getWisdomMod() {
        return wisdomMod;
    }

    public void setWisdomMod(int wisdomMod) {
        this.wisdomMod = wisdomMod;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getIntelligenceMod() {
        return intelligenceMod;
    }

    public void setIntelligenceMod(int intelligenceMod) {
        this.intelligenceMod = intelligenceMod;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public int getCharismaMod() {
        return charismaMod;
    }

    public void setCharismaMod(int charismaMod) {
        this.charismaMod = charismaMod;
    }

    public static int characteristicMod(int num){
        double i = (double) (num-10)/2;
        if (i<0&&i%1!=0)
            i-=0.5;
        return (int) i;
    }
}
