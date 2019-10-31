package hw4_connectFour;

public class Board {
    private Column[] columns;
    private int[] lastAccessed;
    private int WIDTH;
    private int HEIGHT;
    private int totalDisks;
    private int team;

    private class Column {
        private int occupiedCells;
        private int[] diskList;

        Column(int height) {
            this.occupiedCells = 0;
            this.diskList = new int[height];
        }
    }

    Board() {
        this(7,6);
    }

    Board(int width, int height) {
        this.totalDisks = 0;
        this.WIDTH = width;
        this.HEIGHT = height;
        this.team = 1;
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

    public String addDisk(int column) {
        int idx = columns[column].occupiedCells;
        columns[column].diskList[idx] = this.team; // add disk to the correct spot
        this.team = this.team == 1? -1 : 1;
        columns[column].occupiedCells++;
        this.totalDisks++;
        this.lastAccessed[0] = column; //remember last accessed disk
        this.lastAccessed[1] = idx;
        return "" + column + idx;
    }

    public int getTeam() {
        return team;
    }

    public boolean isFull() {
        if (this.totalDisks >= this.WIDTH*this.HEIGHT) return true;
        else return false;
    }

    public void printBoard() {
        StringBuilder line = new StringBuilder("---");
        for (int k = 0; k < this.WIDTH; k++) {
            line.append("--");
        }
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

    /**
     * returns the indexes of the 4 in-a-row disks
     * @return String of positions (column, row)
     */
    public String[] getWinningIndexes() {
        String[] idxs;

        for (int i = 0; i < this.HEIGHT; i++) {
            for (int j = 0; j < this.WIDTH; j++) {
                if (columns[j].diskList[i] != 0) { //a piece is there
                    idxs = findIndexes(j, i);

                    if (idxs != null) return idxs;
                }
            }
        } return null;
    }

    /*
    only need to treat passed in spot as the end to avoid trying all 16 possible combinations on all 42 spots.
     */
    private String[] findIndexes(int column, int row){
        int team = columns[column].diskList[row];
        String[] indexes = new String[4];
        indexes[0] = ""+ column + row;

        if (column + 3 < this.WIDTH) { //horizontal
            if (columns[column].diskList[row] == team &&
                    columns[column + 1].diskList[row] ==  team &&
                    columns[column + 2].diskList[row] == team &&
                    columns[column + 3].diskList[row] == team) {


                indexes[1] = "" + (column + 1) + row;
                indexes[2] = "" + (column + 2) + row;
                indexes[3] = "" + (column + 3) + row;
                return indexes;
            }
        } if (row + 3 < this.HEIGHT) { //vertical
            int[] l = columns[column].diskList;
            if (l[row] == team && l[row + 1] == team && l[row + 2] == team && l[row + 3] == team ) {

                indexes[1] = "" + column + (row + 1);
                indexes[2] = "" + column + (row + 2);
                indexes[3] = "" + column + (row + 3);
                return indexes;
            }

        } if (row + 3 < this.HEIGHT && column + 3 < this.WIDTH) { // /
            if (columns[column].diskList[row] == team &&
                    columns[column + 1].diskList[row + 1] ==  team &&
                    columns[column + 2].diskList[row + 2] == team &&
                    columns[column + 3].diskList[row + 3] == team) {


                indexes[1] = "" + (column + 1) + (row + 1);
                indexes[2] = "" + (column + 2) + (row + 2);
                indexes[3] = "" + (column + 3) + (row + 3);
                return indexes;
            }
        } if (row + 3 < this.HEIGHT && column - 3 >= 0) { // \
            if (columns[column].diskList[row] == team &&
                    columns[column - 1].diskList[row + 1] ==  team &&
                    columns[column - 2].diskList[row + 2] == team &&
                    columns[column - 3].diskList[row + 3] == team) {


                indexes[1] = "" + (column - 1) + (row + 1);
                indexes[2] = "" + (column - 2) + (row + 2);
                indexes[3] = "" + (column - 3) + (row + 3);
                return indexes;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Board b = new Board();
        b.addDisk(0);
        b.addDisk(0);
        b.addDisk(0);
        b.addDisk(0);
        b.printBoard();
        System.out.println(b.canAddDisk(3));
        System.out.println(b.getWinningIndexes());
    }
}
