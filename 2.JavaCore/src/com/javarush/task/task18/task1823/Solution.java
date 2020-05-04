package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static volatile Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        List<String> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s;
        while (!(s = reader.readLine()).equals("exit")){
            list.add(s);
        }
        reader.close();

        for (String str: list){
            new ReadThread(str).start();
        }
    }

    public static class ReadThread extends Thread {
        private String fileName;
        private int[] bytes = new int[256];


        public ReadThread(String fileName) {
            this.fileName = fileName;
            //implement constructor body
        }
        // implement file reading here - реализуйте чтение из файла тут


        @Override
        public void run() {
            try{
                FileInputStream inputStream = new FileInputStream(fileName);

                while (inputStream.available() > 0){
                    int data = inputStream.read();
                    bytes[data]++;
                }
                inputStream.close();
            }
            catch (IOException e){}

            resultMap.put(fileName, findMaxByte());
        }

        private int findMaxByte(){
            int max_id = 0;
            for (int i = 0; i < bytes.length; i++){
                if (bytes[i] > bytes[max_id]){
                    max_id = i;
                }
            }
            return max_id;
        }
    }
}
