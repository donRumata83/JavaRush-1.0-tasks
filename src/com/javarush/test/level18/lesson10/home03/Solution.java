package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String firstFile = scanner.nextLine();
        String secondFile = scanner.nextLine();
        String thirdFile = scanner.nextLine();
        scanner.close();
        FileInputStream secondFileStream = new FileInputStream(secondFile);
        FileInputStream thirdFileStream = new FileInputStream(thirdFile);
        FileOutputStream firstFileStream = new FileOutputStream(firstFile);
        int secondFileLength = secondFileStream.available();
        byte[] buff = new byte[1000];

        while (secondFileStream.available() > 0)
        {
            int count = secondFileStream.read(buff);
            firstFileStream.write(buff, 0, count);
        }
        while (thirdFileStream.available() > 0)
        {
            int count = thirdFileStream.read(buff);
            firstFileStream.write(buff, 0, count);
        }
        firstFileStream.close();
        secondFileStream.close();
        thirdFileStream.close();


    }
}
