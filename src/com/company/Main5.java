package com.company;

//5. Есть фрагмент кода, который при запуске выдает ошибку NullPointerException. Найдите и исправьте ошибку:

import java.util.ArrayList;
import java.util.List;

public class Main5 {

    private static class Ball {
    }

    private static class Board {
        private List balls = new ArrayList<>();

        public Board() {
            balls.add(new Ball());
            balls.add(new Ball());
            balls.add(new Ball());
        }

        public int count() {
            return balls.size();
        }
    }

    public static void main(String[] args) {
        Board board = new Board();
        System.out.println(board.count());
    }
}

