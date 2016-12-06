package com.javarush.test.level18.lesson03.task01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Максимальный байт
Ввести с консоли имя файла
Найти максимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        FileInputStream fileInputStream = new FileInputStream(fileName);
        int maxBite = 0;
        while (fileInputStream.available() > 0)
        {
            int nextBite = fileInputStream.read();
            if (nextBite > maxBite) maxBite = nextBite;
        }
        fileInputStream.close();
        System.out.println(maxBite);
    }
}
