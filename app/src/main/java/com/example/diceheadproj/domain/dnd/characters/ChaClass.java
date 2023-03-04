package com.example.diceheadproj.domain.dnd.characters;

import com.orm.SugarRecord;

import java.util.Set;

public class ChaClass  extends SugarRecord<ChaClass> {

    private Long id;

    private String name;

    private String description;

    private int hitDice;

    private Set<ProficienciesSaves> pro_saves;

    private Set<ProficienciesArmor> pro_armor;

    private Set<ProficienciesSkills> pro_skills;

    private Set<ProficienciesTools> pro_tools;

    private Set<ProficienciesWeapon> pro_weapon;

    private Set<ClassAbilities> classAbilitiesSet;

    public ChaClass(){

    }

    public ChaClass(String name, String description, int hitDice) {
        this.name = name;
        this.description = description;
        this.hitDice = hitDice;
    }

    public ChaClass(String name, String description, int hitDice, Set<ProficienciesSaves> pro_saves,
                    Set<ProficienciesArmor> pro_armor, Set<ProficienciesSkills> pro_skills, Set<ProficienciesTools> pro_tools,
                    Set<ProficienciesWeapon> pro_weapon, Set<ClassAbilities> classAbilitiesSet) {
        this.name = name;
        this.description = description;
        this.hitDice = hitDice;
        this.pro_saves = pro_saves;
        this.pro_armor = pro_armor;
        this.pro_skills = pro_skills;
        this.pro_tools = pro_tools;
        this.pro_weapon = pro_weapon;
        this.classAbilitiesSet = classAbilitiesSet;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getHitDice() {
        return hitDice;
    }

    public void setHitDice(int hitDice) {
        this.hitDice = hitDice;
    }

    public Set<ProficienciesSaves> getPro_saves() {
        return pro_saves;
    }

    public void setPro_saves(Set<ProficienciesSaves> pro_saves) {
        this.pro_saves = pro_saves;
    }

    public Set<ProficienciesArmor> getPro_armor() {
        return pro_armor;
    }

    public void setPro_armor(Set<ProficienciesArmor> pro_armor) {
        this.pro_armor = pro_armor;
    }

    public Set<ProficienciesSkills> getPro_skills() {
        return pro_skills;
    }

    public void setPro_skills(Set<ProficienciesSkills> pro_skills) {
        this.pro_skills = pro_skills;
    }

    public Set<ProficienciesTools> getPro_tools() {
        return pro_tools;
    }

    public void setPro_tools(Set<ProficienciesTools> pro_tools) {
        this.pro_tools = pro_tools;
    }

    public Set<ProficienciesWeapon> getPro_weapon() {
        return pro_weapon;
    }

    public void setPro_weapon(Set<ProficienciesWeapon> pro_weapon) {
        this.pro_weapon = pro_weapon;
    }

    public Set<ClassAbilities> getClassAbilitiesSet() {
        return classAbilitiesSet;
    }

    public void setClassAbilitiesSet(Set<ClassAbilities> classAbilitiesSet) {
        this.classAbilitiesSet = classAbilitiesSet;
    }
}
