package hw3_guiExercises;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class hangman extends Application {


    @Override
    public void start(Stage primaryStage) {

        File file = new File("src\\hw3_guiExercises\\dead_face.png");
        ImageView deadHead = new ImageView(new Image(file.toURI().toString()));
        deadHead.setFitWidth(70);
        deadHead.setFitHeight(70);
        deadHead.setX(265);
        deadHead.setY(125);

        int[] WAIST = {300, 300};
        int[] SHOLDRS = {300, 150};
        Line post = new Line(100,100, 100, 500);
        Line crossBoard = new Line(100,100,300,100);
        Line rope = new Line(300,100,300,130);
        Line body = new Line(SHOLDRS[0], SHOLDRS[1], WAIST[0], WAIST[1]);
        int LENGTH = 100;
        Line rLeg = new Line(WAIST[0], WAIST[1], Math.cos(30) * LENGTH + WAIST[0], WAIST[1] - Math.sin(30) * LENGTH);
        Line lLeg = new Line(WAIST[0], WAIST[1], WAIST[0] - Math.cos(30) * LENGTH, WAIST[1] - Math.sin(30) * LENGTH);
        Line rArm = new Line(SHOLDRS[0], SHOLDRS[1], SHOLDRS[0] + LENGTH * Math.cos(30), SHOLDRS[1] - LENGTH * Math.sin(30));
        Line lArm = new Line(SHOLDRS[0], SHOLDRS[1], SHOLDRS[0] - LENGTH * Math.cos(30), SHOLDRS[1] - LENGTH * Math.sin(30));
        Arc base = new Arc(100, 550, 75,50, 0 , 180);
        Line floor = new Line(0, 550, 600,550);
        floor.setStrokeWidth(5);
        floor.setStroke(Color.GREEN);
        base.setFill(Color.LAWNGREEN);
        base.setStroke(Color.BLACK);

        Pane pane = new Pane();

        pane.getChildren().add(floor);
        pane.getChildren().add(base);
        pane.getChildren().add(post);
        pane.getChildren().add(crossBoard);
        pane.getChildren().add(rope);
        pane.getChildren().add(body);
        pane.getChildren().add(lArm);
        pane.getChildren().add(rArm);
        pane.getChildren().add(lLeg);
        pane.getChildren().add(rLeg);
        pane.getChildren().add(deadHead);

        Scene s = new Scene(pane, 600, 600);
        primaryStage.setScene(s);
        primaryStage.setTitle("HangMan Drawing");
        primaryStage.show();
    }
}
