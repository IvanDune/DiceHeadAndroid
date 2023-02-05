package com.example.diceheadproj.domain;

public enum Classes {
    Бард("1"),
    Варвар("2"),
    Воин("3"),
    Волшебник("4"),
    Друид("5"),
    Жрец("6"),
    Колдун("7"),
    Монах("8"),
    Паладин("9"),
    Плут("10"),
    Следопыт("11"),
    Чародей("12");

    public String value;
    Classes(String value){
        this.value=value;
    }

    public String getValue() {
        return value;
    }
}
