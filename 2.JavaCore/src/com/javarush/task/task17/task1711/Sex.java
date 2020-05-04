package com.javarush.task.task17.task1711;

public enum Sex {
    MALE("м"),
    FEMALE("ж");

    String title;

    Sex(String title){
        this.title = title;
    }

}