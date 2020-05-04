package com.javarush.task.task22.task2213;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test {
    public static int[][] matrix;

    public static void main(String[] args) {
        matrix = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 0, 1, 1, 1, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        };

        removeFullLines();
        print(matrix);
    }

    public static void removeFullLines() {
        //Например так:
        //Создаем список для хранения линий
        //Копируем все непустые линии в список.
        //Добавляем недостающие строки в начало списка.
        //Преобразуем список обратно в матрицу

//      cleaning full strigs.

        List<int[]> list = new ArrayList<>(Arrays.asList(matrix));
        Collections.reverse(list);

        for (int y = 0; y < list.size(); y++){
            boolean hasEmpty = false;

            int[] string = list.get(y);
            for (int i : string){
                if (i == 0){
                    hasEmpty = true;
                    break;
                }
            }

            if (!hasEmpty){
                list.remove(y);
                y--;
            }
        }

        Collections.reverse(list);

        while (list.size() < matrix.length){
            int[] string = new int[matrix[0].length];

            for (int i = 0; i < string.length; i++){
                string[i] = 0;
            }

            list.add(0, string);
        }

        matrix = list.toArray(matrix);
    }

    public static void print(int[][] matrix){
        for (int y = 0; y < matrix.length; y++){
            for (int x = 0; x < matrix[y].length; x++){
                System.out.print(matrix[y][x]);
            }
            System.out.println();
        }
    }
}
