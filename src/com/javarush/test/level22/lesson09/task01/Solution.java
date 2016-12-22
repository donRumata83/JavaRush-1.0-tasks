package com.javarush.test.level22.lesson09.task01;

import java.io.*;

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
        consoleReader.close();
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        StringBuilder allwords = new StringBuilder();
        while (fileReader.ready())
        {
            allwords.append(fileReader.readLine()).append(" ");
        }
        fileReader.close();
        String allWordsInString = (allwords.toString()).toLowerCase();
        String[] array = allWordsInString.split(" ");

        StringBuilder sby;
        for (int i = 0; i < array.length; i++)
        {
            for (int y = i + 1; y < array.length; y++)
            {
                sby = new StringBuilder(array[y]);
                sby = sby.reverse();
                if (array[i].equals(sby.toString()) && !array[i].equals("") && !sby.toString().equals(""))
                {
                    result.add(new Pair(array[i], array[y]));
                    array[y] = "";
                    array[i] = "";
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
