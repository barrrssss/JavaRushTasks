package com.javarush.task.task19.task1917;

/* 
Свой FileWriter
*/

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileConsoleWriter extends FileWriter {
    private FileWriter fileWriter;

    public FileConsoleWriter(File file) throws IOException {
        super(file);
    }

    @Override
    public void write(int c) throws IOException {
        fileWriter.write(c);
        System.out.println(c);
    }

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {
        fileWriter.write(cbuf, off, len);
        System.out.println(String.valueOf(cbuf).substring(off, off + len));
    }

    @Override
    public void write(String str, int off, int len) throws IOException {
        fileWriter.write(str, off, len);
        System.out.println(str.substring(off, off + len));
    }

    @Override
    public void close() throws IOException {
        fileWriter.close();
    }

    @Override
    public void write(char[] cbuf) throws IOException {
        fileWriter.write(cbuf);
        System.out.println(String.valueOf(cbuf));
    }

    @Override
    public void write(String str) throws IOException {
        fileWriter.write(str);
        System.out.println(str);
    }

    public static void main(String[] args) {

    }

}
