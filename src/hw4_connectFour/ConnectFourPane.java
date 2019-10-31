package hw4_connectFour;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class ConnectFourPane extends Pane{
    private Board board;            // board for logic
    private Pane basePane;          // parent pane
    private GridPane bottomPane;    //gray circle pane for animation reference
    private int HEIGHT;
    private int WIDTH;
    private int rad;                // radius of circle
    private int gap;                //gap between circles
    private Color team1Color;
    private Color team2Color;
    private Color nullColor;        // color for a empty spot
    private Color boardColor;
    private String background;
    private int team;               // -1, 1 place holder for team

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
        gap = 7;
        background = "#3f7dc7";
        this.bottomPane = new GridPane();
        this.basePane = new StackPane();
        this.basePane.setPadding(new Insets(15,15,15,15));
        basePane.setStyle("-fx-background-color: " + background);
        this.board = new Board(this.WIDTH, this.HEIGHT);
        newGame();
    }

    private void grayCircles() {
        this.bottomPane.setHgap(gap*4);
        this.bottomPane.setVgap(gap);

        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                Circle cir = new Circle(rad, this.nullColor);
                this.bottomPane.add(cir, i, j);
            }
        } this.basePane.getChildren().add(this.bottomPane);
    }


    private void placeDisk(String addedPos) {

    }

    public Node getNodeIndex (int row, int column, GridPane gridPane) {
        Node result = null;
        ObservableList<Node> childrens = gridPane.getChildren();

        for (Node node : childrens) {
            if(gridPane.getRowIndex(node) == row && gridPane.getColumnIndex(node) == column) {
                result = node;
                break;
            }
        }

        return result;
    }


    void newGame() {
        grayCircles();
        invisibleCircles();
        //rectangleCutout(); //TODO add this if i got time
        getChildren().add(basePane);
        basePane.setOnMouseClicked(event -> {
            int col = ((int)(event.getX())/(int)(basePane.getWidth()/this.WIDTH));
            System.out.println("col : " + col);
            if (this.board.canAddDisk(col)) {
                String addedPos = this.board.addDisk(col);
//                placeDisk(addedPos);
                if (this.board.getWinningIndexes() != null){} //flashWinners();
            } else if (this.board.isFull()) {
//                endGame();
            }
        });
    }
}
