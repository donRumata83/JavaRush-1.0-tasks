package com.javarush.test.level15.lesson09.task02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/* Статики 2
1. В статическом блоке считайте две переменные с консоли А и В с типом int.
2. Не забыть про IOException, который надо обработать в блоке catch.
3. Закрыть поток ввода методом close().
*/

public class Solution
{
    public static int A;
    public static int B;
    static BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

    static
    {
        try
        {
            A = Integer.parseInt(sc.readLine());
            B = Integer.parseInt(sc.readLine());
            sc.close();
        }
        catch (IOException e)
        {
        }
    }

    public static final int MIN = min(A, B);

    public static void main(String[] args)
    {
        System.out.println(MIN);
    }

    public static int min(int a, int b)
    {
        return a < b ? a : b;
    }
}
