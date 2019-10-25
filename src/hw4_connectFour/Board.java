package hw4_connectFour;

public class Board {
    private Column[] columns;
    private int[] lastAccessed;

    private class Column {
        private int HEIGHT;
        private int occupiedCells;
        private int[] diskList;

        Column() {
            this.HEIGHT = 6;
            this.occupiedCells = 0;
            this.diskList = new int[6];
        }
    }
    Board() {
        int WIDTH = 7;
        this.lastAccessed = new int[] {0,0}; //column, height from bottom
        this.columns = new Column[7];
        for (int i = 0; i < WIDTH; i++) {
            this.columns[i] = new Column();
        }
    }

    public void printBoard() {
        System.out.println("-----------------");
        for (int i = 0; i < 6; i++) {
            System.out.print("| ");
            for (int j = 0; j < 7; j ++) {
                System.out.printf("%s ", getSymbol(columns[j].diskList[i]));
            }
            System.out.println("|");
        }
        System.out.println("-----------------");
    }
    private String getSymbol(int i){
        if (i == 0) return " ";
        else if (i == 1) return "X";
        else if (i == -1) return "O";
        else return "idk";
    }

    public static void main(String[] args) {
        Board b = new Board();
        b.columns[0].diskList[0] = 1;
        b.printBoard();
    }
}
