package com.example.diceheadproj.domain;



import java.util.Optional;
import java.util.Set;

public class Character {

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



    public Character(){

    }

    public Character(String name, Long raceId, Long classId, Long characteristicsId, Long userId) {
        this.name = name;
        this.raceId = raceId;
        this.classId = classId;
        this.characteristicsId = characteristicsId;
        this.userId = userId;
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
