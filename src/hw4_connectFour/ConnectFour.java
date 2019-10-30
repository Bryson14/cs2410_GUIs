package hw4_connectFour;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ConnectFour extends Application {

    @Override
    public void start(Stage primaryStage) {
        Pane basePane = new StackPane();
        basePane.getChildren().add(new Circle(100, Color.GRAY ));
        testScene test = new testScene();




        Text message = new Text("Welcome to Connect Four");
        VBox Vpane = new VBox(basePane, message);
        Vpane.setAlignment(Pos.BOTTOM_CENTER);
//        primaryStage.setScene(new Scene(Vpane));
        primaryStage.setScene(test.getScene());
        primaryStage.show();
    }
}
