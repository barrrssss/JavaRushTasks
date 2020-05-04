package com.javarush.task.task14.task1408;

public class RussianHen extends Hen {
    @Override
    int getCountOfEggsPerMonth() {
        return 22;
    }

    @Override
    String getDescription() {
        String description = String.format(DEFAULTDESCRIPTIONTEXT, super.getDescription(), Country.RUSSIA, getCountOfEggsPerMonth());
        return description;
    }
}
