package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    public static Hippodrome game;

    private List<Horse> horses;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public void move(){
        for (Horse horse : horses){
            horse.move();
        }
    };

    public void print(){
        for (Horse horse : horses){
            horse.print();
        }

        System.out.println("\n\n\n\n\n\n\n\n\n\n");
    };

    public void run(){
        for (int i = 0; i < 100; i++){
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    public Horse getWinner () {
        Horse leader = horses.get(0);

        for (Horse horse : horses){
            if (horse.getDistance() > leader.getDistance()){
                leader = horse;
            }
        }

        return leader;
    }

    public void printWinner(){
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public static void main(String[] args) {
        Horse horse1 = new Horse("Дунай", 3, 0);
        Horse horse2 = new Horse("Пегий", 3, 0);
        Horse horse3 = new Horse("Рябоконь", 3, 0);

        List<Horse> horses = new ArrayList<>();
        horses.add(horse1);
        horses.add(horse2);
        horses.add(horse3);

        game = new Hippodrome(horses);
        game.run();
        game.printWinner();

    }
}
