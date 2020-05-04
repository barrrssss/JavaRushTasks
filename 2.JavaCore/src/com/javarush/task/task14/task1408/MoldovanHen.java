package com.javarush.task.task14.task1408;

public class MoldovanHen extends Hen {
    @Override
    int getCountOfEggsPerMonth() {
        return 18;
    }

    @Override
    String getDescription() {
        String description = String.format(DEFAULTDESCRIPTIONTEXT, super.getDescription(), Country.MOLDOVA, getCountOfEggsPerMonth());
        return description;
    }
}
