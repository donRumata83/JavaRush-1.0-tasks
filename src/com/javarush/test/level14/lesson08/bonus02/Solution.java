package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        Scanner reader = new Scanner(System.in);
        int firstNumber = reader.nextInt();
        int secondNumber = reader.nextInt();
        int minOfNumbers;
        int maxDelitel = 0;
        if (firstNumber < secondNumber) minOfNumbers = firstNumber;
        else minOfNumbers = secondNumber;
        if (firstNumber == secondNumber) maxDelitel = firstNumber;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= minOfNumbers; i++)
        {
            if (firstNumber%i == 0 && secondNumber%i == 0) list.add(i);
        }
        if (maxDelitel==0)
        {
            maxDelitel = Collections.max(list);
            System.out.println(maxDelitel);
        }
        else System.out.println(maxDelitel);
    }
}
