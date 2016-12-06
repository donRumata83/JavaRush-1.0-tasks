package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException{
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        int[] letters = new int[256];
        while (fileInputStream.available() > 0)
        {
            letters[fileInputStream.read()]++;
        }
        int summLowerCase = 0;
        int summUpperCase = 0;
        for (int i = 65; i < 91; i++)
        {
            summUpperCase += letters[i];
        }
        for (int i = 97; i < 123; i++)
        {
            summLowerCase += letters[i];
        }
        int allLetersSumm = summLowerCase + summUpperCase;
        System.out.println(allLetersSumm);
        fileInputStream.close();
    }
}
