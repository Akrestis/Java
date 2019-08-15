package com.company;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

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
        scene.setOnKeyPressed(board::keyboard);
        scene.setOnMouseClicked(board::mouse);
    }
}