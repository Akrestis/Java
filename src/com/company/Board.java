package com.company;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Board {

    private static GraphicsContext gc;
    private static int index = -1;
    private static List<Group> shapes = new ArrayList<>();

    Board(GraphicsContext gc) {
        Board.gc = gc;
    }

    void mouse(MouseEvent mouseEvent) {
        double mouseX = mouseEvent.getX();
        double mouseY = mouseEvent.getY();
        for (int i = 0; i < shapes.size(); i++) {
            for (int j = 0; j < shapes.get(i).shapesList.size(); j++) {
                if (i != index && mouseX >= shapes.get(i).shapesList.get(j).getX() &&
                        mouseX <= shapes.get(i).shapesList.get(j).getX() + shapes.get(i).shapesList.get(j).getSize() &&
                        mouseY >= shapes.get(i).shapesList.get(j).getY() &&
                        mouseY <= shapes.get(i).shapesList.get(j).getY() + shapes.get(i).shapesList.get(j).getSize()) {
                    Group.combination(shapes.get(index), shapes.get(i));
                    shapes.remove(shapes.get(i));
                    index--;
                    gc.clearRect(0, 0, Main.BOARD_HEIGHT, Main.BOARD_WIDTH);
                    draw();
                }
            }
        }
    }

    void keyboard(KeyEvent keyEvent) {

        gc.clearRect(0, 0, Main.BOARD_HEIGHT, Main.BOARD_WIDTH);

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
                    previous();
                    break;
                case SPACE:
                    shapes.add(Group.copy(shapes.get(index)));
                    index++;
                    break;
            }
        }
        double x = 0;
        double y = 0;
        int size = 50;
        switch (keyEvent.getCode()) {
            case DIGIT1:
                shapes.add(new Group(new Circle(gc, x, y, size)));
                index = shapes.size() - 1;
                break;
            case DIGIT2:
                shapes.add(new Group(new Square(gc, x, y, size)));
                index = shapes.size() - 1;
                break;
            case DIGIT3:
                shapes.add(new Group(new Triangle(gc, x, y, size)));
                index = shapes.size() - 1;
                break;
            case F5:
                save();
        }
        draw();
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

    private static void draw() {
        for (int i = 0; i < shapes.size(); i++) {
            if (i != index) {
                shapes.get(i).draw();
            } else {
                shapes.get(i).drawFull();
            }
        }
    }

    private void save() {
        StringBuilder sb = new StringBuilder();
        for (Group shape : shapes) {
            sb.append("Group").append('\n');
            for (int j = 0; j < shape.shapesList.size(); j++) {
                sb.append(shape.shapesList.get(j).getClass()).append(" ").
                        append(shape.shapesList.get(j).getX()).append(" ").
                        append(shape.shapesList.get(j).getY()).append(" ").
                        append(shape.shapesList.get(j).getSize()).append(" ").append('\n');
            }
        }
        sb.append(" ");
        try {
            FileWriter writer = new FileWriter("save.txt");
            writer.write(sb.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void load() {
        try {
            File file = new File("save.txt");
            Scanner scanner = new Scanner(file);
            String line = scanner.nextLine();
            while (scanner.hasNextLine()) {
                if (line.startsWith("Group")) {
                    shapes.add(new Group());
                    index++;
                    line = scanner.nextLine();
                }
                while (!line.startsWith("Group") && scanner.hasNextLine()) {
                    String[] array = line.substring(18).split(" ");
                    double x = Double.parseDouble(array[1]);
                    double y = Double.parseDouble(array[2]);
                    int size = Integer.parseInt(array[3]);
                    switch (array[0]) {
                        case "Circle":
                            shapes.get(index).shapesList.add(new Circle(gc, x, y, size));
                            break;
                        case "Square":
                            shapes.get(index).shapesList.add(new Square(gc, x, y, size));
                            break;
                        case "Triangle":
                            shapes.get(index).shapesList.add(new Triangle(gc, x, y, size));
                            break;
                    }
                    line = scanner.nextLine();
                }
            }
            draw();
        } catch (
                FileNotFoundException e) {
            System.out.println("there's no save.txt");
        }
    }
}
