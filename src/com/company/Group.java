package com.company;

import java.util.ArrayList;
import java.util.List;

public class Group implements Shapes {

    private List<Shapes> shapesList = new ArrayList<>();

    Group() {
    }

    Group(Shapes shape) {
        shapesList.add(shape);
    }

    static void combination(Group one, Group two) {
        one.shapesList.addAll(two.shapesList);
    }

    static Group copy(Group group) {
        Group newGroup = new Group();
        for (int i = 0; i < group.shapesList.size(); i++) {
            if (group.shapesList.get(i) instanceof Circle) {
                newGroup.shapesList.add(new Circle(Board.gc, group.shapesList.get(i).getX(),
                        group.shapesList.get(i).getY(), group.shapesList.get(i).getSize()));
            } else if (group.shapesList.get(i) instanceof Square) {
                newGroup.shapesList.add(new Square(Board.gc, group.shapesList.get(i).getX(),
                        group.shapesList.get(i).getY(), group.shapesList.get(i).getSize()));
            } else if (group.shapesList.get(i) instanceof Triangle) {
                newGroup.shapesList.add(new Triangle(Board.gc, group.shapesList.get(i).getX(),
                        group.shapesList.get(i).getY(), group.shapesList.get(i).getSize()));
            }
        }
        return newGroup;
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
