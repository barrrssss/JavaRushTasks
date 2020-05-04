package com.javarush.task.task19.task1904;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileInputStream("D:\\file6.txt"));
        PersonScanner personScanner = new PersonScannerAdapter(scanner);

        System.out.println(personScanner.read());
        System.out.println(personScanner.read());

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            String line = fileScanner.nextLine();
            String[] data = line.split(" ");

            Date birthDate = new Date(Integer.parseInt(data[5]) - 1900, Integer.parseInt(data[4]) - 1, Integer.parseInt(data[3]));
            Person person = new Person(data[1], data[2], data[0], birthDate);

            return person;
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
