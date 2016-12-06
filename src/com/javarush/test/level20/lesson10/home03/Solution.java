package com.javarush.test.level20.lesson10.home03;

import java.io.*;

/* Найти ошибки
Почему-то при сериализации/десериализации объекта класса B возникают ошибки.
Найдите проблему и исправьте ее.
Класс A не должен реализовывать интерфейсы Serializable и Externalizable.
Сигнатура класса В не содержит ошибку :)
Метод main не участвует в тестировании.
*/
public class Solution {
    public class A {
        protected String name = "A";
        private static final long serialVersionUID = 170501993;
        protected A(){}
        public A(String name) {
            this.name += name;
        }
    }

    public class B extends A implements Serializable {
        private static final long serialVersionUID = 170501993;
        public B(String name) {
            super(name);
            this.name += name;
        }

    }
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {

        FileOutputStream fileOutputStream = new FileOutputStream("b://1.txt");

        InputStream inputStream = new FileInputStream("b://1.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

        Solution solution = new Solution();

        Solution.B b1 = solution.new B("first");
        System.out.println(b1 + " " + b1.name + " name parameter before saving");

        objectOutputStream.writeObject(b1);
        objectOutputStream.writeObject(b1.name);
        objectOutputStream.flush();
        objectOutputStream.close();
        System.out.println(b1 + " " + b1.name);

        Solution.B b2 = solution.new B("second");
        System.out.println(b2 + " " + b2.name);


        b2 = (B)(objectInputStream.readObject());
        b2.name = (String)(objectInputStream.readObject());
        System.out.println(b2 + " " + b2.name + " - name parameter, after reading");

    }

}
