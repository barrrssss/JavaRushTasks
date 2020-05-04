package com.javarush.task.task31.task3106;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/*
Разархивируем файл
*/
public class Solution {

    public static class EntrySetToValueEnumerationAdapter<K, V> implements Enumeration<V>{
        private Iterator<Map.Entry<K,V>> iterator;

        public EntrySetToValueEnumerationAdapter(Set<Map.Entry<K, V>> set) {
            this.iterator = set.iterator();
        }

        @Override
        public boolean hasMoreElements() {
            return iterator.hasNext();
        }

        @Override
        public V nextElement() {
            Map.Entry<K, V> map = iterator.next();

            return map.getValue();
        }
    }

    public static void main(String[] args) {
        Comparator<Path> comparator = new Comparator<Path>() {
            @Override
            public int compare(Path o1, Path o2) {
                return Integer.compare(getNumberOfArchive(o1), getNumberOfArchive(o2));
            }

            private int getNumberOfArchive(Path path){
                String name = path.toString();
                return Integer.parseInt(name.substring(name.lastIndexOf('.') + 1));
            }
        };

        Map<Path, FileInputStream> archive = new TreeMap<>(comparator);

        try {
            for (int i = 1; i < args.length; i++){
                Path path = Paths.get(args[i]);
                archive.put(path, new FileInputStream(path.toFile()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try (ZipInputStream zipInputStream = new ZipInputStream(new SequenceInputStream(
                new EntrySetToValueEnumerationAdapter<>(archive.entrySet())));
             FileOutputStream fileOutputStream = new FileOutputStream(args[0]);
        ) {
//            zipInputStream.transferTo(fileOutputStream);
            zipInputStream.getNextEntry();
            byte[] buffer = new byte[1024];
            int length;
            while ((length = zipInputStream.read(buffer)) > 0){
                fileOutputStream.write(buffer,0,length);
            }
            zipInputStream.closeEntry();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
