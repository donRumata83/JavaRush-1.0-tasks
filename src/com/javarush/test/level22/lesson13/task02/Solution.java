package com.javarush.test.level22.lesson13.task02;

import java.io.*;
import java.nio.charset.Charset;

/* Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException
    {
        Charset w1251 = Charset.forName("Windows-1251");
        Charset utf = Charset.forName("UTF-8");
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        FileOutputStream writer = new FileOutputStream(args[1]);

        String temp;
        while (reader.ready())
        {
            temp = new String(reader.readLine().getBytes(w1251));
            writer.write(temp.getBytes(utf));
        }
        reader.close();
        writer.close();


    }
}
