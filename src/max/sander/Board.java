package max.sander;

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
    public int[][] getRows() {
        return new int[][] {{r0c0, r0c1, r0c2, r0c3}, {r1c0, r1c1, r1c2, r1c3}, {r2c0, r2c1, r2c2, r2c3}, {r3c0, r3c1, r3c2, r3c3}};
    }
    public int[][] getColumns() {
        return new int[][] {{r0c0, r1c0, r2c0, r3c0}, {r0c1, r1c1, r2c1, r3c1}, {r0c2, r1c2, r2c2, r3c2}, {r0c3, r1c3, r2c3, r3c3}};
    }
}
