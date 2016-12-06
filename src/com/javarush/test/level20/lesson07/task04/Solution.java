package com.javarush.test.level20.lesson07.task04;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* Serializable Solution
Сериализуйте класс Solution.
Подумайте, какие поля не нужно сериализовать, пометить ненужные поля — transient.
Объект всегда должен содержать актуальные итоговые данные.
Метод main не участвует в тестировании.
Написать код проверки самостоятельно в методе main:
1) создать файл, открыть поток на чтение (input stream) и на запись(output stream)
2) создать экземпляр класса Solution - savedObject
3) записать в поток на запись savedObject (убедитесь, что они там действительно есть)
4) создать другой экземпляр класса Solution с другим параметром
5) загрузить из потока на чтение объект - loadedObject
6) проверить, что savedObject.string равна loadedObject.string
7) обработать исключения
*/
public class Solution implements Serializable
{
    public static void main(String[] args)
    {
        System.out.println(new Solution(4));
        Solution savedObject = new Solution(2);
        try
        {
            File your_file_name = File.createTempFile("your_file_name", null);
            FileOutputStream fileOutput = new FileOutputStream(your_file_name);
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);
            if (!savedObject.equals(null)) outputStream.writeObject(savedObject);
            fileOutput.close();
            outputStream.close();
            Solution other = new Solution(3);
            FileInputStream fiStream = new FileInputStream(your_file_name);
            ObjectInputStream objectStream = new ObjectInputStream(fiStream);
            Solution loadedObject = (Solution) objectStream.readObject();
            fiStream.close();
            objectStream.close();
            if (savedObject.string.equals(loadedObject.string)) System.out.println("Strings equals");
            else System.out.println("Ooops! You are stupid idiot!");

        }
        catch (Exception e)
        {
        }



    }

    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;

    public Solution(int temperature)
    {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString()
    {
        return this.string;
    }
}
