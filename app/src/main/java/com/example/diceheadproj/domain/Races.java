package com.example.diceheadproj.domain;

public enum Races {
    Гном("1"),
    Дварф("2"),
    Драконорожденный("3"),
    Полуорк("4"),
    Полуэльф("5"),
    Человек("6"),
    Тифлинг("7"),
    Полурослик("8"),
    Эльф("9");
    public String value;
    Races(String value){
        this.value=value;
    }

    public String getValue() {
        return value;
    }
}
