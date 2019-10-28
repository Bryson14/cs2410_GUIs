package hw4_connectFour;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class ConnectFourPane {
    private Board board;
    private Pane basePane;
    private int HEIGHT;
    private int WIDTH;
    private Color team1Color;
    private Color team2Color;
    private Color nullColor;
    private Color boardColor;
    private Background background;
    private int team;
    private Scene scene;

    ConnectFourPane() {
        HEIGHT = 6;
        WIDTH = 7;
        team1Color = Color.RED;
        team2Color = Color.YELLOW;
        nullColor = Color.WHITE;
        team = 1;
        background = new Background(new BackgroundFill(Paint.valueOf("FFFFFF"), CornerRadii.EMPTY, new Insets(5,5,5,5)));
        this.basePane = new HBox();
        this.board = new Board(this.WIDTH, this.HEIGHT);
        newGame();
        scene  = new Scene(basePane);
    }

    ConnectFourPane(int width, int height) {
        this.HEIGHT = height;
        this.WIDTH = width;
        team1Color = Color.RED;
        team2Color = Color.YELLOW;
        nullColor = Color.WHITE;
        team = 1;
        background = new Background(new BackgroundFill(Paint.valueOf("FFFFFF"), CornerRadii.EMPTY, new Insets(5,5,5,5)));
        this.basePane = new VBox();
        this.board = new Board(this.WIDTH, this.HEIGHT);
        newGame();
        scene  = new Scene(basePane);
    }

    private void updateBoard(ActionEvent e) {
        VBox v = (VBox) e.getSource();
        int column = Integer.parseInt(v.getId());
        if (board.canAddDisk(column)) {
            board.addDisk(column, team);
            team = team == 1 ? -1 : 1; //switches team
        }
    }

    public Scene getScene() {
        return scene;
    }

    private void changeDiskColor(Color color, int team) {
        if (team == 1) team1Color = color;
        else if (team == -1) team2Color = color;
    }

    void newGame() {
        for (int i = 0; i < this.WIDTH; i++) {
            VBox v = new VBox();
            v.setId("" + i);
            v.setBackground(background);

            for (int j = 0; j < this.HEIGHT; j++) {
                Circle c = new Circle(50);
                c.setFill(this.nullColor);
                v.getChildren().add(c);
            }
            basePane.getChildren().add(v);
        }
    }
}
