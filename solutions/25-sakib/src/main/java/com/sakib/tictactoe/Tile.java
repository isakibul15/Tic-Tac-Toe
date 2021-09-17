package com.sakib.tictactoe;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

class Tile extends StackPane {
    public Text text = new Text();

    ImageView imageView = new ImageView();
    Rectangle border;
    //Created Boxes
    public Tile() {
        border = new Rectangle(200, 200);
        border.setFill(GameManager.theme == GameManager.Themes.CLASSIC ? Color.WHITE :
                GameManager.theme == GameManager.Themes.FOREST ? Color.LIGHTGREEN :
                        Color.web("#414345"));

        text.setFont(Font.font(130));
        text.setFill(Color.BLACK);

        setAlignment(Pos.CENTER);
        getChildren().addAll(border, text,imageView); // added text as list of children

        imageView.setFitWidth(200);
        imageView.setFitHeight(200);
        //Click Action as "X" & "0" as its object oriented
        setOnMouseClicked(event -> {
                    if (!GameManager.playable)
                        return;
                    if (event.getButton() == MouseButton.PRIMARY) {
                        createSymbolXOnTicTacToeGameBoard();
                        Combo.checkBoardStatus(GameManager.combos);

                        if (!GameManager.playable) {
                            GameManager.is_player_won = true;
                            return;
                        }
                        if(!Combo.isDraw()) {
                            if (GameManager.isDefensiveAI)
                                GameManager.defensiveAI.generateNextMove(GameManager.board);
                            else
                                GameManager.ai.generateNextMove(GameManager.board);
                        }else{
                            System.out.println("GG");
                            GameManager.playable = false;
                        }
                        Combo.checkBoardStatus(GameManager.combos);// Checking if game is over or not
                    }
//                    GameManager.print_status();
                }
        );
    }

    public void updateTheme(){
        border.setFill(GameManager.theme == GameManager.Themes.CLASSIC ? Color.WHITE :
                GameManager.theme == GameManager.Themes.FOREST ? Color.LIGHTGREEN :
                        Color.web("#414345"));

        if(GameManager.theme == GameManager.Themes.FOREST){
            text.setOpacity(0);
            imageView.setDisable(false);
            imageView.setOpacity(1);
            if(text.getText().equals("X"))
                imageView.setImage(new Image(getClass().getResource("flower.png").toString()));
            else if(text.getText().equals("O"))
                imageView.setImage(new Image(getClass().getResource("lemon.png").toString()));
        }else if(GameManager.theme == GameManager.Themes.HIGH_CONTRAST){
            text.setOpacity(0);
            imageView.setDisable(false);
            imageView.setOpacity(1);
            if(text.getText().equals("X"))
                imageView.setImage(new Image(getClass().getResource("human.png").toString()));
            else if(text.getText().equals("O"))
                imageView.setImage(new Image(getClass().getResource("ai.png").toString()));
        }else{
            text.setOpacity(1);
            imageView.setDisable(true);
            imageView.setOpacity(0);
        }
    }

    public double getCenterX(){
        return getTranslateX() + 100;
    }
    public double getCenterY(){
        return getTranslateY() + 100;
    }
    public String getValue(){
        return text.getText();
    }
    //Initializing the "X" & "0" as text
    public void createSymbolXOnTicTacToeGameBoard(){
        switch (GameManager.theme) {
            case CLASSIC:
                text.setOpacity(1);
                text.setText("X");
                imageView.setOpacity(0);
                imageView.setDisable(true);
                break;
            case FOREST:
                text.setOpacity(0);
                text.setText("X");
                imageView.setOpacity(1);
                imageView.setImage(new Image(getClass().getResource("flower.png").toString()));
                imageView.setDisable(false);
                break;
            case HIGH_CONTRAST:
                text.setOpacity(0);
                text.setText("X");
                imageView.setOpacity(1);
                imageView.setDisable(false);
                imageView.setImage(new Image(getClass().getResource("human.png").toString()));
                break;
        }
    }
    public void createSymbolOOnTicTacToeGameBoard(){
        switch (GameManager.theme) {
            case CLASSIC:
                text.setOpacity(1);
                text.setText("O");
                imageView.setOpacity(0);
                imageView.setDisable(true);
                break;
            case FOREST:
                text.setOpacity(0);
                text.setText("O");
                imageView.setOpacity(1);
                imageView.setImage(new Image(getClass().getResource("lemon.png").toString()));
                imageView.setDisable(false);
                break;
            case HIGH_CONTRAST:
                text.setOpacity(0);
                text.setText("O");
                imageView.setOpacity(1);
                imageView.setDisable(false);
                imageView.setImage(new Image(getClass().getResource("ai.png").toString()));
                break;
        }
    }
}