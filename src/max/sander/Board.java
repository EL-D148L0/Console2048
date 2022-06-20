package max.sander;

import java.util.Objects;

public class Board {
    int r0c0;
    int r0c1;
    int r0c2;
    int r0c3;

    int r1c0;
    int r1c1;
    int r1c2;
    int r1c3;

    int r2c0;
    int r2c1;
    int r2c2;
    int r2c3;

    int r3c0;
    int r3c1;
    int r3c2;
    int r3c3;

    public Board(int r0c0, int r0c1, int r0c2, int r0c3, int r1c0, int r1c1, int r1c2, int r1c3, int r2c0, int r2c1, int r2c2, int r2c3, int r3c0, int r3c1, int r3c2, int r3c3) {
        this.r0c0 = r0c0;
        this.r0c1 = r0c1;
        this.r0c2 = r0c2;
        this.r0c3 = r0c3;
        this.r1c0 = r1c0;
        this.r1c1 = r1c1;
        this.r1c2 = r1c2;
        this.r1c3 = r1c3;
        this.r2c0 = r2c0;
        this.r2c1 = r2c1;
        this.r2c2 = r2c2;
        this.r2c3 = r2c3;
        this.r3c0 = r3c0;
        this.r3c1 = r3c1;
        this.r3c2 = r3c2;
        this.r3c3 = r3c3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Board board = (Board) o;
        return r0c0 == board.r0c0 && r0c1 == board.r0c1 && r0c2 == board.r0c2 && r0c3 == board.r0c3 && r1c0 == board.r1c0 && r1c1 == board.r1c1 && r1c2 == board.r1c2 && r1c3 == board.r1c3 && r2c0 == board.r2c0 && r2c1 == board.r2c1 && r2c2 == board.r2c2 && r2c3 == board.r2c3 && r3c0 == board.r3c0 && r3c1 == board.r3c1 && r3c2 == board.r3c2 && r3c3 == board.r3c3;
    }
    public int countFreeTiles() {
        int count = 0;
        int[][] rows = this.getRows();
        for (int[] row: rows) {
            for (int number: row) {
                if (number == 0) {
                    count += 1;
                }
            }
        }
        return count;
    }


    public int[][] getRows() {
        return new int[][] {{r0c0, r0c1, r0c2, r0c3}, {r1c0, r1c1, r1c2, r1c3}, {r2c0, r2c1, r2c2, r2c3}, {r3c0, r3c1, r3c2, r3c3}};
    }
    public Board rotate() {
        return boardFromRows(this.invertRows().getColumns());
    }
    public Board invertRows() {
        int[][] oldRows = this.getRows();
        return boardFromRows(new int[][] {oldRows[3], oldRows[2], oldRows[1], oldRows[0]});
    }
    public static Board boardFromRows(int[][] rows){
        return new Board(rows[0][0], rows[0][1], rows[0][2], rows[0][3], rows[1][0], rows[1][1], rows[1][2], rows[1][3], rows[2][0], rows[2][1], rows[2][2], rows[2][3], rows[3][0], rows[3][1], rows[3][2], rows[3][3]);
    }
    public int[][] getColumns() {
        return new int[][] {{r0c0, r1c0, r2c0, r3c0}, {r0c1, r1c1, r2c1, r3c1}, {r0c2, r1c2, r2c2, r3c2}, {r0c3, r1c3, r2c3, r3c3}};
    }

}
