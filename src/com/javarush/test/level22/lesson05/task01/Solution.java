package com.javarush.test.level22.lesson05.task01;

import java.util.ArrayList;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
Метод main не участвует в тестировании.
*/
public class Solution
{
    public static String getPartOfString(String string) throws TooShortStringException
    {
        if (string == null) throw new TooShortStringException();

        String resultString;
        char[] massiv = string.toCharArray();
        ArrayList<Integer> indexOfSpaces = new ArrayList<>();
        for (int i =0; i < massiv.length; i++)
        {
            if (Character.isSpaceChar(massiv[i])) indexOfSpaces.add(i);
        }
        if (indexOfSpaces.size() < 5) throw new TooShortStringException();
        resultString = string.substring(indexOfSpaces.get(0) +1, indexOfSpaces.get(4));
        return resultString;
    }

    public static class TooShortStringException extends Exception
    {
    }

    public static void main(String[] args) throws TooShortStringException
    {
        System.out.println(getPartOfString("JavaRush - is fucking bullshit fo brains."));
    }
}
