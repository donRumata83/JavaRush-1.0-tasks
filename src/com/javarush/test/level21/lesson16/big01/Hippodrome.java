package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by Rumata on 06.12.2016.
 */
public class Hippodrome
{
    private ArrayList<Horse> horses = new ArrayList<>();
    public static Hippodrome game;

    public ArrayList<Horse> getHorses()
    {
        return this.horses;
    }

    public void setHorses(ArrayList<Horse> horses)
    {
        this.horses = horses;
    }

    public void move()
    {
        for (Horse horse : getHorses())
        {
            horse.move();
        }
    }

    public void print()
    {
        for (Horse horse : getHorses())
        {
            horse.print();
        }
        System.out.println();
        System.out.println();
    }

    public void run()
    {
        try
        {
            for (int i = 0; i < 100; i++)
            {
                move();
                print();
                Thread.sleep(200);
            }
        }
        catch (InterruptedException e)
        {
        }
    }

    public Horse getWinner()
    {
        Horse winner = null;
        double maxDistance = getHorses().get(0).getDistance();
        for (Horse horse : getHorses())
        {
            if (horse.getDistance() > maxDistance) maxDistance = horse.getDistance();
        }
        for (Horse horse : getHorses())
        {
            if (horse.getDistance() == maxDistance) winner = horse;
        }
        return winner;
    }
    public void printWinner()
    {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public static void main(String[] args)
    {
        game = new Hippodrome();
        ArrayList<Horse> horses1 = new ArrayList<>();

        horses1.add(new Horse("firstHorse", 3, 0));
        horses1.add(new Horse("secondHorse", 3, 0));
        horses1.add(new Horse("thirdHorse", 3, 0));
        game.setHorses(horses1);
        game.run();
        game.printWinner();
    }
}
