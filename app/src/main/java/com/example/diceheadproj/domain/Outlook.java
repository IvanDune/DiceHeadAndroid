package com.example.diceheadproj.domain;

public enum Outlook {
    Законно_добрый("1"),
    Законно_нейтральный("2"),
    Законно_злой("3"),
    Нейтрально_добрый("4"),
    Нейтральный("5"),
    Нейттрально_злой("6"),
    Хаотично_добрый("7"),
    Хаотично_злой("8"),
    Хаотично_нейтральный("9");

    public String value;
    Outlook(String value){
        this.value=value;
    }
    public String getValue(){
        return value;
    }
}
