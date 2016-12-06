package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.*;

public class Solution
{


    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        HashMap<String, Double> zpmap = new HashMap<>();

        String[] buff;
        Double tmp;
        while (reader.ready())
        {
            buff = reader.readLine().split(" ");
            if (!zpmap.containsKey(buff[0])) zpmap.put(buff[0], Double.parseDouble(buff[1]));
            else
            {
                tmp = Double.parseDouble(buff[1]) + zpmap.get(buff[0]);
                zpmap.put(buff[0], tmp);
            }
        }
        reader.close();
        ArrayList<String> list = new ArrayList<>(zpmap.keySet());
        Collections.sort(list);
        for (String s : list)
        {
            System.out.println(s + " " + zpmap.get(s));
        }
    }
}
