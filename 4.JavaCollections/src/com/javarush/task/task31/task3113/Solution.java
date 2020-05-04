package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* 
Что внутри папки?
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            Path directoryPath = Paths.get(reader.readLine());
            if (!Files.isDirectory(directoryPath)) {
                System.out.println(directoryPath.toAbsolutePath() + " - не папка");
                return;
            }

            MyFileVisitor myFileVisitor = new MyFileVisitor();
            Files.walkFileTree(directoryPath, myFileVisitor);

            System.out.println("Всего папок - " + myFileVisitor.directoriesCount);
            System.out.println("Всего файлов - " + myFileVisitor.filesCount);
            System.out.println("Общий размер - " + myFileVisitor.totalSize);

        }
    }

    public static class MyFileVisitor extends SimpleFileVisitor<Path>{
        private int filesCount = 0;
        private int directoriesCount = 0;
        private long totalSize = 0;

        public long getTotalSize() {
            return totalSize;
        }

        public int getFilesCount() {
            return filesCount;
        }

        public int getDirectoriesCount() {
            return directoriesCount;
        }

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            directoriesCount++;

            return super.preVisitDirectory(dir, attrs);
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            filesCount++;
            totalSize += Files.size(file);

            return super.visitFile(file, attrs);
        }
    }
}



