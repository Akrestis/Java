package com.company;

import java.util.Arrays;
import java.util.Random;

public class Main1 {

    private static final int ROW = 4;
    private static final int COLUMN = 3;

    public static void main(String[] args) {

        //1. Создать 2 мерный массив (матрица) M*N и заполнить его случайными числами.
        //Отсортировать числа по возрастанию.

        Random random = new Random();
        int[][] matrix = new int[COLUMN][ROW];
        for (int i = 0; i < COLUMN; i++) {
            for (int j = 0; j < ROW; j++) {
                matrix[i][j] = random.nextInt(100);
            }
        }

        matrixPrint(matrix);
        matrixSort(matrix);
        matrixPrint(matrix);
    }

    private static void matrixSort(int[][] matrix) {
        int[] array = new int[COLUMN * ROW];
        int num = 0;
        for (int i = 0; i < COLUMN; i++) {
            for (int j = 0; j < ROW; j++) {
                array[num] = matrix[i][j];
                num++;
            }
        }
        Arrays.sort(array);
        num = 0;
        for (int i = 0; i < COLUMN; i++) {
            for (int j = 0; j < ROW; j++) {
                matrix[i][j] = array[num];
                num++;
            }
        }
    }

    private static void matrixPrint(int[][] matrix) {
        for (int i = 0; i < COLUMN; i++) {
            System.out.print("[");
            for (int j = 0; j < ROW; j++) {
                System.out.print(matrix[i][j]);
                if (j != ROW - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    }
}

