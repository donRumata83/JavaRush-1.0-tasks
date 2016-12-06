package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Rumata on 06.10.2016.
 */
public class BelarusianHen extends Hen
{
    int countEgg = 40;
    String country = "Belarus";

    public int getCountOfEggsPerMonth()
    {
        return countEgg;
    }

    public String getDescription()
    {
        String description = super.getDescription() + " Моя страна - " + country  + ". Я несу " + countEgg + " яиц в месяц.";
        return description;
    }
}
