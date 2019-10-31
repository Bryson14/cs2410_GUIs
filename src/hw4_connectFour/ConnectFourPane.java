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
    private Color team1Color;
    private Color team2Color;
    private Color nullColor;
    private Color boardColor;
    private Background background;
    private int team;

    ConnectFourPane() {
        HEIGHT = 6;
        WIDTH = 7;
        team1Color = Color.RED;
        team2Color = Color.BLUE;
        nullColor = Color.LIGHTGREY;
        team = 1;
        rad = 35;
        this.basePane = new HBox();
        this.board = new Board(this.WIDTH, this.HEIGHT);
        newGame();
    }

    ConnectFourPane(int width, int height) {
        this.HEIGHT = height;
        this.WIDTH = width;
        team1Color = Color.RED;
        team2Color = Color.YELLOW;
        nullColor = Color.LIGHTGREY;
        team = 1;
        rad = 35;
//        background = new Background(new BackgroundFill(Paint.valueOf("FFFFFF"), CornerRadii.EMPTY, new Insets(5,5,5,5)));
        this.basePane = new HBox();
        this.board = new Board(this.WIDTH, this.HEIGHT);
        newGame();
    }

    private void updateBoard(ActionEvent e) {
        VBox v = (VBox) e.getSource();
        int column = Integer.parseInt(v.getId());
        if (board.canAddDisk(column)) {
            board.addDisk(column);
            team = team == 1 ? -1 : 1; //switches team
        }
    }

    private void grayCircles() {
        GridPane pane = new GridPane();
        pane.setHgap(5);
        pane.setVgap(5);
        pane.setAlignment(Pos.CENTER);
        pane.maxHeight((double)(HEIGHT*35*5));

        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                Circle cir = new Circle(rad, this.nullColor);
                pane.add(cir, j, i);
            }
        }
        this.basePane.getChildren().add(pane);
    }

    private void changeDiskColor(Color color, int team) {
        if (team == 1) team1Color = color;
        else if (team == -1) team2Color = color;
    }

    void newGame() {
        grayCircles();
//        for (int i = 0; i < this.WIDTH; i++) {
//            VBox v = new VBox();
//            v.setId("" + i);
//            v.setBackground(background);
//
//            for (int j = 0; j < this.HEIGHT; j++) {
//                Circle c = new Circle(35);
//                c.setFill(this.nullColor);
//                v.getChildren().add(c);
//            }
//            basePane.getChildren().add(v);
//        }
        getChildren().add(basePane);
    }
}
/*
StackPane base = new StackPane();
        Rectangle rec = new Rectangle(HEIGHT*(2*radius+gap)+3*gap, WIDTH*(2*radius+gap)+3*gap);
        rec.setFill(background);
        GridPane pane = new GridPane();
        pane.setHgap(gap);
        pane.setVgap(gap);
        pane.setAlignment(Pos.CENTER);
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                Circle cir = new Circle(radius, piece);
                pane.add(cir, j, i);
            }
        }

        base.getChildren().addAll(rec, pane);
        return base;
 */
