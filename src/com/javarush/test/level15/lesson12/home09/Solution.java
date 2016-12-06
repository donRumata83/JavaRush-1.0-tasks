package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/


import java.util.ArrayList;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String uri = sc.nextLine();
        sc.close();
        int position = uri.indexOf('?');
        uri = uri.substring(position + 1, uri.length());
        String[] list = uri.split("&");
        String stringline = "!";
        String keyline = "!";
        ArrayList<Double> doubles = new ArrayList<>();
        String[] list2 = new String[2];
        for (String s : list)
        {
            list2 = separator(s);
            if (keyline.equals("!")) keyline = list2[0];
            else keyline = keyline + " " + list2[0];
            if (list2[0].equals("obj") && list2.length > 1)
            {
                try
                {
                    doubles.add(Double.parseDouble(list2[1]));
                }
                catch (Exception e)
                {
                    if (stringline.equals("!")) stringline = list2[1];
                    else stringline = stringline + " " + list2[1];
                }
            }

        }
        System.out.println(keyline);
        for (Double d: doubles)
        {alert(d);}
        if (!stringline.equals("!"))alert(stringline);

    }

    public static String[] separator(String s)
    {
        String[] list = s.split("=");
        return list;
    }

    public static void alert(double value)
    {
        System.out.println("double " + value);
    }

    public static void alert(String value)
    {
        System.out.println("String " + value);
    }
}
