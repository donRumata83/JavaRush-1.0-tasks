package com.javarush.test.level10.lesson11.home08;

import java.util.ArrayList;


/* Массив списков строк
Создать массив, элементами которого будут списки строк. Заполнить массив любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<String>[] arrayOfStringList =  createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList()
    {
        ArrayList<String> list1 = new ArrayList<String>();
        list1.add("1");
        list1.add("1");
        list1.add("1");
        ArrayList<String> list2 = new ArrayList<String>(list1);
        ArrayList<String> list3 = new ArrayList<String>(list1);
        ArrayList<String>[] massiv = new ArrayList[3];
        massiv[0] = list1;
        massiv[1] = list2;
        massiv[2] = list3;

        return massiv;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList)
    {
        for (ArrayList<String> list: arrayOfStringList)
        {
            for (String s : list)
            {
                System.out.println(s);
            }
        }
    }
}