package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.CharArrayReader;
import java.io.IOException;
import java.util.regex.Pattern;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream result = null;
        String pass = "";
        char[] password = new char[8];
        password[0] = getRandomChar(48, 57);
        password[1] = getRandomChar(48, 57);
        password[2] = getRandomChar(65, 90);
        password[3] = getRandomChar(65, 90);
        password[4] = getRandomChar(97, 122);
        password[5] = getRandomChar(97, 122);
        password[6] = getRandomChar(97, 122);
        password[7] = getRandomChar(48, 57);

        pass = String.valueOf(password);

        try(ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
            byteArrayOutputStream.write(pass.getBytes());
            result = byteArrayOutputStream;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    private static char getRandomChar(int from, int to){
        char ch = (char) ((int)(Math.random() * ((to - from) + 1)) + from);
        return ch;
    }
}