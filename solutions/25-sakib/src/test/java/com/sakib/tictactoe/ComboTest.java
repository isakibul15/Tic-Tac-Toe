package com.sakib.tictactoe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class ComboTest {
    static ArrayList<Combo> xWinsCombination;

    public static ArrayList<Combo> CreateXWinsCombination() {
        Tile[][] board = {
                {
                        new Tile("X"), new Tile("X"), new Tile("X")
                },
                {
                        new Tile("O"), new Tile("X"), new Tile("O")
                },
                {
                        new Tile("O"), new Tile("X"), new Tile("O")
                }
        };

        ArrayList<Combo> combos = new ArrayList<>();
        for (int y = 0 ; y < 3 ; y++){
            combos.add(new Combo(board[0][y],board[1][y], board[2][y]));
        }//For Horizontal Tiles
        for (int x = 0 ; x < 3 ; x++){
            combos.add(new Combo(board[x][0],board[x][1], board[x][2]));
        }//For Vertical Tiles

        combos.add(new Combo(board[0][0],board[1][1], board[2][2]));
        combos.add(new Combo(board[2][0],board[1][1], board[0][2]));

        return combos;
    }


    @BeforeAll
    static void init() {
        xWinsCombination = CreateXWinsCombination();
        GameManager.combos = xWinsCombination;
        GameManager.lastMove = new Tile("X");
    }

    @Test
    void TestXWins() {
        Combo.checkBoardStatus(xWinsCombination);
        Assertions.assertFalse(GameManager.playable);
        Assertions.assertEquals(1, Combo.checkWinner());
    }
}
