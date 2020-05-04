package com.javarush.task.task32.task3210;

/* 
Используем RandomAccessFile
*/

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

public class Solution {
    public static void main(String... args) {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(args[0], "rw")) {
            long position = Long.parseLong(args[1]);
            byte[] text = new byte[args[2].length()];

            randomAccessFile.seek(position);
            randomAccessFile.read(text, 0, text.length);

            boolean equals = Arrays.equals(text, args[2].getBytes());

            randomAccessFile.seek(randomAccessFile.length());
            randomAccessFile.write(String.valueOf(equals).getBytes());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
