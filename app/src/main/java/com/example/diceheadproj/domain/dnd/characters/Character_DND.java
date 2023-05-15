package com.example.diceheadproj.domain.dnd.characters;

import java.io.Serializable;

public class Character_DND extends Essence implements Serializable{

    private String ide;

    private String name;

    private long raceId;

    private long raceVariety;

    private long classId;

    private Characteristics characteristics;

    private String userUID; // Был UserID

    private int level;

    private String className;

    private String raceName;

    private String outlookName;

    private String backName;

    private CharacterSkill characterSkill;

    public Character_DND(){

    }

    public Character_DND(String name, String raceName, String className, String backName, String outlookName, Characteristics characteristics, String userEmail) {
//        this.ide = UUID.randomUUID().toString();
        this.name = name;
        this.outlookName=outlookName;
        this.raceName=raceName;
        this.className=className;
        this.backName=backName;
        this.characteristics = characteristics;
        this.userUID = userEmail;
    }

    public String getOutlookName() {
        return outlookName;
    }

    public void setOutlookName(String outlookName) {
        this.outlookName = outlookName;
    }

    public String getBackName() {
        return backName;
    }

    public void setBackName(String backName) {
        this.backName = backName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getRaceId() {
        return raceId;
    }

    public void setRaceId(Long raceId) {
        this.raceId = raceId;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public Characteristics getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(Characteristics characteristics) {
        this.characteristics = characteristics;
    }

    public String getIde() {
        return ide;
    }

    public String getUserId() {
        return userUID;
    }

    public void setUserId(String userEmail) {
        this.userUID = userEmail;
    }

    public Long getRaceVariety() {
        return raceVariety;
    }

    public void setRaceVariety(Long raceVariety) {
        this.raceVariety = raceVariety;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getRaceName() {
        return raceName;
    }

    public void setRaceName(String raceName) {
        this.raceName = raceName;
    }

    public String getUserUID() {
        return userUID;
    }

    public void setUserUID(String userUID) {
        this.userUID = userUID;
    }

    public CharacterSkill getCharacterSkill() {
        return characterSkill;
    }

    public void setCharacterSkill(CharacterSkill characterSkill) {
        this.characterSkill = characterSkill;
    }

    @Override
    public String toString() {
        return "Character_DND{" +
                "ide='" + ide + '\'' +
                ", name='" + name + '\'' +
                ", raceId=" + raceId +
                ", raceVariety=" + raceVariety +
                ", classId=" + classId +
                ", characteristics=" + characteristics +
                ", userEmail='" + userUID + '\'' +
                ", level=" + level +
                ", className='" + className + '\'' +
                ", raceName='" + raceName + '\'' +
                ", outlookName='" + outlookName + '\'' +
                ", backName='" + backName + '\'' +
                ", characterSkill=" + characterSkill +
                '}';
    }
}
