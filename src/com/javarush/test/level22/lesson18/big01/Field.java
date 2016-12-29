package com.javarush.test.level22.lesson18.big01;

/**
 * Created by Rumata on 29.12.2016.
 */
public class Field
{
    public int width;
    public int height;
    public int[][] matrix;

    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }

    public int[][] getMatrix()
    {
        return matrix;
    }

    public Field(int width, int height, int[][] matrix)
    {
        this.width = width;
        this.height = height;
        this.matrix = matrix;
    }

    public void print() {}

    public void removeFullLines() {}

    public Integer getValue(int x, int y) {return null;}

    public void setValue(int x, int y, int value) {}

}
