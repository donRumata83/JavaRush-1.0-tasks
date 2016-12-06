package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(System.in);
        String file1 = scanner.nextLine();
        String file2 = scanner.nextLine();
        scanner.close();
        FileInputStream reader = new FileInputStream(file1);
        FileOutputStream writer = new FileOutputStream(file2);
        StringBuilder sb = new StringBuilder();
        int tmp;
        int rounded;
        byte[] buff;
        String s;
        float tmpFloat;
        while (reader.available() > 0)
        {
            tmp = reader.read();
            if (tmp != 32)
            {
                sb.append((char) tmp);
            }
            else
            {
                tmpFloat = Float.parseFloat(sb.toString());
                sb = new StringBuilder();
                rounded = Math.round(tmpFloat);
                s = rounded + " ";
                buff = s.getBytes();
                writer.write(buff);
            }
        }
        tmpFloat = Float.parseFloat(sb.toString());
        rounded = Math.round(tmpFloat);
        s = rounded + "";
        buff = s.getBytes();
        writer.write(buff);
        reader.close();
        writer.close();
    }
}
