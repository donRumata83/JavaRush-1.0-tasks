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

    public void print()
    {
        for (int i = 0; i < getWidth(); i++)
        {
            for (int j = 0; j < getHeight(); j++)
            {
                if (matrix[j][i] == 0) System.out.print(".");
                else System.out.println("X");

            }
            System.out.println();
        }

    }

    public void removeFullLines() {}

    public Integer getValue(int x, int y) {return null;}

    public void setValue(int x, int y, int value) {}

}
