package com.company;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main1 extends Application {

    private static final int BOARD_WIDTH = 500;
    private static final int BOARD_HEIGHT = 500;

    public static void main(String[] args) {

        //1) Нарисовать простую сцену - домик, солнце

        launch(args);
    }


    @Override

    public void start(Stage primary) {
        primary.setTitle("Home");
        Canvas canvas = new Canvas();
        canvas.setHeight(BOARD_HEIGHT);
        canvas.setWidth(BOARD_WIDTH);
        BorderPane group = new BorderPane(canvas);
        Scene scene = new Scene(group);
        primary.setScene(scene);
        primary.show();
        GraphicsContext gc = canvas.getGraphicsContext2D();
        home(gc);
    }

    private void home(GraphicsContext gc) {

        gc.setFill(Color.DEEPSKYBLUE);
        gc.fillRect(0,0,BOARD_HEIGHT,BOARD_WIDTH);

        gc.setFill(Color.GREEN);
        gc.fillRect(0, 450, BOARD_HEIGHT, BOARD_WIDTH);

        gc.setFill(Color.BROWN);
        gc.fillRect(50, 350, 150, 100);

        gc.setFill(Color.RED);
        gc.fillPolygon(new double[]{35, 125, 215}, new double[]{350, 300, 350}, 3);

        gc.setFill(Color.YELLOW);
        gc.fillOval(400, -100, 200, 200);

        gc.setFill(Color.WHITE);
        gc.fillRect(65,365,40,40);

        gc.setFill(Color.BURLYWOOD);
        gc.fillRect(145,390,40,60);
    }
}