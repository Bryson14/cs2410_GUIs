package hw4_connectFour;

public class Board {
    private Column[] columns;
    private int[] lastAccessed;
    private int WIDTH;
    private int HEIGHT;

    private class Column {
        private int occupiedCells;
        private int[] diskList;

        Column(int height) {
            this.occupiedCells = 0;
            this.diskList = new int[height];
        }
    }
    Board() {
        this.WIDTH = 7;
        this.HEIGHT = 6;
        this.lastAccessed = new int[] {0,0}; //column, height from bottom
        this.columns = new Column[this.WIDTH];
        for (int i = 0; i < WIDTH; i++) {
            this.columns[i] = new Column(this.HEIGHT);
        }
    }

    Board(int width, int height) {
        this.WIDTH = width;
        this.HEIGHT = height;
        this.lastAccessed = new int[] {0,0}; //column, height from bottom
        this.columns = new Column[this.WIDTH];
        for (int i = 0; i < WIDTH; i++) {
            this.columns[i] = new Column(this.HEIGHT);
        }
    }

    public boolean canAddDisk(int column) {
        if (columns[column].occupiedCells < this.HEIGHT) return true;
        else return false;
    }

    public void addDisk(int column, int team) {
        int idx = columns[column].occupiedCells;
        columns[column].diskList[idx] = team; // add disk to the correct spot
        columns[column].occupiedCells++;
        this.lastAccessed[0] = column; //remember last accessed disk
        this.lastAccessed[1] = idx;
    }

    public void printBoard() {
        StringBuilder line = new StringBuilder();
        for (int k = 0; k < this.WIDTH; k++) {
            line.append("--");
        }
        line.append("---");
        System.out.println(line);
        for (int i = this.HEIGHT -1; i >= 0; i--) {
            System.out.print("| ");
            for (int j = 0; j < this.WIDTH; j ++) {
                System.out.printf("%s ", getSymbol(columns[j].diskList[i]));
            }
            System.out.println("|");
        }
        System.out.println(line);
    }
    private String getSymbol(int i){
        if (i == 0) return " ";
        else if (i == 1) return "X";
        else if (i == -1) return "O";
        else return "idk";
    }

//    public static void main(String[] args) {
//        Board b = new Board();
//        b.columns[0].diskList[0] = 1;
//        b.columns[5].diskList[0] = -1;
//        b.addDisk(3, 1);
//        b.addDisk(3, -1);
//        b.addDisk(3, 1);
//        b.addDisk(3, -1);
//        b.addDisk(3, 1);
//        b.addDisk(3, -1);
//        b.printBoard();
//        System.out.println(b.canAddDisk(3));
//    }
}
