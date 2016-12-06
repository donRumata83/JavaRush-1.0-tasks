package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        scanner.close();
        switch (args[0])
        {
            case "-c":
                create(fileName, args[1], args[2], args[3]);
                break;
            case "-u":
                upgrade(fileName, args[1], args[2], args[3], args[4]);
                break;
            case "-d":
                delete(fileName, args[1]);
                break;
        }
    }

    public static void create(String fileName, String productName, String price, String quantity) throws IOException
    {
        File file = new File(fileName);
        String lastLine = ReadLastLine(file);
        String id = (Integer.parseInt(lastLine.substring(0, 8).replaceAll(" ", "")) + 1) + "";
        StringBuilder mainSb = new StringBuilder();
        mainSb.append(trimToSize(id, 8)).append(trimToSize(productName, 30)).append(trimToSize(price, 8)).append(trimToSize(quantity, 4));
        String lineToWrite = mainSb.toString();
        FileWriter writer = new FileWriter(file, true);
        writer.append("\n");
        writer.write(lineToWrite);
        writer.close();

    }

    public static void upgrade(String fileName, String id, String productName, String price, String quantity) throws IOException
    {

        StringBuilder sb = new StringBuilder();
        sb.append(trimToSize(id, 8)).append(trimToSize(productName, 30)).append(trimToSize(price, 8)).append(trimToSize(quantity, 4));
        String newLine = sb.toString();

        ArrayList<String> arrayList = new ArrayList<>();
        BufferedReader scanner = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        while (scanner.ready())
        {
            arrayList.add(scanner.readLine());
        }
        int index = 0;
        for (int i = 0; i < arrayList.size(); i++)
        {
            if (arrayList.get(i).substring(0, 8).replaceAll(" ", "").equals(id))
                index = i;
        }
        arrayList.remove(index);
        arrayList.add(index, newLine);
        scanner.close();
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        for (String s : arrayList)
        {
            s = s + "\r\n";
            fileOutputStream.write(s.getBytes());

        }
        fileOutputStream.close();
    }


    public static void delete(String fileName, String id) throws IOException
    {
        StringBuilder sb = new StringBuilder();

        ArrayList<String> arrayList = new ArrayList<>();
        BufferedReader scanner = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        while (scanner.ready())
        {
            arrayList.add(scanner.readLine());
        }

        int index = 0;
        for (int i = 0; i < arrayList.size(); i++)
        {
            if (arrayList.get(i).substring(0, 8).replaceAll(" ", "").equals(id))
                index = i;
        }
        sb.append(arrayList.get(index).substring(0, 8)).append(trimToSize(" ", 50));

        arrayList.remove(index);

        scanner.close();

        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        for (String s : arrayList)
        {
            s = s + "\r\n";
            fileOutputStream.write(s.getBytes());

        }
        fileOutputStream.close();
    }


    private static String ReadLastLine(File file) throws IOException
    {
        String result = null;
        try (RandomAccessFile raf = new RandomAccessFile(file, "r"))
        {
            long startIdx = file.length();
            while (startIdx >= 0 && (result == null || result.length() == 0))
            {
                raf.seek(startIdx);
                if (startIdx > 0)
                    raf.readLine();
                result = raf.readLine();
                startIdx--;
            }
        }
        return result;
    }

    public static String trimToSize(String line, int size)
    {
        StringBuilder sb = new StringBuilder();
        if (line.length() < size)
        {
            sb.append(line);
            for (int i = 0; i < size - line.length(); i++)
            {
                sb.append(" ");
            }
            line = sb.toString();
        }
        if (line.length() > size)
        {
            line = line.substring(0, size);
        }
        return line;
    }
}

