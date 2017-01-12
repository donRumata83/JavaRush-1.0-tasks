package com.javarush.test.level23.lesson13.big01;

import java.util.ArrayList;

/**
 * Created by Rumata on 12.01.2017.
 */
public class Snake
{
    public ArrayList<SnakeSection> sections;
    public boolean isAlive;
    public SnakeDirection direction;
    public int x;
    public int y;

    public ArrayList<SnakeSection> getSections()
    {
        return sections;
    }

    public boolean isAlive()
    {
        return isAlive;
    }

    public SnakeDirection getDirection()
    {
        return direction;
    }

    public void setDirection(SnakeDirection direction)
    {
        this.direction = direction;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public void move(){}

    public Snake(int x, int y)
    {
        sections = new ArrayList<SnakeSection>();
        sections.add(new SnakeSection(x,y));
        isAlive = true;

    }
}
