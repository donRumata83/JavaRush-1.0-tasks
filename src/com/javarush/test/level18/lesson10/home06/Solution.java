package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.FileInputStream;
import java.io.IOException;


public class Solution
{
    public static void main(String[] args) throws IOException
    {
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        int[] letters = new int[128];
        while (fileInputStream.available() > 0)
        {
            letters[fileInputStream.read()]++;
        }
        fileInputStream.close();
        for (int i = 0; i < letters.length; i++)
        {
            if (letters[i] != 0)
            {
                System.out.println(Character.toString((char) i) + " " + letters[i]);
            }
        }
    }
}
