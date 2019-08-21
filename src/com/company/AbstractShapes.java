package com.company;

import javafx.scene.canvas.GraphicsContext;

abstract class AbstractShapes implements Shapes {

    private static final int SPEED = 8;
    double x = 0;
    double y = 0;
    int size = 50;
    static GraphicsContext gc;

    AbstractShapes(GraphicsContext gc) {
        AbstractShapes.gc = gc;
    }

    @Override
    public void moveLeft() {
        if (x > 0) {
            x -= SPEED;
        }
    }

    @Override
    public void moveRight() {
        if (x + size < Main.BOARD_WIDTH) {
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
        if (y + size < Main.BOARD_HEIGHT) {
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
