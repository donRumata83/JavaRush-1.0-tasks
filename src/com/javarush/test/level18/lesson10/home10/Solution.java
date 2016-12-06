package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String enter;
        ArrayList<String> arrayList = new ArrayList<>();
        while (true)
        {
            enter = scanner.nextLine();
            if (!enter.equals("end")) arrayList.add(enter);
            else break;

        }
        scanner.close();

        String mainFileName = arrayList.get(0).replaceFirst("\\.part[0-9]+$", "");
        Collections.sort(arrayList);
        try
        {
            FileInputStream fileInputStream = null;
            File file = new File(mainFileName);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] buff = new byte[1000];
            int count;

            for (int y = 0; y < arrayList.size(); y++)
            {
                fileInputStream = new FileInputStream(arrayList.get(y));
                while (fileInputStream.available() > 0)
                {
                    count = fileInputStream.read(buff);
                    fileOutputStream.write(buff, 0, count);
                }


            }
            fileInputStream.close();
            fileOutputStream.close();
        } catch (Exception e) {}




    }
}
