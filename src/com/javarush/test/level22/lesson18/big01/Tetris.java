package com.javarush.test.level22.lesson18.big01;

/**
 * Created by Rumata on 29.12.2016.
 */
public class Tetris
{
    public Field field;
    public Figure figure;
    public static Tetris game;

    public Field getField()
    {
        return field;
    }

    public Figure getFigure()
    {
        return figure;
    }
    public void run() {}

    public void step(){}



    public static void main(String[] args)
    {
        game = new Tetris();
        game.run();
        Field field = new Field(20,10);
        field.setValue(1,0,1);
        field.setValue(1,1,1);
        field.print();

    }
}
