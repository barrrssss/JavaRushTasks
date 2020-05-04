package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
public class Solution {


    public static void main(String[] args) {
        Path fileToZip = Paths.get(args[0]);
        Path zipFile = Paths.get(args[1]);


        Map<String, byte[]> map = new HashMap<>();

        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(args[1]))){
            ZipEntry zipEntry;
            while ((zipEntry = zipInputStream.getNextEntry()) != null){
                String fileName = zipEntry.getName();
                if (fileName == fileToZip.getFileName().toString()) continue;

                try(ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
//                    zipInputStream.transferTo(byteArrayOutputStream);

                    byte[] buffer = new byte[2048];
                    int length;
                    while ((length = zipInputStream.read(buffer)) > 0){
                        byteArrayOutputStream.write(buffer, 0, length);
                    }

                    byte[] bytes = byteArrayOutputStream.toByteArray();
                    map.put(zipEntry.getName(), bytes);
                }
            }
        }
        catch (IOException e){

        }

        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(args[1]))) {
            zipOutputStream.putNextEntry(new ZipEntry("new/" + fileToZip.getFileName().toString()));
            Files.copy(Paths.get(args[0]), zipOutputStream);
            zipOutputStream.closeEntry();

            for (Map.Entry<String, byte[]> entry : map.entrySet()){
                zipOutputStream.putNextEntry(new ZipEntry(entry.getKey()));

//                zipOutputStream.write(entry.getValue());

                try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(entry.getValue())) {
                    byte[] buffer = new byte[2048];
                    int length;
                    while ((length = byteArrayInputStream.read(buffer)) > 0){
                        zipOutputStream.write(buffer, 0, length);
                    }
                }

                zipOutputStream.closeEntry();
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
