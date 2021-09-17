package com.sakib.tictactoe;

import javafx.scene.control.RadioButton;
import javafx.stage.Stage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

@ExtendWith (ApplicationExtension.class)
class ThemeTest {
	
	
	@Start
	private void start(Stage stage) {
		Main.StartApplication(stage);
	}
	
	@Test
	void forrestThemeChange(FxRobot robot) {
		RadioButton ForestButton = robot.lookup("#forrest_button").queryAs(RadioButton.class);
		robot.clickOn(ForestButton);
		Assertions.assertEquals(GameManager.theme, GameManager.Themes.FOREST);
	}
	
	@Test
	void highContrastThemeChange(FxRobot robot) {
		RadioButton ForestButton = robot.lookup("#highContrast_button").queryAs(RadioButton.class);
		robot.clickOn(ForestButton);
		Assertions.assertEquals(GameManager.theme, GameManager.Themes.HIGH_CONTRAST);
	}
	
	@Test
	void classicThemeChange(FxRobot robot) {
		RadioButton ForestButton = robot.lookup("#classic_button").queryAs(RadioButton.class);
		robot.clickOn(ForestButton);
		Assertions.assertEquals(GameManager.theme, GameManager.Themes.CLASSIC);
	}
}