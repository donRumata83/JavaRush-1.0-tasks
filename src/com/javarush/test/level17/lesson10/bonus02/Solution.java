package com.javarush.test.level17.lesson10.bonus02;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/

public class Solution
{
    public volatile static List<Person> allPeople = new ArrayList<Person>();

    static
    {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws Exception
    {
        switch (args[0])
        {
            case "-c":
            {
                for (int i = 1; i < args.length; i += 3)
                {
                    create(args[i], args[i+1], args[i+2]);
                }
            }
            break;
            case "-u":
            {
                for (int i = 1; i < args.length; i+=4)
                update(args[i], args[i+1], args[i+2], args[i+3]);
            }
                break;
            case "-d":
            {
                for (int i = 1; i < args.length; i++)
                {
                    delete(args[i]);
                }
            }
            break;
            case "-i":
            {
                for (int i = 1; i < args.length; i++)
                {
                    info(args[i]);
                }
            }
            break;
        }

    }

    public synchronized static void create(String name, String sex, String birth) throws Exception
    {
        Sex sex1 = null;
        Date date;
        if (sex.equals("м")) sex1 = Sex.MALE;
        else
        {
            if (sex.equals("ж")) sex1 = Sex.FEMALE;
        }
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        date = format.parse(birth);
        if (sex1 == Sex.MALE) allPeople.add(Person.createMale(name, date));
        else allPeople.add(Person.createFemale(name, date));
        System.out.println(allPeople.size() - 1);

    }

    public synchronized static void update(String id, String name, String sex, String birth) throws Exception
    {
        Sex sex1 = null;
        Date date;
        int index = Integer.parseInt(id);
        if (sex.equals("м")) sex1 = Sex.MALE;
        else
        {
            if (sex.equals("ж")) sex1 = Sex.FEMALE;
        }
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

        date = format.parse(birth);
        allPeople.get(index).setName(name);
        allPeople.get(index).setBirthDay(date);
        allPeople.get(index).setSex(sex1);
    }

    public synchronized static void delete(String id)
    {
        int index = Integer.parseInt(id);

        allPeople.get(index).setBirthDay(null);

    }

    public static void info(String id)
    {
        int index = Integer.parseInt(id);
        String sex;
        DateFormat format = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        String date = format.format(allPeople.get(index).getBirthDay());
        if (allPeople.get(index).getSex() == Sex.MALE) sex = "м";
        else sex = "ж";

        System.out.println(allPeople.get(index).getName() + " " + sex + " " + date);
    }
}


