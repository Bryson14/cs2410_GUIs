package hw4_connectFour;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ConnectFour extends Application {

    @Override
    public void start(Stage primaryStage) {
        ConnectFourPane c4 = new ConnectFourPane();
        Text message = new Text("Welcome to Connect Four");
        VBox Vpane = new VBox(c4, message);
        primaryStage.setScene(new Scene(Vpane));
        primaryStage.setTitle("Connect Four");
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        Application.launch(args);
    }
}
