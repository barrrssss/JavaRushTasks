package com.javarush.task.task31.task3112;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.*;

/* 
Загрузчик файлов
*/
public class Solution {

    public static void main(String[] args) throws IOException, URISyntaxException {
        Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt", Paths.get("D:/MyDownloads"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException, URISyntaxException {
        URL url = new URL(urlString);
        InputStream inputStream = url.openStream();
        Path tempFile = Files.createTempFile("temp-", ".tmp");
        Files.copy(inputStream, tempFile, StandardCopyOption.REPLACE_EXISTING);

        Path file = downloadDirectory.resolve(Paths.get(urlString.substring(urlString.lastIndexOf('/') + 1)));

        Files.move(tempFile, file, StandardCopyOption.REPLACE_EXISTING);

        return file;
    }
}
