package com.company;

import java.util.ArrayList;
import java.util.List;

public class Group implements Shapes {

    private List<Shapes> shapesList = new ArrayList<>();

    Group(Shapes shape) {
        shapesList.add(shape);
    }

    static void combination(Group one, Group two) {
        one.shapesList.addAll(two.shapesList);
    }

    @Override
    public void draw() {
        for (Shapes shape : shapesList) {
            shape.draw();
        }
    }

    @Override
    public void drawFull() {
        for (Shapes shape : shapesList) {
            shape.drawFull();
        }
    }

    @Override
    public void moveLeft() {
        for (Shapes shape : shapesList) {
            shape.moveLeft();
        }
    }

    @Override
    public void moveRight() {
        for (Shapes shape : shapesList) {
            shape.moveRight();
        }
    }

    @Override
    public void moveUp() {
        for (Shapes shape : shapesList) {
            shape.moveUp();
        }
    }

    @Override
    public void moveDown() {
        for (Shapes shape : shapesList) {
            shape.moveDown();
        }
    }

    @Override
    public void decrease() {
        for (Shapes shape : shapesList) {
            shape.decrease();
        }
    }

    @Override
    public void increase() {
        for (Shapes shape : shapesList) {
            shape.increase();
        }
    }

    @Override
    public double getX() {
        for (Shapes shape : shapesList) {
            return shape.getX();
        }
        return 0;
    }

    @Override
    public double getY() {
        for (Shapes shape : shapesList) {
            return shape.getY();
        }
        return 0;
    }

    @Override
    public int getSize() {
        for (Shapes shape : shapesList) {
            return shape.getSize();
        }
        return 0;
    }
}
