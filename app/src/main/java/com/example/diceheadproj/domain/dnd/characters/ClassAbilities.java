package com.example.diceheadproj.domain.dnd.characters;


public class ClassAbilities {

    private Long id;

    private String name;

    private String description;

    private int level;

    public ClassAbilities(){
    }

    public ClassAbilities(String name, String description, int level) {
        this.name = name;
        this.description = description;
        this.level = level;
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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
