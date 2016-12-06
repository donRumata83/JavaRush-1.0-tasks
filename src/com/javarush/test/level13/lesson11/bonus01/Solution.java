package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String fileName = sc.readLine();
        sc.close();
        BufferedReader readerFromFile = new BufferedReader(new FileReader(fileName));
        ArrayList<Integer> oddList = new ArrayList<Integer>();
        int tmp;
        while (readerFromFile.ready())
        {
            tmp = Integer.parseInt(readerFromFile.readLine());
            if (tmp%2 == 0)
            {
                oddList.add(tmp);
            }
        }
        readerFromFile.close();

        Collections.sort(oddList);
        for (int i: oddList) System.out.println(i);
    }
}