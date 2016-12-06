package com.javarush.test.level14.lesson08.home05;

/**
 * Created by Rumata on 07.10.2016.
 */
public class Mouse implements CompItem
{
    @Override
    public String getName()
    {
        return this.getClass().getSimpleName();
    }
}
