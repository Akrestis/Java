package com.company;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Circle extends AbstractShapes {

    Circle(GraphicsContext gc) {
        super(gc);
    }

    @Override
    public void draw() {
        gc.setStroke(Color.RED);
        gc.strokeOval(x, y, size, size);
    }

    @Override
    public void drawFull() {
        gc.setFill(Color.RED);
        gc.fillOval(x, y, size, size);
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
