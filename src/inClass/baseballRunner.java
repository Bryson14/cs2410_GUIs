package inClass;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class baseballRunner extends Application {

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        int NumberOfBases = 4;
        boolean leftRight = true;
        int flip = -1;

        for (int i = 0; i < NumberOfBases; i ++) {
            leftRight ^= true;
            Rectangle rec = new Rectangle(75, 75);
            if (leftRight) flip = -1;
            else flip = 1;



            pane.getChildren().add(rec);
        }

        ImageView gif = new ImageView("http://www.homestead.com/~media/elements/AnimatedClipart/people/animations/baseball_player__runningA.gif");
        pane.getChildren().add(gif);
        primaryStage.setScene(new Scene(pane));
        primaryStage.show();
    }
}
