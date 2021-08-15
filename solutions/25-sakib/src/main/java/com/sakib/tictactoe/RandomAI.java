package com.sakib.tictactoe;

public class RandomAI extends AI{
    @Override
    public void generateNextMove(Tile[][] board) {
        for (int i = 0 ; i < 3 ; i++){
            for (int j = 0 ; j <3 ; j++){
                if (board[i][j].text.getText() == ""){
                    board[i][j].createSymbolOOnTicTacToeGameBoard();
                    return;
                }
            }
        }
    }
}