package hw3_guiExercises;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Scanner;

public class twoRectangles extends Application {

    private boolean contains(int[] inputs) {
        int leftSideDiff = inputs[0] - inputs[2];
        boolean leftSideDiffNeg = leftSideDiff < 0; //false if blue is to the left of red
        int rightSideDiff = (inputs[0] + inputs[4]) - (inputs[2] + inputs[6]);
        boolean rightSideDiffNeg = rightSideDiff < 0;// false if blue is to the left of red

        int topSideDiff = inputs[1] - inputs[3];
        boolean topSideDiffNeg = topSideDiff < 0; // true if blue above red
        int bottomSideDiff = (inputs[1] + inputs[5]) - (inputs[3] + inputs[7]);
        boolean bottomSideDiffNeg = bottomSideDiff < 0; // true if red above blue

        if (leftSideDiffNeg && !rightSideDiffNeg && topSideDiffNeg && !bottomSideDiffNeg) {
            System.out.println("true");
            // red contains blue
            return true;
        } else if (!leftSideDiffNeg && rightSideDiffNeg && !topSideDiffNeg && bottomSideDiffNeg) {
            // blue contains red
            return true;
        } else return false;
    }

    private boolean overlaps (int[] inputs) {
        int left1 = inputs[0];
        int top1 = inputs[1];
        int left2 = inputs[2];
        int top2 = inputs[3];
        int right1 = inputs[4] + inputs[0];
        int right2 = inputs[6] + inputs[2];
        int bottom1 = inputs[1] + inputs[5];
        int bottom2 = inputs[3] + inputs[7];

        if( ((left1 < left2 && left2 < right1) || (left2 < left1 && left1 < right2 ))&&
                ((top1 < top2 && top2 < bottom1) || (top2 < top1 && top1 < bottom2))) return true;
        else return false;
    }

    @Override
    public void start(Stage primaryStage) {
        /*
        rectangles scene
         */

        Scanner scanner = new Scanner(System.in);
        int[] inputs = new int[9];
        String[] inputQuestions = {"Enter the x coor of square 1:", "Enter the y coor of square 1:",
                "Enter the x coor of square 2:","Enter the y coor of square 2:", "Enter the width of square 1:",
                "Enter the height of square 1:", "Enter the width of square 2:", "Enter the height of square 2:"
        };

        for (int i = 0; i < inputQuestions.length; i++) {
            System.out.println(inputQuestions[i]);
            inputs[i] = scanner.nextInt();
        }

        Text recStatus = new Text();
        recStatus.setX(150);
        recStatus.setY(490);
        recStatus.setStyle("-fx-font: 24 arial;");

        if (overlaps(inputs)) {
            recStatus.setText("The rectangles overlap.");
        } else if (contains(inputs)) {
            recStatus.setText("One rectangle is contained in another. ");
        } else {
            recStatus.setText("The rectangles do not overlap.");
        }

        Rectangle rec1 = new Rectangle( inputs[4],inputs[5]);
        rec1.setStroke(Color.RED);
        rec1.setFill(Color.TRANSPARENT);
        rec1.setX(inputs[0]);
        rec1.setY(inputs[1]);

        Rectangle rec2 = new Rectangle( inputs[6], inputs[7]);
        rec2.setStroke(Color.BLUE);
        rec2.setFill(Color.TRANSPARENT);
        rec2.setX(inputs[2]);
        rec2.setY(inputs[3]);

        Pane paneRectangles = new Pane();
        paneRectangles.getChildren().add(rec1);
        paneRectangles.getChildren().add(rec2);
        paneRectangles.getChildren().add(recStatus);
        Scene sceneRec = new Scene(paneRectangles, 600, 500);


        /*
        welcome scene
         */
        Text message =  new Text("Welcome to JavaFX");
        message.setFill(Color.BLACK);
        message.setStyle("-fx-font: 30 calibri;");
        message.setX(150);
        message.setY(300);


        Rectangle rec = new Rectangle(300, 80, Color.GRAY);
        rec.setX(130);
        rec.setY(250);
        rec.setArcWidth(20);
        rec.setArcHeight(20);

        Button bt = new Button("Press Me!");
        bt.setTranslateX(230);
        bt.setTranslateY(50);
        bt.setOnAction(e -> {
            primaryStage.setScene(sceneRec);

        });

        Pane paneIntro = new Pane();
        paneIntro.getChildren().add(rec);
        paneIntro.getChildren().add(message);
        paneIntro.getChildren().add(bt);

        Scene s = new Scene(paneIntro, 600,500);
        primaryStage.setScene(s);
        primaryStage.setTitle("Two rectangles");
        primaryStage.show();
    }
}
