package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> fileList = new ArrayList<>();

        String line;
        while (!(line = reader.readLine()).equals("end")){
            fileList.add(line);
        }
        reader.close();

        String[] sortedFileArray = sortFileParts(fileList);
        String mainFileName = getMainFileName(sortedFileArray[0]);

        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(mainFileName));
        for (String fileName: sortedFileArray){
            BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(fileName));

            while (inputStream.available() > 0){
                int data = inputStream.read();
                outputStream.write(data);
            }
            inputStream.close();
        }
        outputStream.close();


    }

    private static String[] sortFileParts(List<String> fileList){
        String[] result = new String[fileList.size()];

        for (String fileName: fileList){
            int filePartIngex = getFilePartIndex(fileName);
            result[filePartIngex - 1] = fileName;
        }

        return result;
    }

    private static int getFilePartIndex(String fileName){
        int indexOfPart = fileName.lastIndexOf(".part");
        String substring = fileName.substring(indexOfPart + 5);
        int result = Integer.parseInt(substring);

        return result;
    }

    private static String getMainFileName(String fileName){
        int prefixIndex = fileName.lastIndexOf(".part");
        String mainFileName = fileName.substring(0, prefixIndex);

        return mainFileName;
    }
}
