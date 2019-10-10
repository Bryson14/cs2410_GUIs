package hw3_guiExercises;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.EventListener;

public class twoRectangles extends Application {

    @Override
    public void start(Stage primaryStage) {



        /*
        squares scene
         */

        Rectangle rec1 = new Rectangle(75,75);
        rec1.setStroke(Color.RED);
        rec1.setFill(Color.TRANSPARENT);
        rec1.setX(100);
        rec1.setY(200);

        Rectangle rec2 = new Rectangle(75,75);
        rec2.setStroke(Color.BLUE);
        rec2.setFill(Color.TRANSPARENT);
        rec2.setX(300);
        rec2.setY(200);

        Pane paneRectangles = new Pane();
        paneRectangles.getChildren().add(rec1);
        paneRectangles.getChildren().add(rec2);
        Scene scenerec = new Scene(paneRectangles, 600, 600);


        /*
        welcome scene
         */
        Text message =  new Text("Welcome to JavaFX");
        message.setFill(Color.BLACK);
        message.setStyle("-fx-font: 30 calibri;");
        message.setX(300);
        message.setY(300);


        Rectangle rec = new Rectangle(300, 80, Color.GRAY);
        rec.setX(300);
        rec.setY(600);
        rec.setArcWidth(20);
        rec.setArcHeight(20);

        Button bt = new Button("Press Me!");
        bt.setLayoutY(500);
        bt.setOnAction(e -> {
            primaryStage.setScene(scenerec);
        });

        Pane paneIntro = new StackPane();
        paneIntro.getChildren().add(rec);
        paneIntro.getChildren().add(message);

        Pane hbox = new HBox();
        hbox.getChildren().add(paneIntro);
        hbox.getChildren().add(bt);



        Scene s = new Scene(hbox, 600,600);
        primaryStage.setScene(s);
        primaryStage.setTitle("HangMan Drawing");
        primaryStage.show();
    }
}
