package com.javarush.test.level25.lesson16.big01;

/**
 * Created by Rumata on 03.02.2017.
 */
public class Canvas
{
    public int width;
    public int height;
    public char[][] matrix;

    public Canvas(int width, int height)
    {
        this.width = width;
        this.height = height;
        this.matrix = new char[height + 2][width + 2];
    }

    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }

    public char[][] getMatrix()
    {
        return matrix;
    }
}
