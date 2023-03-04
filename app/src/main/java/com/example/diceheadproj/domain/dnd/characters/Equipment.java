package com.example.diceheadproj.domain.dnd.characters;


public class Equipment {

    private Long id;

    private String name;

    private int price;

    private int weight;

    private String description;


    public Equipment(){

    }

    public Equipment(String name, int price, int weight, String description) {
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.description = description;
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

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
