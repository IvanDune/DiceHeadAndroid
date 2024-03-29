package com.example.diceheadproj.domain.dnd.characters;


import com.orm.SugarRecord;

import java.io.Serializable;

public abstract class Essence implements Serializable {
    protected String name;

    protected int HP;

    protected int baseAC=10;

    protected int initiative;




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getBaseAC() {
        return baseAC;
    }

    public void setBaseAC(int baseAC) {
        this.baseAC = baseAC;
    }

    public int getInitiative() {
        return initiative;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

}
