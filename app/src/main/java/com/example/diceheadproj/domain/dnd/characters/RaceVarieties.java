package com.example.diceheadproj.domain.dnd.characters;

import java.util.Set;

public class RaceVarieties {

    private Long id;

    private String name;

    private String description;


    private Set<CharacteristicBuff> buffs;


    private Set<RaceAbilities> raceAbilitiesSet;

    public RaceVarieties(){

    }

    public RaceVarieties(String name) {
        this.name = name;
    }

    public RaceVarieties(String name, Set<CharacteristicBuff> buffs, Set<RaceAbilities> raceAbilitiesSet, String description) {
        this.name = name;
        this.buffs = buffs;
        this.raceAbilitiesSet = raceAbilitiesSet;
        this.description=description;
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

    public Set<CharacteristicBuff> getBuffs() {
        return buffs;
    }

    public void setBuffs(Set<CharacteristicBuff> buffs) {
        this.buffs = buffs;
    }

    public Set<RaceAbilities> getRaceAbilitiesSet() {
        return raceAbilitiesSet;
    }

    public void setRaceAbilitiesSet(Set<RaceAbilities> raceAbilitiesSet) {
        this.raceAbilitiesSet = raceAbilitiesSet;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
