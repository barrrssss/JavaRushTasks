package com.javarush.task.task14.task1408;

public abstract class Hen {
    abstract int getCountOfEggsPerMonth();

    final String DEFAULTDESCRIPTIONTEXT = "%s Моя страна - %s. Я несу %s яиц в месяц.";

    String getDescription(){
        return "Я - курица.";
    }

}
