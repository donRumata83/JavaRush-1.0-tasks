package com.javarush.test.level19.lesson10.home04;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* Ищем нужные строки
Считать с консоли имя файла.
Вывести в консоль все строки из файла, которые содержат всего 2 слова из списка words
Закрыть потоки. Не использовать try-with-resources

Пример: words содержит слова А, Б, В
Строки:
В Б А Д  //3 слова из words, не подходит
Д А Д    //1 слово из words, не подходит
Д А Б Д  //2 слова - подходит, выводим
*/

public class Solution
{
    public static List<String> words = new ArrayList<String>();

    static
    {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = null;
        String fileName = null;

        try
        {
            reader = new BufferedReader(new InputStreamReader(System.in));
            fileName = reader.readLine();
        }
        catch (IOException e)
        {
            System.out.println("IOException");
        }
        finally
        {
            if (reader != null)
            {
                try
                {
                    reader.close();
                }
                catch (IOException e)
                {
                    System.out.println("IOException");
                }
            }
        }

        Scanner fileScanner = null;

        try
        {
            fileScanner = new Scanner(new BufferedReader(new FileReader(fileName)));
            String aLine;
            while (fileScanner.hasNextLine())
            {
                aLine = fileScanner.nextLine(); //read line
                String[] aLineArray = aLine.replaceAll("\\p{Punct}", " ").split(" ");
                int count = 0;
                for (String aWord : aLineArray)
                {
                    for (int j = 0; j < words.size(); j++)
                    {
                        if (aWord.equals(words.get(j))) count++;
                    }
                }
                if (count == 2) System.out.println(aLine);
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("FileNotFoundException");
        }
        catch (Exception e)
        {
            System.out.println("Exception");
        }
        finally
        {
            if (fileScanner != null) fileScanner.close();
        }
    }
}