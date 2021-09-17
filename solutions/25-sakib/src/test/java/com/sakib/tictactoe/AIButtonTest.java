package com.sakib.tictactoe;

import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

@ExtendWith (ApplicationExtension.class)
class AIButtonTest {
	
	
	@Start
	private void start(Stage stage) {
		Main.StartApplication(stage);
	}
	
	@Test
	void defensiveAI(FxRobot robot) {
		Button defensive = robot.lookup("#defensive_button").queryAs(Button.class);
		robot.clickOn(defensive);
		Assertions.assertTrue(GameManager.isDefensiveAI);
	}
	
	@Test
	void randomAI(FxRobot robot) {
		Button random = robot.lookup("#random_button").queryAs(Button.class);
		robot.clickOn(random);
		Assertions.assertFalse(GameManager.isDefensiveAI);
	}
	
}