package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by Rumata on 06.12.2016.
 */
public class Hippodrome
{
    public ArrayList<Horse> horses;
    public static Hippodrome game;

    public ArrayList<Horse> getHorses()
    {
        return horses;
    }

    public void setHorses(ArrayList<Horse> horses)
    {
        this.horses = horses;
    }

    public void move() {}
    public void print() {}
    public void run() {}

    public static void main(String[] args)
    {
        game = new Hippodrome();
        ArrayList<Horse> horses1 = new ArrayList<>();

        horses1.add(new Horse("firstHorse", 3, 0));
        horses1.add(new Horse("secondHorse", 3, 0));
        horses1.add(new Horse("thirdHorse", 3, 0));
        game.setHorses(horses1);
    }
}
