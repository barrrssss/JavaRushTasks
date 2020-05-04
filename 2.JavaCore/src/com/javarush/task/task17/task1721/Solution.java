package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String firstFileName = reader.readLine();
            String secondFileName = reader.readLine();

            BufferedReader bufferedFileReader = new BufferedReader(new FileReader(firstFileName));
            String line;
            while ((line = bufferedFileReader.readLine()) != null){
                allLines.add(line);
            }

            bufferedFileReader.close();

            BufferedReader bufferedFileReader2 = new BufferedReader(new FileReader(secondFileName));
            while ((line = bufferedFileReader2.readLine()) != null){
                forRemoveLines.add(line);
            }
            bufferedFileReader2.close();

            new Solution().joinData();
        }
        catch (IOException e){
            System.out.println("Упс");
        }


    }

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)){
            allLines.removeAll(forRemoveLines);
        }
        else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
