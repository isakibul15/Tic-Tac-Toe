//package com.sakib.tictactoe;
//
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.geometry.Insets;
//import javafx.geometry.Pos;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.RadioButton;
//import javafx.scene.layout.Pane;
//import javafx.scene.layout.VBox;
//import javafx.scene.paint.Color;
//import javafx.scene.shape.Line;
//import javafx.scene.text.Font;
//import javafx.scene.text.FontPosture;
//import javafx.scene.text.FontWeight;
//
//public class GameBoard extends Pane {
//
//    public GameBoard() {
//        board_setup();
//    }
//
//    private void board_setup() {
//        this.getChildren().clear();
//        var board = GameManager.board;
//        var combos = GameManager.combos;
//
//        //Identified the Whole box
//        this.setPrefSize(900, 600);
//        //Sepertating the boxes #9
//        for (int i = 0 ; i < 3 ; i++) {
//            for (int j = 0; j < 3; j++) {
//                Tile tile = new Tile();
//                tile.setTranslateX(j * 200);
//                tile.setTranslateY(i * 200);
//                this.getChildren().add(tile);
//                board[j][i] = tile;
//            }
//        }
//
//        this.getChildren().add(getLine(200, 15, 200, 600-15,
//                GameManager.theme == GameManager.Themes.CLASSIC ? Color.BLACK :
//                        GameManager.theme == GameManager.Themes.FORREST ? Color.DARKGREEN :
//                                Color.LIGHTGRAY));
//
//        this.getChildren().add(getLine(400, 15, 400, 600-15, GameManager.theme == GameManager.Themes.CLASSIC ? Color.BLACK :
//                GameManager.theme == GameManager.Themes.FORREST ? Color.DARKGREEN :
//                        Color.LIGHTGRAY));
//        this.getChildren().add(getLine(15, 200, 600-15, 200, GameManager.theme == GameManager.Themes.CLASSIC ? Color.BLACK :
//                GameManager.theme == GameManager.Themes.FORREST ? Color.DARKGREEN :
//                        Color.LIGHTGRAY));
//        this.getChildren().add(getLine(15, 400, 600-15, 400, GameManager.theme == GameManager.Themes.CLASSIC ? Color.BLACK :
//                GameManager.theme == GameManager.Themes.FORREST ? Color.DARKGREEN :
//                        Color.LIGHTGRAY));
//
//        side_view();
//
//        for (int y = 0 ; y < 3 ; y++){
//            combos.add(new Combo(board[0][y],board[1][y], board[2][y]));
//        }//For Horizontal Tiles
//        for (int x = 0 ; x < 3 ; x++){
//            combos.add(new Combo(board[x][0],board[x][1], board[x][2]));
//        }//For Vertical Tiles
//
//        combos.add(new Combo(board[0][0],board[1][1], board[2][2]));
//        combos.add(new Combo(board[2][0],board[1][1], board[0][2]));
//    }
//
//    private void side_view() {
//        VBox box = new VBox();
//        box.setSpacing(10);
//        box.setAlignment(Pos.TOP_LEFT);
//        box.setLayoutX(3* 200);
//        box.setLayoutY(0);
//        box.setPrefSize(300, 600);
//        box.setPadding(new Insets(20));
//        box.getChildren().add(getLabel("THEME", Font.font("Aril", FontWeight.EXTRA_BOLD, 40),Color.BLACK));
//        RadioButton classic_rb = getRadioButton("CLASSIC", Font.font("Arial", FontPosture.REGULAR, 22),
//                GameManager.theme == GameManager.Themes.CLASSIC);
//        RadioButton forrest_rb = getRadioButton("FOREST", Font.font("Arial", FontPosture.REGULAR, 22),
//                GameManager.theme == GameManager.Themes.FORREST);
//        RadioButton highContrast_rb = getRadioButton("HIGH CONTRAST", Font.font("Arial", FontPosture.REGULAR, 22),
//                GameManager.theme == GameManager.Themes.HIGH_CONTRAST);
//
//        box.getChildren().addAll(classic_rb, forrest_rb, highContrast_rb);
//        group_radioButtons(classic_rb, forrest_rb, highContrast_rb);
//
//        VBox bottom_buttons = new VBox();
//        bottom_buttons.setSpacing(20);
//        bottom_buttons.setAlignment(Pos.BOTTOM_LEFT);
//
//        String style =
//                "-fx-background-color: black;"+
//                "-fx-text-fill: white;"+
//                "-fx-border-radius: 10;"+
//                "-fx-background-radius: 10;";
//        bottom_buttons.getChildren().add(get_button("Start With Random AI", Font.font("Arial", FontPosture.REGULAR, 20), e->{
//            // Here you can do stuff of Random AI
//        }, style));
//        bottom_buttons.getChildren().add(get_button("Start With Defensive AI", Font.font("Arial", FontPosture.REGULAR, 20), e->{
//            // Here you can do stuff of defensive AI.
//        }, style));
//        box.getChildren().add(bottom_buttons);
//        bottom_buttons.setPrefHeight(400);
//
//        this.getChildren().add(box);
//    }
//
//    Label getLabel(String text, Font font, Color color){
//        Label label = new Label();
//        label.setText(text);
//        label.setFont(font);
//        label.setTextFill(color);
//        return label;
//    }
//
//    RadioButton getRadioButton(String text, Font font, boolean isSelected){
//        RadioButton radioButton = new RadioButton(text);
//        radioButton.setFont(font);
//        radioButton.setSelected(isSelected);
//        return radioButton;
//    }
//
//    Button get_button(String str, Font font, EventHandler<ActionEvent> event, String style){
//        Button btn = new Button(str);
//        btn.setFont(font);
//        btn.setOnAction(event);
//        btn.setStyle(style);
//        return btn;
//    }
//
//    Line getLine(double startX, double startY, double endX, double endY, Color color){
//        Line line = new Line();
//        line.setStartX(startX);
//        line.setStartY(startY);
//        line.setEndX(endX);
//        line.setEndY(endY);
//        line.setStroke(color);
//        line.setStrokeWidth(6);
//        return line;
//    }
//
//    void group_radioButtons(RadioButton... btns){
//        for (RadioButton btn : btns) {
//            btn.selectedProperty().addListener((observable , oldValue, newValue ) ->{
//                if(newValue){
//                    switch(btn.getText()){
//                        case "CLASSIC":
//                            GameManager.theme = GameManager.Themes.CLASSIC;
//                            break;
//                        case "FOREST":
//                            GameManager.theme = GameManager.Themes.FORREST;
//                            break;
//                        case "HIGH CONTRAST":
//                            GameManager.theme = GameManager.Themes.HIGH_CONTRAST;
//                            break;
//                    }
//                    GameManager.combos.clear();
//                    GameManager.playable = true;
//                    board_setup();
//                    for (RadioButton radioButton : btns) {
//                        if(btn == radioButton) continue;
//                        radioButton.setSelected(false);
//                    }
//                }
//            });
//        }
//    }
//}


package com.sakib.tictactoe;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class GameBoard extends Pane {

    public GameBoard() {
        board_setup();
    }

    private void board_setup() {
        this.getChildren().clear();
        var board = GameManager.board;
        var combos = GameManager.combos;

        //Identified the Whole box
        this.setPrefSize(900, 600);
        //Separating the boxes #9
        for (int i = 0 ; i < 3 ; i++) {
            for (int j = 0; j < 3; j++) {
                Tile tile = new Tile();
                tile.setTranslateX(j * 200);
                tile.setTranslateY(i * 200);
                this.getChildren().add(tile);
                board[j][i] = tile;
            }
        }

        this.getChildren().add(getLine(200, 15, 200, 600-15,
                GameManager.theme == GameManager.Themes.CLASSIC ? Color.BLACK :
                        GameManager.theme == GameManager.Themes.FOREST ? Color.DARKGREEN :
                                Color.LIGHTGRAY));

        this.getChildren().add(getLine(400, 15, 400, 600-15, GameManager.theme == GameManager.Themes.CLASSIC ? Color.BLACK :
                GameManager.theme == GameManager.Themes.FOREST ? Color.DARKGREEN :
                        Color.LIGHTGRAY));
        this.getChildren().add(getLine(15, 200, 600-15, 200, GameManager.theme == GameManager.Themes.CLASSIC ? Color.BLACK :
                GameManager.theme == GameManager.Themes.FOREST ? Color.DARKGREEN :
                        Color.LIGHTGRAY));
        this.getChildren().add(getLine(15, 400, 600-15, 400, GameManager.theme == GameManager.Themes.CLASSIC ? Color.BLACK :
                GameManager.theme == GameManager.Themes.FOREST ? Color.DARKGREEN :
                        Color.LIGHTGRAY));

        side_view();

        for (int y = 0 ; y < 3 ; y++){
            combos.add(new Combo(board[0][y],board[1][y], board[2][y]));
        }//For Horizontal Tiles
        for (int x = 0 ; x < 3 ; x++){
            combos.add(new Combo(board[x][0],board[x][1], board[x][2]));
        }//For Vertical Tiles

        combos.add(new Combo(board[0][0],board[1][1], board[2][2]));
        combos.add(new Combo(board[2][0],board[1][1], board[0][2]));
    }

    private void side_view() {
        VBox box = new VBox();
        box.setSpacing(10);
        box.setAlignment(Pos.TOP_LEFT);
        box.setLayoutX(3* 200);
        box.setLayoutY(0);
        box.setPrefSize(300, 600);
        box.setPadding(new Insets(20));
        box.getChildren().add(getLabel("Theme", Font.font("Aril", FontWeight.EXTRA_BOLD, 30),Color.BLACK));
        RadioButton classic_rb = getRadioButton("Classic", Font.font("Arial", FontPosture.REGULAR, 26),
                GameManager.theme == GameManager.Themes.CLASSIC);
        RadioButton forrest_rb = getRadioButton("Forest", Font.font("Arial", FontPosture.REGULAR, 26),
                GameManager.theme == GameManager.Themes.FOREST);
        RadioButton highContrast_rb = getRadioButton("High Contrast", Font.font("Arial", FontPosture.REGULAR, 26),
                GameManager.theme == GameManager.Themes.HIGH_CONTRAST);

        box.getChildren().addAll(classic_rb, forrest_rb, highContrast_rb);
        group_radioButtons(classic_rb, forrest_rb, highContrast_rb);

        VBox bottom_btns = new VBox();
        bottom_btns.setSpacing(20);
        bottom_btns.setAlignment(Pos.BOTTOM_LEFT);

        String style =
                "-fx-background-color: black;"+
                "-fx-text-fill: white;"+
                "-fx-border-radius: 10;"+
                "-fx-background-radius: 10;";
        bottom_btns.getChildren().add(get_button("Start With Random AI", Font.font("Arial", FontPosture.REGULAR, 20), e->{
            // Here you can do stuff of Random AI
            GameManager.isDefensiveAI = false;
        }, style));
        bottom_btns.getChildren().add(get_button("Start With Defensive AI", Font.font("Arial", FontPosture.REGULAR, 20), e->{
            // Here you can do stuff of defensive AI.
            GameManager.isDefensiveAI = true;
        }, style));
        box.getChildren().add(bottom_btns);
        bottom_btns.setPrefHeight(400);

        this.getChildren().add(box);
    }

    Label getLabel(String text, Font font, Color color){
        Label label = new Label();
        label.setText(text);
        label.setFont(font);
        label.setTextFill(color);
        return label;
    }

    RadioButton getRadioButton(String text, Font font, boolean isSelected){
        RadioButton radioButton = new RadioButton(text);
        radioButton.setFont(font);
        radioButton.setSelected(isSelected);
        return radioButton;
    }

    Button get_button(String str, Font font, EventHandler<ActionEvent> event, String style){
        Button btn = new Button(str);
        btn.setFont(font);
        btn.setOnAction(event);
        btn.setStyle(style);
        return btn;
    }

    Line getLine(double startX, double startY, double endX, double endY, Color color){
        Line line = new Line();
        line.setStartX(startX);
        line.setStartY(startY);
        line.setEndX(endX);
        line.setEndY(endY);
        line.setStroke(color);
        line.setStrokeWidth(6);
        return line;
    }

    void group_radioButtons(RadioButton... btns){
        for (RadioButton btn : btns) {
            btn.selectedProperty().addListener((observable , oldValue, newValue ) ->{
                if(newValue){
                    switch(btn.getText()){
                        case "Classic":
                            GameManager.theme = GameManager.Themes.CLASSIC;
                            break;
                        case "Forrest":
                            GameManager.theme = GameManager.Themes.FOREST;
                            break;
                        case "High Contrast":
                            GameManager.theme = GameManager.Themes.HIGH_CONTRAST;
                            break;
                    }
                    GameManager.combos.clear();
                    GameManager.playable = true;
                    board_setup();
                    for (RadioButton radioButton : btns) {
                        if(btn == radioButton) continue;
                        radioButton.setSelected(false);
                    }
                }
            });
        }
    }
}
