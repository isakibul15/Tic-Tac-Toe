import com.sakib.tictactoe.GameManager;
import javafx.application.Application;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import javafx.scene.Scene;
import javafx.stage.Stage;

@ExtendWith(Application.class)
class ButtonTest {



    @Test
    private void start(Stage stage) {

        Scene tictactoeScene = new Scene(GameManager.gameBoard);

        stage.setScene(tictactoeScene);
        stage.setTitle(String.valueOf(GameManager.gameBoard));
        stage.centerOnScreen();
        stage.setResizable(false);
        stage.show();
    }