package com.company;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Triangle extends AbstractShapes {

    Triangle(GraphicsContext gc) {
        super(gc);
    }

    @Override
    public void draw() {
        gc.setStroke(Color.BLUE);
        gc.strokePolygon(new double[]{x, x + (double) size / 2, x + size}, new double[]{y + size, y, y + size}, 3);
    }

    @Override
    public void drawFull() {
        gc.setFill(Color.BLUE);
        gc.fillPolygon(new double[]{x, x + (double) size / 2, x + size}, new double[]{y + size, y, y + size}, 3);
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
