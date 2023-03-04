package com.example.diceheadproj.domain.dnd.characters;

import java.util.Optional;
import java.util.Set;

public class Character extends Essence{

    private Long id;

    private String name;

    private Long raceId;

    private Long raceVariety;

    private Long classId;

    private Long characteristicsId;

    private Long userId;

    private int level;

    private String className;

    private String raceName;

    private String outlookName;

    private String backName;

    public Character(){

    }

    public Character(String name, String raceName, String className, String backName, String outlookName, Long characteristicsId, Long userId) {
        this.name = name;
        this.outlookName=outlookName;
        this.raceName=raceName;
        this.className=className;
        this.backName=backName;
        this.characteristicsId = characteristicsId;
        this.userId = userId;
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

    public Long getCharacteristicsId() {
        return characteristicsId;
    }

    public void setCharacteristicsId(Long characteristicsId) {
        this.characteristicsId = characteristicsId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
    

}
