package com.javarush.test.level09.lesson11.home09;

import java.util.*;

/* Десять котов
Создать класс кот – Cat, с полем «имя» (String).
Создать словарь Map(<String, Cat>) и добавить туда 10 котов в виде «Имя»-«Кот».
Получить из Map множество(Set) всех имен и вывести его на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap()
    {
        HashMap<String, Cat> map = new HashMap<>();
       for (int i =1; i < 11; i++)
       {
           map.put(Integer.toString(i), new Cat(Integer.toString(i)));
       }

    return map;

    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map)
    {
        Set<Cat> set1 = new HashSet<Cat>();
       for (Map.Entry<String, Cat> pair : map.entrySet())
       {
           set1.add(pair.getValue());
       }
       return set1;
    }

    public static void printCatSet(Set<Cat> set)
    {
        for (Cat cat:set)
        {
            System.out.println(cat);
        }
    }

    public static class Cat
    {
        private String name;

        public Cat(String name)
        {
            this.name = name;
        }

        public String toString()
        {
            return "Cat "+this.name;
        }
    }


}
