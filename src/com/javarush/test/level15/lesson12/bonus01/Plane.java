package com.javarush.test.level15.lesson12.bonus01;

/**
 * Created by Rumata on 20.10.2016.
 */
public class Plane implements Flyable
{
    public int passengers;
    @Override
    public void fly()
    {

    }

    public Plane(int passengers)
    {
        this.passengers = passengers;
    }
}
