package hw4_connectFour;

import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.util.Duration;

public class ConnectFourPane extends Pane{
    private Board board;            // board for logic
    private Pane basePane;          // parent pane
    private GridPane bottomPane;    //gray circle pane for animation reference
    private Pane middlePane;        //pane for disk animation
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
        background = "#3f7dc7"; //sky blue
        this.bottomPane = new GridPane();
        this.middlePane = new Pane();
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
                this.bottomPane.add(new Circle(rad, this.nullColor), i, j);
            }
        } this.basePane.getChildren().add(this.bottomPane);
    }

    private void placeDisk(String addedPos) {
        int col = Character.getNumericValue(addedPos.charAt(0));
        int row = Character.getNumericValue(addedPos.charAt(1));
        System.out.println("col: " + col + "row: " + row);
        Node endNode = getNodeIndex(col, row, this.bottomPane);
        team = this.board.getTeam();
        Color color = null;
        if (team == -1) color = team2Color;
        else color = team1Color;

        Circle cir = new Circle(this.rad, color);
        PathTransition pt = new PathTransition(Duration.millis(1000), new Line(endNode.getLayoutX(), 0, endNode.getLayoutX(), endNode.getLayoutY()), cir);
        pt.setCycleCount(1);
        pt.play();
    }

    public Node getNodeIndex (int row, int column, GridPane gridPane) {
        Node result = null;
        ObservableList<Node> childrens = gridPane.getChildren();

        for (Node node : childrens) {
            if(gridPane.getRowIndex(node) == row && gridPane.getColumnIndex(node) == column) {
                result = node;
                break;
            }
        } return result;
    }

    private void endGame(boolean winnerExist) {
        if (winnerExist) {

        }
    }


    void newGame() {
        grayCircles();
        //rectangleCutout(); //TODO add this if i got time
        getChildren().add(basePane);
        basePane.setOnMouseClicked(event -> {
            int col = ((int)(event.getX())/(int)(basePane.getWidth()/this.WIDTH));
            System.out.println("col : " + col);
            if (this.board.canAddDisk(col)) {
                String addedPos = this.board.addDisk(col);
                this.board.printBoard();
//                placeDisk(addedPos);
                if (this.board.getWinningIndexes() != null){
                    System.out.println("team " + this.board.getTeam() + " won!");
                    //flashWinners();
                    //endGame(true);
                }
            } else if (this.board.isFull()) {
//                endGame(false);
            }
        });
    }
}
