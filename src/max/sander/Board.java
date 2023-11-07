package max.sander;

public class Board {
    byte r0c0, r0c1, r0c2, r0c3, r1c0, r1c1, r1c2, r1c3, r2c0, r2c1, r2c2, r2c3, r3c0, r3c1, r3c2, r3c3 = 0;

    private Board(byte r0c0, byte r0c1, byte r0c2, byte r0c3, byte r1c0, byte r1c1, byte r1c2, byte r1c3, byte r2c0, byte r2c1, byte r2c2, byte r2c3, byte r3c0, byte r3c1, byte r3c2, byte r3c3) {
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
    
    public Board() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Board board = (Board) o;
        return r0c0 == board.r0c0 && r0c1 == board.r0c1 && r0c2 == board.r0c2 && r0c3 == board.r0c3 &&
                r1c0 == board.r1c0 && r1c1 == board.r1c1 && r1c2 == board.r1c2 && r1c3 == board.r1c3 &&
                r2c0 == board.r2c0 && r2c1 == board.r2c1 && r2c2 == board.r2c2 && r2c3 == board.r2c3 &&
                r3c0 == board.r3c0 && r3c1 == board.r3c1 && r3c2 == board.r3c2 && r3c3 == board.r3c3;
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
        return new int[][] {{toIntValue(r0c0), toIntValue(r0c1), toIntValue(r0c2), toIntValue(r0c3)}, {toIntValue(r1c0), toIntValue(r1c1), toIntValue(r1c2), toIntValue(r1c3)}, {toIntValue(r2c0), toIntValue(r2c1), toIntValue(r2c2), toIntValue(r2c3)}, {toIntValue(r3c0), toIntValue(r3c1), toIntValue(r3c2), toIntValue(r3c3)}};
    }
    private static int toIntValue(byte b) {
        if (b == 0) return 0;
        return (int) Math.pow(2, b);
    }
    private static byte toByteValue(int i) {
        if (i == 0) return 0;
        return (byte) (int) (Math.log(i)/Math.log(2));
    }

    public Board rotateRight() {
        return new Board(
                r3c0, r2c0, r1c0, r0c0,
                r3c1, r2c1, r1c1, r0c1,
                r3c2, r2c2, r1c2, r0c2,
                r3c3, r2c3, r1c3, r0c3);
    }

    public Board rotateLeft() {
        return new Board(
                r0c3, r1c3, r2c3, r3c3,
                r0c2, r1c2, r2c2, r3c2,
                r0c1, r1c1, r2c1, r3c1,
                r0c0, r1c0, r2c0, r3c0);
    }
    public Board invertRows() {
        return new Board(
                r3c0, r3c1, r3c2, r3c3,
                r2c0, r2c1, r2c2, r2c3,
                r1c0, r1c1, r1c2, r1c3,
                r0c0, r0c1, r0c2, r0c3);
    }
    public static Board boardFromRows(int[][] rows){
        return new Board(toByteValue(rows[0][0]), toByteValue(rows[0][1]), toByteValue(rows[0][2]), toByteValue(rows[0][3]), toByteValue(rows[1][0]), toByteValue(rows[1][1]), toByteValue(rows[1][2]), toByteValue(rows[1][3]), toByteValue(rows[2][0]), toByteValue(rows[2][1]), toByteValue(rows[2][2]), toByteValue(rows[2][3]), toByteValue(rows[3][0]), toByteValue(rows[3][1]), toByteValue(rows[3][2]), toByteValue(rows[3][3]));
    }
    public int[][] getColumns() {
        return new int[][] {{toIntValue(r0c0), toIntValue(r1c0), toIntValue(r2c0), toIntValue(r3c0)}, {toIntValue(r0c1), toIntValue(r1c1), toIntValue(r2c1), toIntValue(r3c1)}, {toIntValue(r0c2), toIntValue(r1c2), toIntValue(r2c2), toIntValue(r3c2)}, {toIntValue(r0c3), toIntValue(r1c3), toIntValue(r2c3), toIntValue(r3c3)}};
    }

}
