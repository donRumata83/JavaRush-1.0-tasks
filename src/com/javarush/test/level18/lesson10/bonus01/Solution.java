package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution
{
    public static void main(String[] args) throws IOException
    {


        if (args[0].equals("-e")) encryption(args[1], args[2]);
        if (args[0].equals("-d")) decryption(args[1], args[2]);


    }

    public static void encryption(String start, String finish) throws IOException
    {
        FileInputStream fileInputStream = new FileInputStream(start);
        FileOutputStream fileOutputStream = new FileOutputStream(finish);
        int tmp;
        while (fileInputStream.available() > 0)
        {
            tmp = fileInputStream.read();
            if (tmp == 255) tmp = 0;
            else tmp++;
            fileOutputStream.write(tmp);
        }
        fileInputStream.close();
        fileOutputStream.close();
    }

    public static void decryption(String start, String finish) throws IOException
    {
        FileInputStream fileInputStream = new FileInputStream(start);
        FileOutputStream fileOutputStream = new FileOutputStream(finish);
        int tmp;
        while (fileInputStream.available() > 0)
        {
            tmp = fileInputStream.read();
            if (tmp == 0) tmp = 255;
            else tmp--;
            fileOutputStream.write(tmp);
        }
        fileInputStream.close();
        fileOutputStream.close();
    }
}
