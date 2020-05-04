package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
Проход по дереву файлов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        File resultFileAbsolutePath = new File(args[1]);
        System.out.println(resultFileAbsolutePath.exists());
        File allFilesContent = new File(resultFileAbsolutePath.getParent() + "/allFilesContent.txt");


        FileUtils.renameFile(resultFileAbsolutePath, allFilesContent);
        FileWriter fileWriter = new FileWriter(allFilesContent);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        File path = new File(args[0]);

        File[] someFiles = path.listFiles(pathname -> pathname.length() > 50);

        List<File> fileList = new ArrayList<>();

        processFilesFromFolder(path, fileList);
        File[] files = fileList.toArray(new File[0]);

        Arrays.sort(files, Comparator.comparing(File::getName));

        for (File file : files){
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
                while (bufferedReader.ready()){
                    String s = bufferedReader.readLine();
                    bufferedWriter.write(s);
                }
                bufferedWriter.write("\n");

            } catch (IOException e){
                e.printStackTrace();
            }
        }

        bufferedWriter.close();
        fileWriter.close();
    }

    public static void processFilesFromFolder(File folder, List<File> fileList)
    {
        File[] folderEntries = folder.listFiles();
        for (File entry : folderEntries)
        {
            if (entry.isDirectory())
            {
                processFilesFromFolder(entry, fileList);
                continue;
            }
            if (entry.length() <= 50){
                fileList.add(entry);
            }
        }

    }
}
