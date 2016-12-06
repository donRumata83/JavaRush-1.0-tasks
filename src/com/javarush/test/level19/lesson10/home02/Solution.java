package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {
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
        ArrayList<Double> list = new ArrayList<>(zpmap.values());
        Collections.sort(list);
        double max = list.get(list.size()-1);
        for (Map.Entry<String, Double> pair : zpmap.entrySet())
        {
            if (pair.getValue()== max) System.out.println(pair.getKey());
        }
    }
}
