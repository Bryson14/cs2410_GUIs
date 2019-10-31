package hw4_connectFour;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class ConnectFourPane extends Pane{
    private Board board;
    private Pane basePane;
    private int HEIGHT;
    private int WIDTH;
    private int rad;
    private int gap;
    private Color team1Color;
    private Color team2Color;
    private Color nullColor;
    private Color boardColor;
    private String background;
    private int team;

    ConnectFourPane() {
        this(7,6);
    }

    ConnectFourPane(int width, int height) {
        this.HEIGHT = height;
        this.WIDTH = width;
        team1Color = Color.RED;
        team2Color = Color.YELLOW;
        nullColor = Color.LIGHTGREY;
        team = 1;
        rad = 35;
        gap = 5;
        background = "#3f7dc7";
        this.basePane = new StackPane();
        this.basePane.setPadding(new Insets(15,15,15,15));
        basePane.setStyle("-fx-background-color: " + background);
        this.board = new Board(this.WIDTH, this.HEIGHT);
        newGame();
    }

    private void updateBoard(ActionEvent e) {
        System.out.println();
        VBox v = (VBox) e.getSource();
        int column = Integer.parseInt(v.getId());
        if (board.canAddDisk(column)) {
            board.addDisk(column);
            team = team == 1 ? -1 : 1; //switches team
        }
    }

    private void grayCircles() {
        GridPane pane = new GridPane();
        pane.setHgap(gap*4);
        pane.setVgap(gap);

        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                Circle cir = new Circle(rad, this.nullColor);
                pane.add(cir, j, i);
            }
        } this.basePane.getChildren().add(pane);
    }

    private void invisibleCircles() {
        GridPane pane = new GridPane();
        pane.setHgap(gap);
        pane.setVgap(gap);
        pane.setAlignment(Pos.CENTER);

        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                Circle cir = new Circle(rad, Color.TRANSPARENT);
                pane.add(cir, j, i);
            }
        } this.basePane.getChildren().add(pane);
    }

    private void changeDiskColor(Color color, int team) {
        if (team == 1) team1Color = color;
        else if (team == -1) team2Color = color;
    }

    void newGame() {
        grayCircles();
        invisibleCircles();
        getChildren().add(basePane);
    }
}
