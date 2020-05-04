package com.javarush.task.task20.task2015;

import java.io.*;

/* 
Переопределение сериализации
*/
public class Solution implements Serializable, Runnable{
    private transient Thread runner;
    private int speed;
    private int counter = 0;
    public boolean run = true;

    public Solution(int speed) {
        this.speed = speed;
        runner = new Thread(this);
        runner.start();
    }

    public void run() {
        while (run){
            System.out.println(counter);
            try {
                counter += speed;
                Thread.sleep(speed * 1000);

            } catch (InterruptedException e) {
                break;
            }

        }
    }

    /**
     Переопределяем сериализацию.
     Для этого необходимо объявить методы:
     private void writeObject(ObjectOutputStream out) throws IOException
     private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
     Теперь сериализация/десериализация пойдет по нашему сценарию :)
     */
    private void writeObject(ObjectOutputStream out) throws IOException {
        run = false;
        try {
            runner.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        runner = new Thread(this);
        run = true;
        runner.start();

    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Solution solution = new Solution(3);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(solution);
        objectOutputStream.close();
        solution = null;

        ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));

        Solution restoredSolution = (Solution) objectInputStream.readObject();


    }
}
