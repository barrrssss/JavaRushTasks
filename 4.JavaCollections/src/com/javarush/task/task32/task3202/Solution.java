package com.javarush.task.task32.task3202;

import java.io.*;

/* 
Читаем из потока
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("testFile.log"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        try (StringWriter stringWriter = new StringWriter();
             InputStreamReader inputStreamReader = new InputStreamReader(is);
        ){
            char[] data = new char[1024];
            int length;
            while ((length = inputStreamReader.read(data)) > 0){
                stringWriter.write(data, 0, length);
            }
            return stringWriter;
        }
        catch (Exception e){
            return new StringWriter();
        }
    }
}