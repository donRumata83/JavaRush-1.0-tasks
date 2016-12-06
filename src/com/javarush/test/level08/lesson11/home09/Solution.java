package com.javarush.test.level08.lesson11.home09;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Не забудьте учесть первый день года.
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

public class Solution
{
    public static void main(String[] args) throws ParseException
    {
        System.out.println(isDateOdd("JANUARY 10 2020"));
    }

    public static boolean isDateOdd(String date) throws ParseException
    {
        boolean isOddDay = true;
        SimpleDateFormat format = new SimpleDateFormat("MMMM dd yyyy", Locale.ENGLISH);
        Date today = format.parse(date);
        int currentYear = today.getYear();
        Date dateOffFirstDayOfTheYear = new Date(currentYear,0,1);
        long differenceOfdates = today.getTime() - dateOffFirstDayOfTheYear.getTime();
        long msDay = 24 * 60 * 60 * 1000;
        int dayCount = (int) (differenceOfdates / msDay);
        if (dayCount%2 != 0) isOddDay = false;


        return isOddDay;
    }
}
