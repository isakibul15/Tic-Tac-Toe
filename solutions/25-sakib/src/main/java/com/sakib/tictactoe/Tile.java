package com.sakib.tictactoe;

import javafx.geometry.Pos;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

class Tile extends StackPane {
    public Text text = new Text("");

    //Created Boxes
    public Tile() {
        Rectangle border = new Rectangle(200, 200);
        border.setFill(GameManager.theme == GameManager.Themes.CLASSIC ? Color.WHITE :
                GameManager.theme == GameManager.Themes.FORREST ? Color.LIGHTGREEN :
                        Color.DARKGRAY);

        text.setFont(Font.font(130));
        text.setFill(GameManager.theme == GameManager.Themes.CLASSIC ? Color.BLACK :
                GameManager.theme == GameManager.Themes.FORREST ? Color.GREEN :
                        Color.BLACK);

        setAlignment(Pos.CENTER);
        getChildren().addAll(border, text); // added text as list of children

        //Click Action as "X" & "0" as its object oriented
        setOnMouseClicked(event -> {
                    if (!GameManager.playable)
                        return;
                    if (event.getButton() == MouseButton.PRIMARY) {
                        createSymbolXOnTicTacToeGameBoard();
                        Combo.checkBoardStatus(GameManager.combos);

                        if(!GameManager.playable) {
                            GameManager.Check_player_win = true;
                            return;
                        }
                        GameManager.ai.generateNextMove(GameManager.board);
                        Combo.checkBoardStatus(GameManager.combos);// Checking if game is over or not

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

