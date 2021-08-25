package com.sakib.tictactoe;

import java.util.ArrayList;

public class GameManager {

    public enum Themes{
        CLASSIC,
        FOREST,
        HIGH_CONTRAST
    }

    public static Themes theme = Themes.CLASSIC;

    public static Tile lastMove;
    public static boolean isDefensiveAI = false;
    public static AI ai = new RandomAI();
    public static AI defensiveAI = new DefensiveAI();
    public static boolean playable = true;
    private boolean turnX = true;
    public static Tile[][] board = new Tile[3][3];
    public static ArrayList<Combo> combos = new ArrayList<>();
    public static GameBoard gameBoard = new GameBoard();
    public static boolean is_player_won = false;
}