package com.javarush.test.level22.lesson09.task01;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример содержимого файла
рот тор торт о
о тот тот тот
Вывод:
рот тор
о о
тот тот
*/
public class Solution
{
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException
    {
        Scanner consoleReader = new Scanner(System.in);
        String fileName = consoleReader.nextLine();
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        StringBuilder allwords = new StringBuilder();
        while (fileReader.ready())
        {
            allwords.append(fileReader.readLine());
        }
        String allWordsInString = allwords.toString();
        allWordsInString.replaceAll("\\r\\n|\\n", " ");
        String[] array = allWordsInString.split(" ");
        StringBuilder sbi;
        StringBuilder sby;
        for (int i = 0; i < array.length; i++)
        {
            sbi = new StringBuilder(array[i]);
            for (int y = i; y < array.length; y++)
            {
                sby = new StringBuilder(array[y]);
                if (sbi.reverse().toString().equals(sby.toString()))
                {
                    if (!sbi.toString().equals("") || !sby.toString().equals(""))
                    {
                        result.add(new Pair(sbi.toString(), sby.toString()));
                        array[y] = "";
                    }
                }
            }
        }
        for (Pair pair : result)
        {
            System.out.println(pair);
        }
    }

    public static class Pair
    {
        String first;
        String second;

        public Pair(String first, String second)
        {
            this.first = first;
            this.second = second;
        }

        @Override
        public String toString()
        {
            return first == null && second == null ? "" :
                    first == null && second != null ? second :
                            second == null && first != null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
