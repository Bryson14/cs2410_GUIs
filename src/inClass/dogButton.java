package inClass;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Random;

public class dogButton extends Application {
    int i = 0;

    ImageView image = null;
    public void start (Stage stage) {

        String BASE_URL = "https://placedog.net/";
        String[] BUTTON_TAG = {"Do you like Puppies?", "I love Puppies", "Dogs are better than Cats"};
        Random ran = new Random();

        Button bt = new Button("Wanna a Puppy?");
        Pane pane = new FlowPane();
        pane.getChildren().add(bt);

        bt.setOnAction(e -> {
            bt.setText(BUTTON_TAG[i++]);
            if (i > 2 ) i = 0;

            int h = ran.nextInt(500)+500;
            int w = ran.nextInt(200) + 800;
            String url = BASE_URL + "/" + w + "/" + h;
            pane.getChildren().remove(image);
            image = new ImageView(url);
            pane.getChildren().add(image);
        });


        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setTitle("DOG Generator!");
        stage.show();
    }
}
