package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws Exception
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
        String  id =  (Integer.parseInt(lastLine.substring(0, 8).replaceAll(" ", ""))+1)+ "";
        StringBuilder mainSb = new StringBuilder();
        mainSb.append(trimToSize(id, 8)).append(trimToSize(productName, 30)).append(trimToSize(price, 8)).append(trimToSize(quantity, 4));
        String lineToWrite = mainSb.toString();
        FileWriter writer = new FileWriter(file, true);
        writer.append("\r\n");
        writer.write(lineToWrite);
        writer.close();

    }

    public static void upgrade(String fileName, String id, String productName, String price, String quantity)
    {

    }

    public static void delete(String fileName, String id)
    {

    }
    private static String ReadLastLine(File file) throws IOException {
        String result = null;
        try (RandomAccessFile raf = new RandomAccessFile(file, "r")) {
            long startIdx = file.length();
            while (startIdx >= 0 && (result == null || result.length() == 0)) {
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
        return line;
    }
}


