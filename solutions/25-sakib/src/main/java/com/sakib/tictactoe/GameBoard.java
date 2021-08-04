package com.sakib.tictactoe;

import javafx.scene.layout.Pane;

public class GameBoard extends Pane {
    public GameBoard() {
        var board = GameManager.board;
        var combos = GameManager.combos;
        //Identified the Whole box
        this.setPrefSize(900, 600);
        //Sepertating the boxes #9
        for (int i = 0 ; i < 3 ; i++){
            for (int j = 0 ; j < 3 ; j++){
                Tile tile = new Tile();
                tile.setTranslateX(j * 200);
                tile.setTranslateY(i * 200);

                this.getChildren().add(tile);

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
    }
}
