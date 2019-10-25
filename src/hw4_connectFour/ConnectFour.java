package hw4_connectFour;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ConnectFour extends Application {

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new HBox();
        ConnectFourPane c4 = new ConnectFourPane();
        pane.getChildren().add(c4);

        primaryStage.setScene(new Scene(pane));
        primaryStage.show();
    }
}
