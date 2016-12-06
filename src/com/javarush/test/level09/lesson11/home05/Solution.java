package com.javarush.test.level09.lesson11.home05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/* Гласные и согласные буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа должна вывести на экран две строки:
1. первая строка содержит только гласные буквы
2. вторая - только согласные буквы и знаки препинания из введённой строки.
Буквы соединять пробелом, каждая строка должна заканчиваться пробелом.

Пример ввода:
Мама мыла раму.
Пример вывода:
а а ы а а у
М м м л р м .
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        char[] array = word.toCharArray();
        ArrayList<Character> vowelsList = new ArrayList<>();
        ArrayList<Character> noVowelList = new ArrayList<>();
        for (int i =0; i < array.length; i++)
        {
            if (isVowel(array[i])) vowelsList.add(array[i]);
            else if (!Character.isWhitespace(array[i])) noVowelList.add(array[i]);
        }
        for (int i = 0; i < vowelsList.size(); i++)
        {
            if (i != vowelsList.size() - 1) System.out.print(vowelsList.get(i) + " ");
            else System.out.println(vowelsList.get(i) + " ");
        }
        for (int i = 0; i < noVowelList.size(); i++)
        {
            if (i != noVowelList.size() - 1) System.out.print(noVowelList.get(i) + " ");
            else System.out.println(noVowelList.get(i) + " ");
        }
    }


    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    //метод проверяет, гласная ли буква
    public static boolean isVowel(char c)
    {
        c = Character.toLowerCase(c);  //приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   //ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }
}
