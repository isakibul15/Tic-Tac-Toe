package com.sakib.tictactoe;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class TicTacToeApp extends Application {

    AI ai = new RandomAI();
    private boolean playable = true;
    private boolean turnX = true;
    private Tile[][] board = new Tile[3][3];
    private List<Combo> combos = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(generateGameBoxes()));
        primaryStage.show();
    }

    public Pane root = new Pane();

    public Parent generateGameBoxes() {
        //Identified the Whole box
        root.setPrefSize(900, 600);
        //Sepertating the boxes #9
        for (int i = 0 ; i < 3 ; i++){
            for (int j = 0 ; j < 3 ; j++){
                Tile tile = new Tile();
                tile.setTranslateX(j * 200);
                tile.setTranslateY(i * 200);

                root.getChildren().add(tile);

                board[j][i] = tile;
            }
        }

        //For Horizontal Tiles
        for (int y = 0 ; y < 3 ; y++){
            combos.add(new Combo(board[0][y],board[1][y], board[2][y]));
        }

        //For Vertical Tiles
        for (int x = 0 ; x < 3 ; x++){
            combos.add(new Combo(board[x][0],board[x][1], board[x][2]));
        }

        //For Diagonals
        combos.add(new Combo(board[0][0],board[1][1], board[2][2]));
        combos.add(new Combo(board[2][0],board[1][1], board[0][2]));
        return root;
    }

    private void checkBoardStatus(){
        for (Combo combo : combos) {
            if (combo.isComplete()) {
                playable = false ;
                createWinningAnimation(combo);
                break;
            }
        }
    }

    public void createWinningAnimation(Combo combo){
        Line line = new Line();
        line.setStartX(combo.tiles[0].getCenterX());
        line.setStartY(combo.tiles[0].getCenterY());
        line.setEndX(combo.tiles[0].getCenterX());
        line.setEndY(combo.tiles[0].getCenterY());

        root.getChildren().add(line);

        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(2),
                new KeyValue(line.endXProperty(),combo.tiles[2].getCenterX()),
                new KeyValue(line.endYProperty(),combo.tiles[2].getCenterY())));
        timeline.play();
    }

    private class Combo {
        private Tile[] tiles;
        public Combo(Tile... tiles) {
            this.tiles = tiles ;
        }

        public boolean isComplete(){
            if (tiles[0].getValue().isEmpty())
                return false;

            return tiles[0].getValue().equals(tiles[1].getValue())
                    && tiles[0].getValue().equals(tiles[2].getValue());
        }
    }

    class Tile extends StackPane{
        public Text text = new Text();

        //Created Boxes
        public Tile(){
            Rectangle border = new Rectangle(200, 200);
            border.setFill(null);
            border.setStroke(Color.BLACK);

            text.setFont(Font.font(70));

            setAlignment(Pos.CENTER);
            getChildren().addAll(border, text); // added text as list of children

            //Click Action as "X" & "0" as its object oriented
            setOnMouseClicked(event -> {
                if (!playable)
                    return;
                if (event.getButton() == MouseButton.PRIMARY){
                    createSymbolXOnTicTacToeGameBoard();
                    checkBoardStatus();
                    ai.generateNextMove(board);
                    checkBoardStatus();
                }
//              else if (event.getButton() == MouseButton.SECONDARY){
//                    if (turnX)
//                        return;
//
//                    draw0();
//                    turnX = true;
//                    checkState();
//                }
                }
            );
        }

        public double getCenterX(){
            return getTranslateX() + 100;
        }

        public double getCenterY(){
            return getTranslateY() + 100;
        }

        public String getValue(){
            return text.getText();
        }

        //Initializing the "X" & "0" as text
        private void createSymbolXOnTicTacToeGameBoard(){
            text.setText("X");
        }
        public void createSymbolOOnTicTacToeGameBoard(){
            text.setText("0");
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}
