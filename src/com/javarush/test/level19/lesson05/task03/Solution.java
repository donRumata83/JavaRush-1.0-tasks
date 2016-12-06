package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        String fromfile = sc.nextLine();
        String tofile = sc.nextLine();
        sc.close();
        Scanner fileReader = new Scanner(new FileReader(fromfile));
        FileWriter fileWriter = new FileWriter(tofile);
        String tmp;
        while (fileReader.hasNext())
        {
            tmp = fileReader.next();
            if (isNumber(tmp)) fileWriter.write(tmp + " ");
        }
        fileReader.close();
        fileWriter.close();

    }
    public static boolean isNumber(String str) {
        if (str == null || str.isEmpty()) return false;
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) return false;
        }
        return true;
    }
}
