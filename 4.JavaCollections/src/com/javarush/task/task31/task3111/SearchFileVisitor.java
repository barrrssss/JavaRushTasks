package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {

    private String partOfName;
    private String partOfContent;
    private int maxSize;
    private int minSize;
    private boolean isMaxSizeSet = false;
    private boolean isMinSizeSet = false;

    private List<Path> foundFiles = new ArrayList<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        byte[] content = Files.readAllBytes(file); // размер файла: content.length


        boolean containsName = true;
        if(partOfName != null && !file.getFileName().toString().contains(partOfName))
            containsName = false;

        String stringContent = new String(Files.readAllBytes(file));

        boolean containsContent = true;
        if(partOfContent != null && !stringContent.contains(partOfContent))
            containsContent = false;

        boolean matchMaxSize = true;
        if (isMaxSizeSet == true && content.length > maxSize) {
            matchMaxSize = false;
        }

        boolean matchMinSize = true;
        if (isMinSizeSet == true && content.length < minSize) {
            matchMinSize = false;
        }

        if (containsName && containsContent && matchMaxSize && matchMinSize){
            foundFiles.add(file);
        }


        return super.visitFile(file, attrs);
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
        this.isMinSizeSet = true;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
        this.isMaxSizeSet = true;
    }

    public List<Path> getFoundFiles() {
        return foundFiles;
    }
}
