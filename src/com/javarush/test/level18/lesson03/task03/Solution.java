package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;


/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        FileInputStream fileInputStream = new FileInputStream(fileName);
        int[] array = new int[256];
        int nextByte;
        while (fileInputStream.available() > 0)
        {
            nextByte = fileInputStream.read();
            array[nextByte]++;
        }
        int maxValue = 0;
        for (int i = 0; i < array.length; i++)
        {
            if (maxValue < array[i]) maxValue= array[i];
        }
        for (int i = 0; i < array.length; i++)
        {
            if (maxValue == array[i]) System.out.print(i);
        }
    }
}
