package com.javarush.test.level16.lesson03.task03;

import java.util.ArrayList;
import java.util.List;

/* Список и нити
В методе main добавить в статический объект list 5 нитей SpecialThread - различных объектов.
*/

public class Solution {
    public static volatile List<Thread> list = new ArrayList<Thread>(5);

    public static void main(String[] args) {
        SpecialThread one = new SpecialThread();
        list.add(new Thread(one));
        SpecialThread two = new SpecialThread();
        list.add(new Thread(two));
        SpecialThread three = new SpecialThread();
        list.add(new Thread(three));
        SpecialThread four = new SpecialThread();
        list.add(new Thread(four));
        SpecialThread five = new SpecialThread();
        list.add(new Thread(five));
    }

    public static class SpecialThread implements Runnable {
        public void run() {
            System.out.println("it's run method inside SpecialThread");
        }
    }
}
