package com.javarush.test.level22.lesson13.task01;

import java.util.ArrayList;
import java.util.StringTokenizer;

/* StringTokenizer
Используя StringTokenizer разделить query на части по разделителю delimiter.
Пример,
getTokens("level22.lesson13.task01", ".") == {"level22", "lesson13", "task01"}
*/
public class Solution {
    public static String [] getTokens(String query, String delimiter)
    {

        ArrayList<String> resultArray = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(query, delimiter);
        while (tokenizer.hasMoreTokens())
        {
            resultArray.add(tokenizer.nextToken());
        }
        String[] result = new String[resultArray.size()];
        for (int i = 0; i < result.length; i++)
        {
            result[i] = resultArray.get(i);
        }
        return result;
    }
}
