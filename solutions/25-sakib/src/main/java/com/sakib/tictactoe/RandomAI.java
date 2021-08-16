package com.sakib.tictactoe;

import java.util.Random;

public class RandomAI extends AI {
    @Override
    public void generateNextMove(Tile[][] board) {
        int i,j;
        var random_grid = new Random();
        do {
            i = random_grid.nextInt(3);
            j = random_grid.nextInt(3);
//            System.out.println(board[i][j].text.getText());
            // 0-2 blank space random number generate
        } while (!board[i][j].text.getText().equals(""));
        board[i][j].createSymbolOOnTicTacToeGameBoard();
    }
}
