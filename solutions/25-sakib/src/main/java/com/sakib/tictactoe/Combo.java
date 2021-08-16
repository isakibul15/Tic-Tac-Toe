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
//                winner_msg.setTitle("Winner Announce");
//                winner_msg.setHeaderText("THE WINNER IS");
//                winner_msg.setContentText("Player: "+(GameManager.is_player_won ? "X" : "O"));
//                winner_msg.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
//                winner_msg.showAndWait();
                break;
            }
//            else if(combo.isDraw()){
//                Dialog<ButtonType> winner_msg = new Dialog<>();
//                winner_msg.setTitle("Game Draw");
//                winner_msg.setHeaderText("NO BODY WON!");
//                winner_msg.setContentText("Better Luck Next Time losers :P");
//                winner_msg.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
//                winner_msg.showAndWait();
//                break;
//            }
        }
    }
}
