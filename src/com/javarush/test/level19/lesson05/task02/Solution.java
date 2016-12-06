package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/


import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc =new Scanner(System.in);
        FileReader fileReader = new FileReader(sc.nextLine());
        char[] buff = new char[10];
        StringBuilder sb = new StringBuilder();
        while (fileReader.ready())
        {
            fileReader.read(buff);
            sb.append(buff);
        }
        String words = sb.toString();
        System.out.println(words);
        words.replaceAll("[^a-zA-Z]", " ");
        System.out.println(words);
        String[] buffer = words.split(" ");

        int worldCounter = 0;
        for (String s : buffer)
        {if (s.equals("world")) worldCounter++;}

        System.out.println(worldCounter);
        sc.close();
        fileReader.close();
    }
}
