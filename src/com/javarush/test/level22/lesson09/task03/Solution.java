package com.javarush.test.level22.lesson09.task03;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
В файле не обязательно будет много слов.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/
public class Solution {
    public static void main(String[] args) throws IOException{
        Scanner consoleReader = new Scanner(System.in);
        String fileName = consoleReader.nextLine();
        consoleReader.close();
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        String words = "";
        while (fileReader.ready())
        {
            words = fileReader.readLine();
        }
        StringBuilder result = getLine(words.split(" "));
        System.out.println(result.toString());

    }

    public static StringBuilder getLine(String... words)
    {
        StringBuilder result = new StringBuilder();

        return result;
    }
}
