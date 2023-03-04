package com.example.diceheadproj.domain.dnd.characters;


public class DHNumber {

    private Long id;

    private Integer num;

    public DHNumber() {

    }

    public DHNumber(Integer num) {
        this.num = num;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
