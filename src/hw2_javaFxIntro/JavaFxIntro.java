package hw2_javaFxIntro;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class JavaFxIntro extends Application {

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new StackPane();
        Pane hbox = new HBox();

        // Create a circle and set its properties
        Rectangle rec = new Rectangle();
        rec.setHeight(100);
        rec.setStroke(Color.LIMEGREEN);
        rec.setFill(Color.INDIANRED);
        pane.getChildren().add(rec); // Add circle to the pane

        Label label = new Label("Hello");
        Label label2 = new Label("World");
        Font fnt1 = new Font("Algerian",30);

        label.setFont(fnt1);
        label.setTextFill(Color.BLUE);
        label2.setFont(fnt1);
        label2.setTextFill(Color.YELLOW);

        hbox.getChildren().add(label);
        hbox.getChildren().add(label2);
        pane.getChildren().add(hbox); // Add HBox to the pane

        rec.widthProperty().bind(hbox.widthProperty().divide(2));


        Scene scene = new Scene(pane);
        primaryStage.setTitle("JavaFXIntro");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}