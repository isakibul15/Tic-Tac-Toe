package com.sakib.tictactoe;

import java.util.ArrayList;

public class GameManager {

    public enum Themes{
        CLASSIC,
        FORREST,
        HIGH_CONTRAST
    }

    public static Themes theme = Themes.CLASSIC;

    public static AI ai = new RandomAI();
    public static boolean playable = true;
    private boolean turnX = true;
    public static Tile[][] board = new Tile[3][3];
    public static ArrayList<Combo> combos = new ArrayList<>();
    public static GameBoard gameBoard = new GameBoard();
    public static boolean Check_player_win = false;
}