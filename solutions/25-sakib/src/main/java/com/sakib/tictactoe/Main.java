package com.sakib.tictactoe;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
//        this.();
//        Scene scene=new Scene(borderPane,550,550);
//        stage.setScene(scene);
//        stage.show();
//        VBox aiButton = new VBox();
//        aiButton.setPrefWidth(250);
//        aiButton.setPrefHeight(35);
//        aiButton.setPadding(new Insets(10, 50, 50, 50));
//        aiButton.setSpacing(10);
//        Button randomAIButton = new Button("Start With Random AI");
//        Button defensiveAIButton = new Button("Start With Defensive AI");
//        randomAIButton.setMinWidth(aiButton.getPrefWidth());
//        randomAIButton.setMinHeight(aiButton.getPrefHeight());
//        defensiveAIButton.setMinWidth(aiButton.getPrefWidth());
//        defensiveAIButton.setMinHeight(aiButton.getPrefHeight());
//        aiButton.getChildren().addAll(randomAIButton, defensiveAIButton);
//
//        VBox themeVbox = new VBox();
//        Label title = new Label("Theme");
//        themeVbox.setPrefWidth(200);
//        themeVbox.setPrefHeight(30);
//        themeVbox.setPadding(new Insets(20, 0, 50, 370));
//        title.setMinWidth(themeVbox.getPrefWidth());
//        title.setMinHeight(themeVbox.getPrefHeight());
//        ToggleGroup group = new ToggleGroup();
//        RadioButton classic = new RadioButton("Classic");
//        classic.setToggleGroup(group);
//        RadioButton forrest = new RadioButton("Forrest");
//        forrest.setToggleGroup(group);
//        RadioButton high_contrast = new RadioButton("High Contrast");
//        high_contrast.setToggleGroup(group);
//        classic.setMinWidth(themeVbox.getPrefWidth());
//        classic.setMinHeight(themeVbox.getPrefHeight());
//        forrest.setMinWidth(themeVbox.getPrefWidth());
//        forrest.setMinHeight(themeVbox.getPrefHeight());
//        high_contrast.setMinWidth(themeVbox.getPrefWidth());
//        high_contrast.setMinHeight(themeVbox.getPrefHeight());
//
//        themeVbox.getChildren().addAll(title, classic, forrest, high_contrast);


        Group root = new Group();
        new GameManager();
        primaryStage.setTitle("Tic Tac Toe Game -- Play With Sakib");
//        Image icon = new Image("avator.png");
//        primaryStage.getIcons().add(icon);
        primaryStage.setResizable(false);

        primaryStage.setScene(new Scene(GameManager.gameBoard));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
