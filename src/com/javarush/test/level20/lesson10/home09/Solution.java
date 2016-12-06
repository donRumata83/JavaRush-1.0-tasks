package com.javarush.test.level20.lesson10.home09;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.LinkedList;
import java.util.List;

/* Знакомство с графами
Прочитать в дополнительных материалах о сериализации графов.
Дан ориентированный плоский граф Solution, содержащий циклы и петли.
Пример, http://edu.nstu.ru/courses/saod/images/graph1.gif
Сериализовать Solution.
Все данные должны сохранить порядок следования.
*/
public class Solution implements Externalizable
{
    int node;
    List<Solution> edges = new LinkedList<>();

    public Solution()
    {
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException
    {
        out.writeInt(edges.size());
        for (Solution s : edges)
        {
            s.writeExternal(out);
        }
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException
    {
        int count = in.readInt();
        for (int i = count; i > 0; i--)
        {
            Solution s = new Solution();
            s.readExternal(in);
            edges.add(s);
        }
    }
}
