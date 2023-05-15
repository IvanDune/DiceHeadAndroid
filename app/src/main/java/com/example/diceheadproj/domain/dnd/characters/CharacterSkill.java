package com.example.diceheadproj.domain.dnd.characters;

import java.io.Serializable;

public class CharacterSkill implements Serializable {
    int ACROBATICS = 0;
    int ANALISE = 0;
    int ANIMAL_HANDLING = 0;
    int ATHLETICS = 0;
    int DECEPTION = 0;
    int HISTORY = 0;
    int INSIGHT = 0;
    int INTIMIDATION = 0;
    int MAGIC = 0;
    int MEDICINE = 0;
    int NATURE = 0;
    int PERCEPTION = 0;
    int PERFORMANCE = 0;
    int CONVICTION = 0;
    int RELIGION = 0;
    int SLEIGHT_OF_HAND = 0;
    int SECRECY = 0;
    int SURVIVAL = 0;

    public CharacterSkill(){

    }

    public CharacterSkill(Integer ACROBATICS, Integer ANIMAL_HANDLING, Integer ARCANA, Integer ATHLETICS, Integer DECEPTION, Integer HISTORY, Integer INSIGHT, Integer INTIMIDATION, Integer INVESTIGATION, Integer MEDICINE, Integer NATURE, Integer PERCEPTION, Integer PERFORMANCE, Integer CONVICTION, Integer RELIGION, Integer SLEIGHT_OF_HAND, Integer STEALTH, Integer SURVIVAL) {
        this.ACROBATICS = ACROBATICS;
        this.ANIMAL_HANDLING = ANIMAL_HANDLING;
        this.MAGIC = ARCANA;
        this.ATHLETICS = ATHLETICS;
        this.DECEPTION = DECEPTION;
        this.HISTORY = HISTORY;
        this.INSIGHT = INSIGHT;
        this.INTIMIDATION = INTIMIDATION;
        this.ANALISE = INVESTIGATION;
        this.MEDICINE = MEDICINE;
        this.NATURE = NATURE;
        this.PERCEPTION = PERCEPTION;
        this.PERFORMANCE = PERFORMANCE;
        this.CONVICTION = CONVICTION;
        this.RELIGION = RELIGION;
        this.SLEIGHT_OF_HAND = SLEIGHT_OF_HAND;
        this.SECRECY = STEALTH;
        this.SURVIVAL = SURVIVAL;
    }

    public Integer getACROBATICS() {
        return ACROBATICS;
    }

    public void setACROBATICS(Integer ACROBATICS) {
        this.ACROBATICS = ACROBATICS;
    }

    public Integer getANIMAL_HANDLING() {
        return ANIMAL_HANDLING;
    }

    public void setANIMAL_HANDLING(Integer ANIMAL_HANDLING) {
        this.ANIMAL_HANDLING = ANIMAL_HANDLING;
    }

    public Integer getMAGIC() {
        return MAGIC;
    }

    public void setMAGIC(Integer MAGIC) {
        this.MAGIC = MAGIC;
    }

    public Integer getATHLETICS() {
        return ATHLETICS;
    }

    public void setATHLETICS(Integer ATHLETICS) {
        this.ATHLETICS = ATHLETICS;
    }

    public Integer getDECEPTION() {
        return DECEPTION;
    }

    public void setDECEPTION(Integer DECEPTION) {
        this.DECEPTION = DECEPTION;
    }

    public Integer getHISTORY() {
        return HISTORY;
    }

    public void setHISTORY(Integer HISTORY) {
        this.HISTORY = HISTORY;
    }

    public Integer getINSIGHT() {
        return INSIGHT;
    }

    public void setINSIGHT(Integer INSIGHT) {
        this.INSIGHT = INSIGHT;
    }

    public Integer getINTIMIDATION() {
        return INTIMIDATION;
    }

    public void setINTIMIDATION(Integer INTIMIDATION) {
        this.INTIMIDATION = INTIMIDATION;
    }

    public Integer getANALISE() {
        return ANALISE;
    }

    public void setANALISE(Integer ANALISE) {
        this.ANALISE = ANALISE;
    }

    public Integer getMEDICINE() {
        return MEDICINE;
    }

    public void setMEDICINE(Integer MEDICINE) {
        this.MEDICINE = MEDICINE;
    }

    public Integer getNATURE() {
        return NATURE;
    }

    public void setNATURE(Integer NATURE) {
        this.NATURE = NATURE;
    }

    public Integer getPERCEPTION() {
        return PERCEPTION;
    }

    public void setPERCEPTION(Integer PERCEPTION) {
        this.PERCEPTION = PERCEPTION;
    }

    public Integer getPERFORMANCE() {
        return PERFORMANCE;
    }

    public void setPERFORMANCE(Integer PERFORMANCE) {
        this.PERFORMANCE = PERFORMANCE;
    }

    public Integer getCONVICTION() {
        return CONVICTION;
    }

    public void setCONVICTION(Integer CONVICTION) {
        this.CONVICTION = CONVICTION;
    }

    public Integer getRELIGION() {
        return RELIGION;
    }

    public void setRELIGION(Integer RELIGION) {
        this.RELIGION = RELIGION;
    }

    public Integer getSLEIGHT_OF_HAND() {
        return SLEIGHT_OF_HAND;
    }

    public void setSLEIGHT_OF_HAND(Integer SLEIGHT_OF_HAND) {
        this.SLEIGHT_OF_HAND = SLEIGHT_OF_HAND;
    }

    public Integer getSECRECY() {
        return SECRECY;
    }

    public void setSECRECY(Integer SECRECY) {
        this.SECRECY = SECRECY;
    }

    public Integer getSURVIVAL() {
        return SURVIVAL;
    }

    public void setSURVIVAL(Integer SURVIVAL) {
        this.SURVIVAL = SURVIVAL;
    }
}
