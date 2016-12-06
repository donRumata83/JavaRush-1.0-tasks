package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        Scanner scanner = new Scanner(System.in);
        String firstFile = scanner.nextLine();
        String secondFile = scanner.nextLine();
        scanner.close();
        FileInputStream first = new FileInputStream(firstFile);
        FileInputStream second = new FileInputStream(secondFile);
        byte[] buff2 = new byte[second.available()];
        int secondLength = second.read(buff2);
        byte[] buff = new byte[first.available()];
        int firstLength = first.read(buff);
        first.close();
        second.close();
        FileOutputStream writer = new FileOutputStream(firstFile);
        writer.write(buff2, 0, secondLength);
        writer.write(buff, 0, firstLength);
        writer.close();
    }
}
