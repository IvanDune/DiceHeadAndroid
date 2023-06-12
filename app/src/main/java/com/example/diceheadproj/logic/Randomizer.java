package com.example.diceheadproj.logic;
import java.util.*;

public class Randomizer {

    /**
     * Подается максимально возможное число на вход
     * Резльутатом является случайное не превосходящее значение от 1
     * @param num - максимальная граница
     * @return
     */
    public static int rand(int num){
        Random random = new Random();
        int n = random.nextInt(num+1);
        return n;
    }

    /**
     * Подается максимально возможное число на вход и модификатор
     * Резльутатом является случайное не превосходящее значение от 1
     * С добавлением модификатора к окончательному результату
     * @param num - максимальная граница
     * @param mod - модификатор броска
     * @return
     */
    public static int rand(int num, int mod){
        int n = rand(num);
        if (n+mod>=0)
            return n+mod;
        else return 0;
    }

    /**
     * Подается максимально возможное число на вход, количество кубов и модификатор
     * Резльутатом является случайное не превосходящее значение от 1
     * С добавлением модификатора к окончательному результату
     * @param num - максимальная граница
     * @param mod - модификатор броска
     * @param kol - количество кубов
     * @return
     */
    public static int rand(int num, int mod, int kol){
        int sum=0;
        for (int i=0;i<kol;i++){
            sum += rand(num);
        }
        if (sum+mod>=0)
            return sum+mod;
        else return 0;
    }

    /**
     * Генерация одной характеристики на основе правил Dungeons and Dragons 5e
     * @return
     */
    public static int characteristic(){
        ArrayList<Integer> list = new ArrayList<>();
        int sum = 0;
        for (int i=0;i<4;i++){
            list.add(rand(6));
            sum += list.get(i);
        }
        int i = (int) Collections.min(list);
        sum -=i;
        return sum;
    }


    /**
     * Подается характеритсика персонажа.
     * Генерируется модификатор на основе правил Dungeons and Dragons 5e
     * @param num - значение характеристики
     * @return
     */
    public static int characteristicMod(int num){
        double i = (double) (num-10)/2;
        if (i<0&&i%1!=0)
            i-=0.5;
        return (int) i;
    }
}
