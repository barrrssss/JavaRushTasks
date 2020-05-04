package com.javarush.task.task19.task1916;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        File file1 = new File(reader.readLine());
        File file2 = new File(reader.readLine());
        reader.close();

        ArrayList<String> words1 = new ArrayList<>();
        ArrayList<String> words2 = new ArrayList<>();
        BufferedReader bufferedReader1 = new BufferedReader(new FileReader(file1));
        while (bufferedReader1.ready()){
            String line = bufferedReader1.readLine();
            words1.add(line);
        }
        bufferedReader1.close();
        BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file2));
        while (bufferedReader2.ready()){
            String line = bufferedReader2.readLine();
            words2.add(line);
        }
        bufferedReader2.close();

        while (!words1.isEmpty()){
            String s1 = words1.get(0);
            boolean isEquals = false;

            for (String s2 : words2){
                if (s1.equals(s2)){
                    lines.add(new LineItem(Type.SAME, s1));
                    words2.remove(s2);
                    words1.remove(s1);
                    isEquals = true;
                    break;
                }
            }

            if (!isEquals) {
                lines.add(new LineItem(Type.REMOVED, s1));
                words1.remove(s1);
            }
        }

        for (String s : words2){
            lines.add(new LineItem(Type.ADDED, s));
        }

        for (LineItem lineItem : lines){
            System.out.println(lineItem.type + " " + lineItem.line);
        }

    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
