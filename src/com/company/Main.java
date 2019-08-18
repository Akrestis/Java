package com.company;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main extends Application {

    public static void main(String[] args) {

        //Написать программу с использованием JavaFx:
        //
        //Можно добавить не менее 3 типов фигур
        //У выбранной фигуры можно менять размер и двигать ее
        //Фигуру можно удалить
        //Фигуры можно объеденять в группы (агрегация) и клонировать
        //Реализовать сохранение/загрузку состояния в файл

        launch(args);
    }


    @Override
    public void start(Stage primary) {
        primary.setTitle("Home");
        Canvas canvas = new Canvas();
        canvas.setHeight(AbstractShapes.BOARD_HEIGHT);
        canvas.setWidth(AbstractShapes.BOARD_WIDTH);
        BorderPane group = new BorderPane(canvas);
        Scene scene = new Scene(group);
        primary.setScene(scene);
        primary.show();
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Board board = new Board(gc);
        try {
            File file = new File("save.txt");
            Scanner scanner = new Scanner(file);
            String line = scanner.nextLine();
            while (scanner.hasNextLine()) {
                if (line.startsWith("Group")) {
                    Board.shapes.add(new Group());
                    Board.index++;
                    line = scanner.nextLine();
                }
                while (!line.startsWith("Group") && scanner.hasNextLine()) {
                    String[] array = line.substring(18).split(" ");
                    double x = Double.parseDouble(array[1]);
                    double y = Double.parseDouble(array[2]);
                    int size = Integer.parseInt(array[3]);
                    switch (array[0]) {
                        case "Circle":
                            Board.shapes.get(Board.index).shapesList.add(new Circle(gc, x, y, size));
                            break;
                        case "Square":
                            Board.shapes.get(Board.index).shapesList.add(new Square(gc, x, y, size));
                            break;
                        case "Triangle":
                            Board.shapes.get(Board.index).shapesList.add(new Triangle(gc, x, y, size));
                            break;
                    }
                    line = scanner.nextLine();
                }
            }
            for (int i = 0; i < Board.shapes.size(); i++) {
                if (i != Board.index) {
                    Board.shapes.get(i).draw();
                } else {
                    Board.shapes.get(i).drawFull();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("there's no save.txt");
        }

        scene.setOnKeyPressed(board::keyboard);
        scene.setOnMouseClicked(board::mouse);
    }
}