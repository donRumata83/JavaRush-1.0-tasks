package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.*;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution
{
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap()
    {
        Scanner sc = new Scanner(System.in);
        String fileName = sc.nextLine();
        sc.close();
        try
        {

            InputStream inputStream = new FileInputStream(fileName);
            load(inputStream);
        }
        catch (Exception e)
        {
        }
    }

    public void save(OutputStream outputStream) throws Exception
    {
        Properties saveProperties = new Properties();
        for (Map.Entry<String, String> prop : properties.entrySet())
        {

            saveProperties.setProperty(prop.getKey(), prop.getValue());//сохраняем данные в наш new prop
        }
        saveProperties.save(outputStream, null);
    }

    public void load(InputStream inputStream) throws Exception
    {
        Properties prop = new Properties();
        prop.load(inputStream);
        Enumeration<?> enumeration = prop.propertyNames();
        while (enumeration.hasMoreElements())
        {
            String key = (String) enumeration.nextElement();
            String value = prop.getProperty(key);
            properties.put(key, value);
        }

    }
}
