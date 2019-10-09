package hw3_guiExercises;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class twoRectangles extends Application {

    @Override
    public void start(Stage primaryStage) {

        // welcome scene
        Text message =  new Text("Welcome to JavaFX");
        message.setFill(Color.WHITE);

        Pane pane = new StackPane();
        Rectangle rec = new Rectangle(100, 50, Color.GRAY);
        rec.setArcWidth(20);
        rec.setArcHeight(20);



        pane.getChildren().add(rec);
        pane.getChildren().add(message);


        //display squares scene

        Scene s = new Scene(pane);
        primaryStage.setScene(s);
        primaryStage.setTitle("HangMan Drawing");
        primaryStage.show();
    }
}
