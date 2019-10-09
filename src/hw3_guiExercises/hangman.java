package hw3_guiExercises;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class hangman extends Application {


    @Override
    public void start(Stage primaryStage) {

        Pane pane = new StackPane();

        //TODO make the initial sizes and positions
        Circle head = new Circle();
        Line post = new Line();
        Line crossBoard = new Line();
        Line rope = new Line();
        Line body = new Line();
        Line rArm = new Line();
        Line lArm = new Line();
        Line rLeg = new Line();
        Line lLeg = new Line();
        Arc base = new Arc();


        pane.getChildren().add(base);
        pane.getChildren().add(post);
        pane.getChildren().add(crossBoard);
        pane.getChildren().add(rope);
        pane.getChildren().add(body);
        pane.getChildren().add(lArm);
        pane.getChildren().add(rArm);
        pane.getChildren().add(lLeg);
        pane.getChildren().add(rLeg);
        pane.getChildren().add(head);

        Scene s = new Scene(pane);
        primaryStage.setScene(s);
        primaryStage.setTitle("HangMan Drawing");
        primaryStage.show();
    }
}
