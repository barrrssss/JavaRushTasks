package com.javarush.task.task19.task1915;
/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        //Устанавливаем его как текущий System.out
        System.setOut(stream);

        testString.printSomething();

        String text = outputStream.toString();

        BufferedOutputStream outputStream1 = new BufferedOutputStream(new FileOutputStream(fileName));
        outputStream1.write(outputStream.toByteArray());
        outputStream1.close();

        System.setOut(consoleStream);
        System.out.println(text);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

