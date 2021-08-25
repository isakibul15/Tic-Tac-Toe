package com.sakib.tictactoe;

public class DefensiveAI extends AI{

    @Override
    public void generateNextMove(Tile[][] board) {
        int excelentScore = 1;
        Tile excelentMove = null;
        for(int i = 0; i< 3; i++) {
            for (int j = 0; j < 3; j++) {
                // Is the spot available?
                if (board[i][j].text.getText().isEmpty()) {
                    board[i][j].text.setText("O");
                    GameManager.lastMove = board[i][j];
                    int score = minimax(board, 0, false);
                    board[i][j].text.setText("");
                    if (score < excelentScore) {
                        excelentScore = score;
                        excelentMove = board[i][j];
                    }
//                    System.out.printf("Board[%d][%d] and score == %d\n", i, j, bestScore);
                }
            }
        }
        if(excelentMove != null)
            excelentMove.createSymbolOOnTicTacToeGameBoard();
    }

    private int minimax(Tile[][] board, int depth, boolean isMaximizing) {
        // check if the game is already end.
        // if it is return the result.
        int result = Combo.checkWinner();
        if(result != 5) {
            return result;
        }

        int excelentScore;
        if(isMaximizing){
            excelentScore = 1;
            for(int i = 0; i< 3; i++){
                for(int j = 0; j< 3; j++){
                    // Is the spot available?
                    if(board[i][j].text.getText().isEmpty()){
                        board[i][j].text.setText("O");
                        GameManager.lastMove = board[i][j];
                        int score = minimax(board, depth+1,false);
                        board[i][j].text.setText("");
                        excelentScore = Math.min(score, excelentScore);
                    }
                }
            }
        }else{
            excelentScore = -1;
            for(int i = 0; i< 3; i++){
                for(int j = 0; j< 3; j++){
                    // Is the spot available?
                    if(board[i][j].text.getText().isEmpty()){
                        board[i][j].text.setText("X");
                        GameManager.lastMove = board[i][j];
                        int score = minimax(board, depth+1,true);
                        board[i][j].text.setText("");
                        excelentScore = Math.max(score, excelentScore);
                    }
                }
            }
        }
        return excelentScore;
    }
}
