package com.javarush.test.level22.lesson09.task02;

import java.util.ArrayList;
import java.util.Map;

/* Формируем Where
Сформируйте часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.
Пример:
{"name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null}
Результат:
"name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'"
*/
public class Solution
{

    public static StringBuilder getCondition(Map<String, String> params)
    {
        StringBuilder result = new StringBuilder("");

        for (String s : params.keySet())
        {
            if (params.get(s) != null)
            {
                if (result.toString().equals(""))
                    result.append(s).append(" = ").append("'").append(params.get(s)).append("'");
                else result.append(" and ").append(s).append(" = ").append("'").append(params.get(s)).append("'");
            }
        }
        return result;
    }
}
