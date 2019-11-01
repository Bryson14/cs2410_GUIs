package hw4_connectFour;

import javafx.animation.FillTransition;
import javafx.animation.PathTransition;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
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
    private Color currColor;
    private Color nullColor;        // color for a empty spot
    private int team;               // 2, 1 place holder for team

    public ConnectFourPane() {
        this(7,6);
    }

    ConnectFourPane(int width, int height) {
        this.HEIGHT = height;
        this.WIDTH = width;
        team1Color = Color.RED;
        team2Color = Color.YELLOW;
        nullColor = Color.LIGHTGREY;
        team = 1;
        currColor = team1Color;
        rad = 30;
        gap = 7;
        this.bottomPane = new GridPane();
        this.middlePane = new Pane();
        this.basePane = new StackPane();
        this.basePane.setPadding(new Insets(15,15,15,15));
        basePane.setStyle("-fx-background-color: #3f7dc7"); //skyblue
        this.board = new Board(this.WIDTH, this.HEIGHT);
        newGame();
    }

    /**
     * gridpane of gray circles for background and position reference
     */
    private void grayCircles() {
        this.bottomPane.setHgap(gap*4);
        this.bottomPane.setVgap(gap);

        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                this.bottomPane.add(new Circle(rad, this.nullColor), i, j);
            }
        } this.basePane.getChildren().add(this.bottomPane);
    }

    /**
     * Places an animated dropping disk
     * @param addedPos (col, row) position added by Board
     */
    private void placeDisk(String addedPos) {
        int col = Character.getNumericValue(addedPos.charAt(0));
        int row = this.HEIGHT - 1 - Character.getNumericValue(addedPos.charAt(1));
        Node endNode = getNodeIndex(row, col, this.bottomPane);
        team = this.board.getTeam();

        if (team == 1) currColor = team1Color;
        else currColor = team2Color;

        Circle cir = new Circle(this.rad, currColor);
        this.middlePane.getChildren().add(cir);
        PathTransition pt = new PathTransition(Duration.millis(800), new Line(endNode.getLayoutX(), 0,
                endNode.getLayoutX(), endNode.getLayoutY()), cir);
        pt.setCycleCount(1);
        pt.play();

        if (this.board.isFull()) {
            endGame(false);
        }
    }

    /**
     * Returns the node at [column, row] in a gridPane
     * @param row int
     * @param column int
     * @param gridPane gridpane to search through
     * @return Node at desired index in gridPane
     */
    private Node getNodeIndex (int row, int column, GridPane gridPane) {
        Node result = null;
        ObservableList<Node> childrens = gridPane.getChildren();

        for (Node node : childrens) {
            if(gridPane.getRowIndex(node) == row && gridPane.getColumnIndex(node) == column) {
                result = node;
                break;
            }
        } return result;
    }

    /**
     * adds four flashing disks on the winning spots
     */
    private void flashWinners() {
        String[] winners = this.board.getWinningIndexes();
        for (String pos: winners) {
            int col = Character.getNumericValue(pos.charAt(0));
            int row = this.HEIGHT - 1 - Character.getNumericValue(pos.charAt(1));
            Node node = getNodeIndex(row, col, bottomPane);
            Circle cir = new Circle(node.getLayoutX(), node.getLayoutY(), this.rad);
            this.middlePane.getChildren().add(cir);

            FillTransition ft = new FillTransition(Duration.millis(500), cir, this.nullColor, currColor);
            ft.setCycleCount(20);
            ft.play();
        }
    }

    /**
     * adds new window at end to close or restart game
     * @param winnerExist if false, the board is filled with no winner
     */
    private void endGame(boolean winnerExist) {
        VBox window = new VBox(gap * 2);
        window.setStyle("-fx-background-color: #f0ddd6");
        window.setMinWidth(200);
        window.setMinHeight(150);
        window.setAlignment(Pos.CENTER);
        Text playAgain = new Text("Do you want to play again?");
        playAgain.setFont(Font.font(32));
        Button yes = new Button("Yes");
        yes.setStyle("-fx-font-size: 22px");
        yes.setOnAction(e->{
            getChildren().clear();
            newGame();

        });
        Button no = new Button("No");
        no.setStyle("-fx-font-size: 22px");
        no.setOnAction(e->{
            System.exit(1);
        });
        HBox buttons = new HBox(gap * 2,yes,no);
        buttons.setAlignment(Pos.CENTER);

        if (winnerExist) {
            Text winMessage = new Text("TEAM " + team + " WINS!");
            winMessage.setFont(Font.font(32));
            window.getChildren().addAll(winMessage, playAgain, buttons);
//            this.basePane.getChildren().add(window);

        } else {
            Text uSuck = new Text("Ur bad at this. \nWin before the board fills up!");
            uSuck.setFont(Font.font(32));
            window.getChildren().addAll(uSuck, playAgain, buttons);
            this.basePane.getChildren().add(window);
        }
    }

    /**
     * sets up the different layers and logic of a connect four board
     */
    void newGame() {
        grayCircles();
        basePane.getChildren().add(this.middlePane);
        //rectangleCutout(); //TODO add this if i got time
        getChildren().add(basePane);

        basePane.setOnMouseClicked(event -> {
            int col = ((int)(event.getX())/(int)(basePane.getWidth()/this.WIDTH));
            if (this.board.canAddDisk(col)) {
                String addedPos = this.board.addDisk(col);
                this.board.printBoard();
                placeDisk(addedPos);
                if (this.board.getWinningIndexes() != null){
                    flashWinners();
                    endGame(true);
                }
            }
        });
    }
}
