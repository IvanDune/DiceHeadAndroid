package com.example.diceheadproj.domain.dnd.characters;

import java.util.Set;

public class Weapon {

    private Long id;

    private String name;

    private int price;

    private int valueDamage;

    private int diceDamage;

    private int mod;

    private int weight;

    private boolean military;

    private boolean longRange;


    private Set<WeaponProperties> weaponPropertiesSet;

    public Weapon(){

    }

    public Weapon(String name, int price, int valueDamage, int diceDamage, int mod, int weight, boolean military, boolean longRange) {
        this.name = name;
        this.price = price;
        this.valueDamage = valueDamage;
        this.diceDamage = diceDamage;
        this.mod = mod;
        this.weight = weight;
        this.military = military;
        this.longRange = longRange;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getValueDamage() {
        return valueDamage;
    }

    public void setValueDamage(int valueDamage) {
        this.valueDamage = valueDamage;
    }

    public int getDiceDamage() {
        return diceDamage;
    }

    public void setDiceDamage(int diceDamage) {
        this.diceDamage = diceDamage;
    }

    public int getMod() {
        return mod;
    }

    public void setMod(int mod) {
        this.mod = mod;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isMilitary() {
        return military;
    }

    public void setMilitary(boolean military) {
        this.military = military;
    }

    public boolean isLongRange() {
        return longRange;
    }

    public void setLongRange(boolean longRange) {
        this.longRange = longRange;
    }

    public Set<WeaponProperties> getWeaponPropertiesSet() {
        return weaponPropertiesSet;
    }

    public void setWeaponPropertySet(Set<WeaponProperties> weaponPropertiesSet) {
        this.weaponPropertiesSet = weaponPropertiesSet;
    }
}
