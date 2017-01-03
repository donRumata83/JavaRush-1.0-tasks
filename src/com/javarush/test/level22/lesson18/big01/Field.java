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

    public Field(int width, int height)
    {
        this.width = width;
        this.height = height;
        this.matrix = new int[height][width];
    }

    public void print()
    {
        for (int row = 0; row < getHeight(); row++) {
            for (int col = 0; col < getWidth(); col++) {
                if (getValue(row, col) == 0){
                    System.out.print(".");

                }  else System.out.print("X");
            }
            System.out.println();
        }
    }

    public void removeFullLines() {}

    public Integer getValue(int row, int col) {return matrix[row][col];}

    public void setValue(int row, int col, int value) {matrix[row][col] = value;}

}
