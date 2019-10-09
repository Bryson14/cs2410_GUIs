package hw3_guiExercises;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class circleWords extends Application {

    @Override
    public void start(Stage primaryStage) {

        Pane pane = new StackPane();
        Circle circle = new Circle(100);

        Text message =  new Text("Welcome to JavaFX");
        message.setFill(Color.WHITE);

        pane.getChildren().add(circle);
        pane.getChildren().add(message);


        Scene s = new Scene(pane);
        primaryStage.setScene(s);
        primaryStage.setTitle("HangMan Drawing");
        primaryStage.show();
    }
}
