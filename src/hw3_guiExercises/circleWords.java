package hw3_guiExercises;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class circleWords extends Application {

    @Override
    public void start(Stage primaryStage) {

        Pane pane = new Pane();
        javafx.beans.binding.DoubleBinding[] CENTER = {pane.widthProperty().divide(2),pane.heightProperty().divide(2)};
        Color color = Color.TEAL;
        String message = "Bryson would like an A+ please! "; // add space at the end for better appearance
        String style = "-fx-font: 32 rockwell;";
        double RADIUS = 180.0;

        for (int i  = 0; i < message.length(); i++) {

            double arcAngle = (i * (2*Math.PI) / message.length()) + Math.PI; // add pi to start on left side of circle

            Text t = new Text(String.valueOf(message.charAt(i)));
            t.setStyle(style);
            t.setFill(color);
            t.xProperty().bind((CENTER[0].add(Math.cos(arcAngle) * RADIUS)));
            t.yProperty().bind((CENTER[1].add( Math.sin(arcAngle) * RADIUS)));
            t.setRotate(90 + arcAngle*180/Math.PI); // add 90 to start first letter on its left side

            pane.getChildren().add(t);
        }

        Scene s = new Scene(pane, 450, 450);
        primaryStage.setScene(s);
        primaryStage.setTitle("Circle Words");
        primaryStage.show();
    }
}
