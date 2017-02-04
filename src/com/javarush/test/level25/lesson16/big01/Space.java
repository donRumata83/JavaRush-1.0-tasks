package com.javarush.test.level25.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by Rumata on 03.02.2017.
 */
public class Space
{
    public int width;
    public int height;
    public SpaceShip ship;
    public ArrayList<Ufo> ufos;
    public ArrayList<Rocket> rockets;
    public ArrayList<Bomb> bombs;
    public static Space game;

    public Space(int width, int height)
    {
        this.width = width;
        this.height = height;
        this.ufos = new ArrayList<>();
        this.rockets = new ArrayList<>();
        this.bombs = new ArrayList<>();
    }

    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }

    public SpaceShip getShip()
    {
        return ship;
    }

    public ArrayList<Ufo> getUfos()
    {
        return ufos;
    }

    public ArrayList<Rocket> getRockets()
    {
        return rockets;
    }

    public ArrayList<Bomb> getBombs()
    {
        return bombs;
    }

    public void setShip(SpaceShip ship)
    {
        this.ship = ship;
    }

    public void run() {}

    public void draw() {}

    public void sleep(int ms) {}

    public static void main(String[] args)
    {

    }
}
