package com.javarush.test.level18.lesson10.home08;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String enter;
        while (true)
        {
            enter = scanner.nextLine();
            if (!enter.equals("exit"))
            {
                new ReadThread(enter).start();
            }
            else break;
        }

    }

    public static class ReadThread extends Thread {
        private String fileName;
        public ReadThread(String fileName) {
           this.fileName = fileName;
        }

        @Override
        public void run()
        {
            try
            {
                FileInputStream fileInputStream = new FileInputStream(fileName);
                int[] massiv = new int[256];
                while (fileInputStream.available() > 0)
                {
                    massiv[fileInputStream.read()]++;
                }
                int maxByteCount=0;
                for (int i: massiv)
                {
                    if (i > maxByteCount) maxByteCount = i;
                }
                for (int i = 0; i < massiv.length; i++)
                {
                    if (massiv[i] == maxByteCount) resultMap.put(fileName, i);
                }
            } catch (IOException e) {}


        }
    }
}
