package com.javarush.test.level17.lesson10.bonus01;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/

public class Solution
{
    public static List<Person> allPeople = new ArrayList<Person>();

    static
    {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args)throws Exception
    {

        switch (args[0])
        {
            case "-c":
                create(args[1], args[2], args[3]);
                break;
            case "-u":
                update(args[1], args[2], args[3], args[4]);
                break;
            case "-d":
                delete(args[1]);
                break;
            case "-i":
                info(args[1]);
                break;
        }

        }

    public static void create(String name, String sex, String birth) throws Exception
    {
        Sex sex1 = null;
        Date date;
        if (sex.equals("м")) sex1 = Sex.MALE;
        else {if (sex.equals("ж")) sex1 = Sex.FEMALE;}
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        date = format.parse(birth);
        if (sex1 == Sex.MALE) allPeople.add(Person.createMale(name, date));
        else allPeople.add(Person.createFemale(name, date));
        System.out.println(allPeople.size()-1);

    }

    public static void update(String id, String name, String sex, String birth) throws Exception
    {
        Sex sex1 = null;
        Date date;
        int index = Integer.parseInt(id);
        if (sex.equals("м")) sex1 = Sex.MALE;
        else {if (sex.equals("ж")) sex1 = Sex.FEMALE;}
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

            date = format.parse(birth);
        allPeople.get(index).setName(name);
        allPeople.get(index).setBirthDay(date);
        allPeople.get(index).setSex(sex1);
    }

    public static void delete(String id)
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
