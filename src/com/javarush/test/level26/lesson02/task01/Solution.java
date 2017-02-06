package com.javarush.test.level26.lesson02.task01;


import java.util.*;

/* Почитать в инете про медиану выборки
Реализовать логику метода sort, который должен сортировать данные в массиве по удаленности от его медианы
Вернуть отсортированный массив от минимального расстояния до максимального
Если удаленность одинаковая у нескольких чисел, то выводить их в порядке возрастания
*/
public class Solution {
    public static Integer[] sort(Integer[] array) {
        Arrays.sort(array);
        double median = 0;
        if (array.length%2 != 0) median = array[(int)array.length/2];
        else median = (double)((array[array.length/2] + array[array.length/2-1])/2);
        final double finalMedian = median;


        Arrays.sort(array, new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                if(Math.abs(finalMedian-o1) - Math.abs(finalMedian-o2)!=0)
                    return (int)(Math.abs(finalMedian-o1) - Math.abs(finalMedian-o2));
                else
                    return o1-o2;
            }
        });
        //implement logic here
        return array;
    }
    public static void main(String[] args) {
        Integer[] integers={3, 4, 7, 6, 5, 2, 1, 11, 5, 48, 49, 56, 92, 94};
        Integer[] integers1 = sort(integers);
        for (Integer integer : integers1) {
            System.out.print(integer + ", ");
        }
    }

}

