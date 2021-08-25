package com.sakib.tictactoe;

import java.util.ArrayList;

public class Combo {
    public Tile[] tiles;

    public Combo(Tile... tiles) {
        this.tiles = tiles;
    }

    public boolean isComplete() {
        if (tiles[0].getValue().isEmpty())
            return false;

        return tiles[0].getValue().equals(tiles[1].getValue())
                && tiles[0].getValue().equals(tiles[2].getValue());
    }

    public static boolean isDraw(){
        for(int i = 0; i< 3; i++){
            for(int j = 0; j<3; j++){
                if(GameManager.board[i][j].text.getText().isEmpty()) return false;
            }
        }
        return true;
    }

    public static int checkWinner(){
        for (Combo combo : GameManager.combos) {
            if(combo.isComplete()){
                if(GameManager.lastMove.text.getText().equals("X")) return 1;
                else return -1;
            }
        }
        if(isDraw()){
            return 0;
        }
        return 5;
    }

    public static void checkBoardStatus(ArrayList<Combo> combos){
        for (Combo combo : combos) {
            if (combo.isComplete()) {
                GameManager.playable = false;
                ShowAnimationLine.createWinningAnimation(combo);
                break;
            }
        }
    }
}
