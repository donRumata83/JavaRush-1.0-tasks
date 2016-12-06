package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream in = new FileInputStream(reader.readLine());
        reader.close();
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int byteCounter = 0;
        while (in.available() > 0){
            int data = in.read();
            if (map.containsKey(data)){
                map.put(data, map.get(data)+1);
            }
            else map.put(data, 1);
            byteCounter++;
        }
        in.close();
        int i = byteCounter;
        for(Map.Entry<Integer, Integer> m : map.entrySet()){
            if (m.getValue() < i){
                i = m.getValue();
            }
        }
        for(Map.Entry<Integer, Integer> m : map.entrySet()){
            if (m.getValue() == i){
                System.out.println(m.getKey() + " ");
            }
        }
    }

    }

