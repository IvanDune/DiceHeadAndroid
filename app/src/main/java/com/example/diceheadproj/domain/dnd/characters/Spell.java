package com.example.diceheadproj.domain.dnd.characters;


import java.util.Set;

public class Spell {

    private Long id;

    private String name;

    private int level;

    private String school;


    private SpellCastingTime spellCastingTime;

    private String range;

    private String components;

    private String duration;

    private Set<ClassEnum> classEnumSet;

    public Spell(){

    }

    public Spell(String name, int level, String school, SpellCastingTime spellCastingTime, String range, String components, String duration, Set<ClassEnum> classEnumSet) {
        this.name = name;
        this.level = level;
        this.school = school;
        this.spellCastingTime = spellCastingTime;
        this.range = range;
        this.components = components;
        this.duration = duration;
        this.classEnumSet = classEnumSet;
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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public SpellCastingTime getSpellCastingTime() {
        return spellCastingTime;
    }

    public void setSpellCastingTime(SpellCastingTime spellCastingTime) {
        this.spellCastingTime = spellCastingTime;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String getComponents() {
        return components;
    }

    public void setComponents(String components) {
        this.components = components;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Set<ClassEnum> getClassEnumSet() {
        return classEnumSet;
    }

    public void setClassEnumSet(Set<ClassEnum> classEnumSet) {
        this.classEnumSet = classEnumSet;
    }
}
