package com.javarush.task.task16.task1630;

import java.io.*;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static{
        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        //add your code here - добавьте код тут
        f.join();

        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    public static class ReadFileThread extends Thread implements ReadFileInterface {
        private FileReader fileReader;
        private String fileContent = "";

        @Override
        public void setFileName(String fullFileName) {
            try {
                fileReader = new FileReader(fullFileName);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        @Override
        public String getFileContent() {
            return fileContent;
        }

        @Override
        public void run() {
            BufferedReader reader = new BufferedReader(fileReader);
            String line;

            try {
                while ((line = reader.readLine()) != null){
                    fileContent += line + " ";
                }
                reader.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //add your code here - добавьте код тут
}
