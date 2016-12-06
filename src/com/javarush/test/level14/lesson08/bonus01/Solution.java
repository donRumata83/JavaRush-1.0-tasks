package com.javarush.test.level14.lesson08.bonus01;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {   //it's first exception
        try
        {
            float i = 1 / 0;

        }
        catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            ArrayList<Integer> list = new ArrayList<>();
            list.get(list.size() + 1);
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            int i = -10;
            int[] massiv = new int[i];
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            String s = "papa";
            int i = Integer.parseInt(s);
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            List list = null;
            list.add(1);
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            Object obj = new Character('*');
            System.out.println((byte) obj);
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }


        try
        {
            String szShortString = "123";
            char chr = szShortString.charAt(10);
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            Object szStr[] = new String[10];
            szStr[0] = new Character('*');
        } catch (Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            FileInputStream file = new FileInputStream("b://abc.txt");
        } catch (Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            throw new InterruptedException();
        }catch (Exception e)
        {
            exceptions.add(e);
        }
    }


    }
