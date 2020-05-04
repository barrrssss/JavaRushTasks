package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Locale;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream printStream = System.out;
        System.setOut(new ReclamaPrintStream(printStream));
        testString.printSomething();
        System.setOut(printStream);

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }

    public static class ReclamaPrintStream extends PrintStream{
        private boolean newLineCount = true;

        public ReclamaPrintStream(OutputStream out) {
            super(out);
        }

        @Override
        public void println(String x) {
            super.println(x);
            newLineCount = !newLineCount;
            if (newLineCount) super.println("JavaRush - курсы Java онлайн");
        }


    }
}
