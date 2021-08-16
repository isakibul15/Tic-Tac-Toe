package com.sakib.tictactoe;

import java.util.Random;

public class RandomAI extends AI {
    @Override
    public void generateNextMove(Tile[][] board) {
        int i;
        int j;
        var random = new Random();
        do {
            i = random.nextInt(3);
            j = random.nextInt(3);
//            System.out.println(board[i][j].text.getText());
            // 0-2 blank space random number generate
        } while (!board[i][j].text.getText().equals(""));
        board[i][j].createSymbolOOnTicTacToeGameBoard();
    }
}
