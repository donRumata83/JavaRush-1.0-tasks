package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        FileReader fileReader = new FileReader(sc.nextLine());
        FileWriter fileWriter = new FileWriter(sc.nextLine());
        sc.close();
        while (fileReader.ready())
        {
            int i = fileReader.read();
            if (i != 46) fileWriter.write(i);
            else fileWriter.write(33);
        }
        fileReader.close();
        fileWriter.close();
    }
}
