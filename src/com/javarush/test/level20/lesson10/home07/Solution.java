package com.javarush.test.level20.lesson10.home07;

import java.io.*;

/* Переопределение сериализации в потоке
Сериализация/десериализация Solution не работает.
Исправьте ошибки не меняя сигнатуры методов и класса.
Метод main не участвует в тестировании.
Написать код проверки самостоятельно в методе main:
1) создать экземпляр класса Solution
2) записать в него данные  - writeObject
3) сериализовать класс Solution  - writeObject(ObjectOutputStream out)
4) десериализовать, получаем новый объект
5) записать в новый объект данные - writeObject
6) проверить, что в файле есть данные из п.2 и п.5
*/
public class Solution implements Serializable, AutoCloseable {
    private FileOutputStream stream;

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.close();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        String string = (String)in.readObject();
        in.defaultReadObject();
        in.close();
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }
    public static void main(String args[]) throws Exception
    {
        FileOutputStream fileOutput = new FileOutputStream("b://1.txt");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);

        Solution solution = new Solution("b://1.txt");
        solution.writeObject("something");
        solution.writeObject(outputStream);

        fileOutput.close();
        outputStream.close();

        //loading
        FileInputStream fiStream = new FileInputStream("b://1.txt");
        ObjectInputStream objectStream = new ObjectInputStream(fiStream);

        solution.readObject(objectStream);
        solution.writeObject("something2");


        fiStream.close();
        objectStream.close();


    }
}
