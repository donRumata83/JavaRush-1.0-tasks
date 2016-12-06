package com.javarush.test.level19.lesson08.task05;

/* Дублируем текст
Считайте с консоли имя файла
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна дублировать вывод всего текста в файл, имя которого вы считали
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток
Закройте поток файла

Пример вывода на экран:
it's a text for testing

Пример тела файла:
it's a text for testing
*/

import java.io.ByteArrayOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        String result = outputStream.toString();
        StringBuilder stringBuilder = new StringBuilder(result);
        String reverseString = stringBuilder.toString();
        System.setOut(consoleStream);
        FileWriter fileWriter = new FileWriter(sc.nextLine());
        fileWriter.write(reverseString);
        fileWriter.close();
        System.out.println(reverseString);

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

