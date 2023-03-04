package com.example.diceheadproj.domain.dnd.characters;


public class RaceAbilities {

    private Long id;

    private Long raceId;

    private String name;

    private String description;

    public RaceAbilities(){

    }

    public RaceAbilities(Long raceId, String name, String description) {
        this.raceId = raceId;
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRaceId() {
        return raceId;
    }

    public void setRaceId(Long raceId) {
        this.raceId = raceId;
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
}
