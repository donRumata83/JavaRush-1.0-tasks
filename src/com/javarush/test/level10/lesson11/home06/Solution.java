package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него.
Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        String firstName;
        String lastName;
        int age;
        String adres;
        Boolean maried;
        int children;

        Human(String firstName, String lastName, int age, String adres, boolean maried, int children)
        {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.adres = adres;
            this.maried = maried;
            this.children = children;
        }

        Human(String firstName, String lastName, int age, String adres, boolean maried)
        {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.adres = adres;
            this.maried = maried;
        }

        Human(String firstName, String lastName, int age, String adres)
        {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.adres = adres;
        }

        Human(String firstName, String lastName, int age, boolean maried, int children)
        {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.maried = maried;
            this.children = children;
        }

        Human(String firstName, String lastName, int age, boolean maried)
        {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.maried = maried;
        }

        Human(String firstName, String lastName, int age)
        {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        Human(String firstName, String lastName)
        {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        Human(String firstName, int age)
        {
            this.firstName = firstName;
            this.age = age;
        }

        Human(String firstName, int age, String adres)
        {
            this.firstName = firstName;
            this.age = age;
            this.adres = adres;
        }

        Human(String firstName, String lastName, String adres)
        {
            this.firstName = firstName;
            this.lastName = lastName;
            this.adres = adres;
        }
    }
}
