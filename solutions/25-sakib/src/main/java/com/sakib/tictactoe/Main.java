package com.sakib.tictactoe;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        StartApplication(primaryStage);
    }

    public static void StartApplication(Stage primaryStage) {
        primaryStage.setTitle("Tic Tac Toe Game -- Play With Sakib");
        primaryStage.setResizable(false);

        GameManager.gameBoard = new GameBoard();
        primaryStage.setScene(new Scene(GameManager.gameBoard));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
