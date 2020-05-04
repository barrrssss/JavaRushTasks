package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.KeyPair;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new OneThread());
        threads.add(new SecondThread());
        threads.add(new ThirdThread());
        threads.add(new FourthThread());
        threads.add(new FifthThread());
    }

    public static void main(String[] args) throws InterruptedException {
//        for (Thread thread : threads){
//            thread.start();
//        }
//
//        Thread.sleep(10000);
//        threads.get(1).interrupt();
//
//        Thread.sleep(10000);
//        ((Message) threads.get(3)).showWarning();



    }

    public static class OneThread extends Thread{
        @Override
        public void run() {
            while (true){}
        }
    }

    public static class SecondThread extends Thread{
        @Override
        public void run() {
            try {
                join();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }

    public static class ThirdThread extends Thread{

        @Override
        public void run() {
            while (!isInterrupted()){
                System.out.println("Ура");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class FourthThread extends Thread implements Message{

        @Override
        public void showWarning() {
            interrupt();
        }

        @Override
        public void run() {
            while (!isInterrupted()){};
        }
    }

    public static class FifthThread extends Thread{
        private int sum;

        @Override
        public void run() {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String line;

            while (true){
                try {
                    line = reader.readLine();
                    if (line.equals("N")){
                        break;
                    }
                    sum += Integer.parseInt(line);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            System.out.println(sum);
        }
    }

}