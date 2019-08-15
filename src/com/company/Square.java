package com.company;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Square extends AbstractShapes {

    Square(GraphicsContext gc) {
        super(gc);
    }

    @Override
    public void draw() {
        gc.setStroke(Color.FORESTGREEN);
        gc.strokeRect(x, y, size, size);
    }

    @Override
    public void drawFull() {
        gc.setFill(Color.FORESTGREEN);
        gc.fillRect(x, y, size, size);
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public int getSize() {
        return size;
    }
}
