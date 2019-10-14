package inClass;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import javafx.scene.paint.Stop;
import javafx.scene.paint.Color;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.CycleMethod;

import java.io.File;

public class ClownFace extends Application {

    @Override
    public void start(Stage primaryStage) {

        Pane pane = new Pane();
        javafx.beans.binding.DoubleBinding[] CENTER = {pane.widthProperty().divide(2),pane.heightProperty().divide(2)};

        File file = new File("src\\inClass\\clownfaces.jpg");
        ImageView background = new ImageView(new Image(file.toURI().toString()));
        background.setFitWidth(700);
        background.setFitHeight(700);

        Arc hair = new Arc();
        hair.centerXProperty().bind(CENTER[0]);
        hair.centerYProperty().bind(CENTER[1].subtract(50));
        hair.setRadiusX(125);
        hair.setRadiusY(125);
        hair.setStartAngle(0.0);
        hair.setLength(360);

        Stop[] stops = new Stop[] {
                new Stop(0, Color.BLUEVIOLET),
                new Stop(1, Color.LIMEGREEN),
                new Stop(2, Color.GREEN)
        };
        LinearGradient linearGradient =
                new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops);

        //Setting the linear gradient to the circle and text
        hair.setFill(linearGradient);


        Arc head = new Arc();
        head.centerXProperty().bind(CENTER[0]);
        head.centerYProperty().bind(CENTER[1].subtract(20));
        head.setRadiusX(110);
        head.setRadiusY(130);
        head.setStartAngle(0.0);
        head.setLength(360);
        head.setFill(Color.PEACHPUFF);

        Arc rEye = new Arc();
        rEye.centerXProperty().bind(CENTER[0].subtract(50));
        rEye.centerYProperty().bind(CENTER[1].subtract(65));
        rEye.setRadiusX(20);
        rEye.setRadiusY(30);
        rEye.setStartAngle(0);
        rEye.setLength(360);
        rEye.setFill(Color.BLUE);

        Arc lEye = new Arc();
        lEye.centerXProperty().bind(CENTER[0].add(50));
        lEye.centerYProperty().bind(CENTER[1].subtract(65));
        lEye.setRadiusX(20);
        lEye.setRadiusY(30);
        lEye.setStartAngle(0);
        lEye.setLength(360);
        lEye.setFill(Color.BLUE);

        Arc lowerSmile = new Arc();
        lowerSmile.centerXProperty().bind(CENTER[0]);
        lowerSmile.centerYProperty().bind(CENTER[1]);
        lowerSmile.setRadiusX(75);
        lowerSmile.setRadiusY(60);
        lowerSmile.setStartAngle(180);
        lowerSmile.setLength(180);
        lowerSmile.setFill(Color.RED);

        Arc upperSmile = new Arc();
        upperSmile.centerXProperty().bind(CENTER[0]);
        upperSmile.centerYProperty().bind(CENTER[1].subtract(50));
        upperSmile.setRadiusX(120);
        upperSmile.setRadiusY(70);
        upperSmile.setStartAngle(210);
        upperSmile.setLength(120);
        upperSmile.setFill(Color.PEACHPUFF);

        Arc nose = new Arc();
        nose.centerXProperty().bind(CENTER[0]);
        nose.centerYProperty().bind(CENTER[1].subtract(20));
        nose.setRadiusX(20);
        nose.setRadiusY(20);
        nose.setStartAngle(0);
        nose.setLength(360);
        nose.setFill(Color.RED);

        pane.getChildren().add(background);
        pane.getChildren().add(hair);
        pane.getChildren().add(head);
        pane.getChildren().add(rEye);
        pane.getChildren().add(lEye);
        pane.getChildren().add(lowerSmile);
        pane.getChildren().add(upperSmile);
        pane.getChildren().add(nose);

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
