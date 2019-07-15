package com.company;

public class Main1 {

    public static void main(String[] args) {

        //1. Есть поле из клеток по средине которого находится робот.
        //Робот умеет выполнять 4 команды: двигаться на 1 клетку в сторону: R (right), L (left), U (up), and D (down).
        //Задана строка из движений робота например "UUDLDR".
        //Написать метод который вернет true если робот вернется в ту же клетку с которой начал.

        System.out.println(move("UUDLDR"));
    }

    private static boolean move(String move) {
        if (move.matches("[UDRL]+")) {
            int horizontal = 0;
            int vertical = 0;
            for (int i = 0; i < move.length(); i++) {
                if (move.charAt(i) == 'U') {
                    vertical++;
                } else if (move.charAt(i) == 'D') {
                    vertical--;
                } else if (move.charAt(i) == 'R') {
                    horizontal++;
                } else if (move.charAt(i) == 'L') {
                    horizontal--;
                }
            }
            return horizontal == 0 && vertical == 0;
        } else {
            throw new IllegalArgumentException("Wrong symbols");
        }
    }
}

