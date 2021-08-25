package com.sakib.tictactoe;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.util.Duration;

public class ShowCombinationResult {
    public static void createWinningAnimation(Combo combo){
        Line line = new Line();
        line.setStartX(combo.tiles[0].getCenterX());
        line.setStartY(combo.tiles[0].getCenterY());
        line.setEndX(combo.tiles[0].getCenterX());
        line.setEndY(combo.tiles[0].getCenterY());
        line.setStrokeWidth(6);

        line.setStroke(GameManager.theme == GameManager.Themes.CLASSIC ? Color.BLACK :
                GameManager.theme == GameManager.Themes.FORREST ? Color.YELLOW :
                        Color.WHITE);
        GameManager.gameBoard.getChildren().add(line);


        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(2),
                new KeyValue(line.endXProperty(),combo.tiles[2].getCenterX()),
                new KeyValue(line.endYProperty(),combo.tiles[2].getCenterY())));
        timeline.play();
    }

}
