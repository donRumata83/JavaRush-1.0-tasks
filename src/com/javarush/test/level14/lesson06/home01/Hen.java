package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Rumata on 06.10.2016.
 */
public abstract class Hen

{
    String country;

    abstract int getCountOfEggsPerMonth();

    public String getDescription()
    {
        return "Я курица.";
    }
}
