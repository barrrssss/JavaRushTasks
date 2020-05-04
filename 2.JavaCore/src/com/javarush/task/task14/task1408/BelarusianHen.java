package com.javarush.task.task14.task1408;

public class BelarusianHen extends Hen {
    @Override
    int getCountOfEggsPerMonth() {
        return 25;
    }

    @Override
    String getDescription() {
        String description = String.format(DEFAULTDESCRIPTIONTEXT, super.getDescription(), Country.BELARUS, getCountOfEggsPerMonth());
        return description;
    }
}
