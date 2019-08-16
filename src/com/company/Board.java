package com.company;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.List;

class Board {

    static GraphicsContext gc;
    private int index = -1;
    private static List<Group> shapes = new ArrayList<>();
    static double x = 0;
    static double y = 0;
    static int size = 50;

    Board(GraphicsContext gc) {
        Board.gc = gc;
    }

    void mouse(MouseEvent mouseEvent) {
        double mouseX = mouseEvent.getX();
        double mouseY = mouseEvent.getY();
        for (int i = 0; i < shapes.size(); i++) {
            if (i != index && mouseX >= shapes.get(i).getX() &&
                    mouseX <= shapes.get(i).getX() + shapes.get(i).getSize() &&
                    mouseY >= shapes.get(i).getY() &&
                    mouseY <= shapes.get(i).getY() + shapes.get(i).getSize()) {
                Group.combination(shapes.get(index), shapes.get(i));
                shapes.remove(shapes.get(i));
                index--;
                gc.clearRect(0, 0, AbstractShapes.BOARD_HEIGHT, AbstractShapes.BOARD_WIDTH);
                for (int j = 0; j < shapes.size(); j++) {
                    if (j != index) {
                        shapes.get(j).draw();
                    } else {
                        shapes.get(j).drawFull();
                    }
                }
            }
        }
    }

    void keyboard(KeyEvent keyEvent) {

        gc.clearRect(0, 0, AbstractShapes.BOARD_HEIGHT, AbstractShapes.BOARD_WIDTH);

        if (index > -1) {
            Group shape = shapes.get(index);

            switch (keyEvent.getCode()) {
                case LEFT:
                    shape.moveLeft();
                    break;
                case RIGHT:
                    shape.moveRight();
                    break;
                case UP:
                    shape.moveUp();
                    break;
                case DOWN:
                    shape.moveDown();
                    break;
                case SHIFT:
                    next();
                    break;
                case CONTROL:
                    previous();
                    break;
                case PAGE_DOWN:
                    shape.decrease();
                    break;
                case PAGE_UP:
                    shape.increase();
                    break;
                case DELETE:
                    shapes.remove(index);
                    index--;
                    break;
                case SPACE:
                    shapes.add(Group.copy(shapes.get(index)));
                    index++;
                    break;
            }
        }
        switch (keyEvent.getCode()) {
            case DIGIT1:
                Group circle = new Group(new Circle(gc, x, y, size));
                shapes.add(circle);
                index = shapes.size() - 1;
                break;
            case DIGIT2:
                Group square = new Group(new Square(gc, x, y, size));
                shapes.add(square);
                index = shapes.size() - 1;
                break;
            case DIGIT3:
                Group triangle = new Group(new Triangle(gc, x, y, size));
                shapes.add(triangle);
                index = shapes.size() - 1;
                break;
        }
        for (int i = 0; i < shapes.size(); i++) {
            if (i != index) {
                shapes.get(i).draw();
            } else {
                shapes.get(i).drawFull();
            }
        }
    }

    private void previous() {
        index--;
        if (index < 0) {
            index = shapes.size() - 1;
        }
    }

    private void next() {
        index++;
        if (index == shapes.size()) {
            index = 0;
        }
    }
}
