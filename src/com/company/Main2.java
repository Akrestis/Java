package com.company;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Random;

public class Main2 extends Application {

    private static final int BOARD_WIDTH = 500;
    private static final int BOARD_HEIGHT = 500;
    private boolean closed = false;

    public static void main(String[] args) {

        //2*) нарисовть шар который сам двигается и отбивается от краев экрана

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
        ball(gc);
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        closed = true;
    }

    private void ball(GraphicsContext gc) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Random random = new Random();
                int speedX = random.nextInt(5) + 1;
                int speedY = random.nextInt(5) + 1;
                double x = 1;
                double y = 1;
                double diameter = 50;
                while (!closed) {
                    gc.clearRect(0, 0, BOARD_WIDTH, BOARD_HEIGHT);
                    gc.setFill(Color.FORESTGREEN);
                    gc.fillOval(x, y, diameter, diameter);
                    try {
                        Thread.sleep(16);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (x + diameter >= BOARD_WIDTH || x <= 0) {
                        speedX = -speedX;
                    }

                    if (y + diameter >= BOARD_HEIGHT || y <= 0) {
                        speedY = 0 - speedY;
                    }
                    x += speedX;
                    y += speedY;
                }
            }
        }).start();
    }
}
