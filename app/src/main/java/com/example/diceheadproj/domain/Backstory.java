package com.example.diceheadproj.domain;

public enum Backstory {
    Артист("1"),
    Беспризорник("2"),
    Благородный("3"),
    Гильдийский_ремесленник("4"),
    Моряк("5"),
    Мудрец("6"),
    Народный_герой("7"),
    Отшельник("8"),
    Пират("9"),
    Приступник("10"),
    Прислужник("11"),
    Солдат("12"),
    Чужеземец("13"),
    Шарлатан("14");

    public String value;
    Backstory(String value){
        this.value=value;
    }
    public String getValue(){
        return value;
    }
}
