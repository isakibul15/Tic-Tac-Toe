package com.sakib.tictactoe;

import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
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
    public boolean isDraw(){
        boolean cond = true;
        for (Tile tile : tiles) {
            if(tile.text.getText().isEmpty()) cond = false;
        }
        return cond;
    }
    public static void checkBoardStatus(ArrayList<Combo> combos){
        for (Combo combo : combos) {
            if (combo.isComplete()) {
                GameManager.playable = false;
                ShowCombinationResult.createWinningAnimation(combo);
                Dialog<ButtonType> winner_msg = new Dialog<>();
                break;
            }
        }
    }
}
