package com.company;

import javafx.scene.canvas.GraphicsContext;

abstract class AbstractShapes implements Shapes {

    static final int BOARD_HEIGHT = 500;
    static final int BOARD_WIDTH = 500;
    private static final int SPEED = 8;
    double x = Board.x;
    double y = Board.y;
    int size = Board.size;
    final GraphicsContext gc;

    AbstractShapes(GraphicsContext gc) {
        this.gc = gc;
    }

    @Override
    public void moveLeft() {
        if (x > 0) {
            x -= SPEED;
        }
    }

    @Override
    public void moveRight() {
        if (x + size < BOARD_WIDTH) {
            x += SPEED;
        }
    }

    @Override
    public void moveUp() {
        if (y > 0) {
            y -= SPEED;
        }
    }

    @Override
    public void moveDown() {
        if (y + size < BOARD_HEIGHT) {
            y += SPEED;
        }
    }

    @Override
    public void decrease() {
        size--;
    }

    @Override
    public void increase() {
        size++;
    }
}
