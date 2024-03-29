package hw4_connectFour;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ConnectFour extends Application {
    VBox Vpane;
    @Override
    public void start(Stage primaryStage) {
        ConnectFourPane c4 = new ConnectFourPane();
        Text message = new Text("Welcome to Connect Four");
        Vpane = new VBox(c4, message);
        Vpane.setAlignment(Pos.CENTER);
        primaryStage.setScene(new Scene(Vpane));
        primaryStage.setTitle("Connect Four");
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        Application.launch(args);
    }
}
