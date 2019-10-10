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
        int[] CENTER = {200,200};
        String message = "Lets get this bread fam  ";
        String style = "-fx-font: 38 rockwell;";
        double RADIUS = 75.0;

        for (int i  = 0; i < message.length(); i++) {
            double arcAngle = (i * (2*Math.PI) / message.length()) + Math.PI;
            Text t = new Text(String.valueOf(message.charAt(i)));
            t.setStyle(style);
            t.setX(CENTER[0] + Math.cos(arcAngle) * RADIUS);
            t.setY(CENTER[1] + Math.sin(arcAngle) * RADIUS);
            t.setRotate(90 + arcAngle*180/Math.PI);
            pane.getChildren().add(t);
        }


        Scene s = new Scene(pane, 400, 400);
        primaryStage.setScene(s);
        primaryStage.setTitle("Circle Words");
        primaryStage.show();
    }
}
