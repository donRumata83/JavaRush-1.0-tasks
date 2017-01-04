package com.javarush.test.level22.lesson18.big01;

/**
 * Created by Rumata on 29.12.2016.
 */
public class Field
{
    private int width;
    private int height;
    private int[][] matrix;

    public Field(int width, int height)
    {
        this.width = width;
        this.height = height;
        this.matrix = new int[height][width];
    }

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

    public void print()
    {
        for (int i = 0; i < getHeight(); i++)
        {
            for (int j = 0; j < getWidth(); j++)
            {
                if (getValue(j, i) == 0) System.out.print(".");
                else System.out.print("X");
            }
            System.out.println();
        }
    }

    public void removeFullLines()
    {
    }

    public Integer getValue(int x, int y)
    {
        if (x < 0 || y < 0 || y > getHeight() - 1 || x > getWidth() - 1)
        {
            return -1;
        } else
            return matrix[y][x];
    }

    public void setValue(int x, int y, int value)
    {
        if (x < 0 || y < 0 || y > getHeight() - 1 || x > getWidth() - 1)
        {
        } else matrix[y][x] = value;
    }
}
