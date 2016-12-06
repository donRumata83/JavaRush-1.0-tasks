package com.javarush.test.level14.lesson08.home03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* User, Looser, Coder and Proger
1. Ввести [в цикле] с клавиатуры несколько строк (ключей).
Строки(ключи) могут быть такими: "user", "looser", "coder", "proger".
Ввод окончен, когда строка не совпадает ни с одной из выше указанных.

2. Для каждой введенной строки нужно:
2.1. Создать соответствующий объект [см Person.java], например, для строки "user" нужно создать объект класса User.
2.2. Передать этот объект в метод doWork.

3. Написать реализацию метода doWork, который:
3.1. Вызывает метод live() у переданного обекта, если этот объект (person) имеет тип User.
3.2. Вызывает метод doNothing(), если person имеет тип Looser.
3.3. Вызывает метод coding(), если person имеет тип Coder.
3.4. Вызывает метод enjoy(), если person имеет тип Proger.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = null;
        boolean stoper = true;
        while (stoper)
        {
            key = reader.readLine();
            switch (key)
            {
                case "user":
                    person = new Person.User();
                    doWork(person);
                    break;
                case "looser":
                    person = new Person.Looser();
                    doWork(person);
                    break;
                case "coder":
                    person = new Person.Coder();
                    doWork(person);
                    break;
                case "proger":
                    person = new Person.Proger();
                    doWork(person);
                    break;
                default:
                    stoper = false;
            }

        }
    }

    public static void doWork(Person person)
    {
        String personClass = person.getClass().getSimpleName();
        switch (personClass)
        {
            case "User":
                ((Person.User) person).live();
                break;
            case "Looser":
                ((Person.Looser) person).doNothing();
                break;
            case "Coder":
                ((Person.Coder) person).coding();
                break;
            case "Proger":
                ((Person.Proger) person).enjoy();
                break;
        }
    }
}
