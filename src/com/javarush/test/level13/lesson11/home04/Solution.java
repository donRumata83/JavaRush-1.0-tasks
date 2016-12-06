package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой стороки.
*/

import java.io.*;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        OutputStream outStream = new FileOutputStream(fileName);
        String data;
        ArrayList<String> list = new ArrayList<>();
        while (true)
        {
            data = reader.readLine();
            list.add(data);
            if (data.equals("exit"))  break;
        }
        String perehod = "\r\n";
        for (String s: list)
        {
            outStream.write((s + perehod).getBytes());
        }
        reader.close();
        outStream.close();

    }
}
