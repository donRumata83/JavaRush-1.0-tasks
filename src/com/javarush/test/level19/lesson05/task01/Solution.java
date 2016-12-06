package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
Закрыть потоки ввода-вывода.
*/

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(System.in);
        FileReader fileReader = new FileReader(scanner.nextLine());
        FileWriter fileWriter = new FileWriter(scanner.nextLine());
        int counter = 0;
        while (fileReader.ready())
        {
            int data = fileReader.read();
            counter++;
            if (counter%2 == 0) fileWriter.write(data);
        }
        fileReader.close();
        fileWriter.close();
    }
}
