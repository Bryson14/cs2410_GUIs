package hw4_connectFour;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ConnectFour extends Application {

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new HBox();
        ConnectFourPane c4 = new ConnectFourPane();
        c4.newGame();
        pane.getChildren().add(new Text("Hello"));

        primaryStage.setScene(c4.getScene());
        primaryStage.show();
    }
}
