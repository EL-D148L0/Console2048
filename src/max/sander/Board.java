package max.sander;

import java.util.Arrays;
import java.util.LinkedList;

public class Board {
    byte r0c0, r0c1, r0c2, r0c3, r1c0, r1c1, r1c2, r1c3, r2c0, r2c1, r2c2, r2c3, r3c0, r3c1, r3c2, r3c3 = 0;
    int score = 0;    

    private Board(byte r0c0, byte r0c1, byte r0c2, byte r0c3, byte r1c0, byte r1c1, byte r1c2, byte r1c3, byte r2c0, byte r2c1, byte r2c2, byte r2c3, byte r3c0, byte r3c1, byte r3c2, byte r3c3, int score) {
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
        this.score = score;
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
        return getFreePositions().size();
    }
    public boolean hasFreeTiles() {
        return countFreeTiles()>0;
    }

    public Board move(int direction) {
        if (direction == Constants.DIR_UP) return moveUp();
        if (direction == Constants.DIR_DOWN) return moveDown();
        if (direction == Constants.DIR_LEFT) return moveLeft();
        if (direction == Constants.DIR_RIGHT) return moveRight();
        return this;
    }
    public boolean canMove(int direction) {
        return !this.equals(move(direction));
    }
    public boolean canMove() {
        return canMove(Constants.DIR_UP) || canMove(Constants.DIR_LEFT) || canMove(Constants.DIR_RIGHT) || canMove(Constants.DIR_DOWN);
    }
    private Board moveUp() {
        ColumnMoveHelper column0 = new ColumnMoveHelper(r0c0, r1c0, r2c0, r3c0);
        ColumnMoveHelper column1 = new ColumnMoveHelper(r0c1, r1c1, r2c1, r3c1);
        ColumnMoveHelper column2 = new ColumnMoveHelper(r0c2, r1c2, r2c2, r3c2);
        ColumnMoveHelper column3 = new ColumnMoveHelper(r0c3, r1c3, r2c3, r3c3);
        return new Board(
                column0.getByteArray()[0], column1.getByteArray()[0], column2.getByteArray()[0], column3.getByteArray()[0],
                column0.getByteArray()[1], column1.getByteArray()[1], column2.getByteArray()[1], column3.getByteArray()[1],
                column0.getByteArray()[2], column1.getByteArray()[2], column2.getByteArray()[2], column3.getByteArray()[2],
                column0.getByteArray()[3], column1.getByteArray()[3], column2.getByteArray()[3], column3.getByteArray()[3],
                score + column0.getScoreChange() + column1.getScoreChange() + column2.getScoreChange() + column3.getScoreChange());
    }
    private Board moveRight() {
        return rotateLeft().moveUp().rotateRight();
    }
    private Board moveDown() {
        return invertRows().moveUp().invertRows();
    }
    private Board moveLeft() {
        return rotateRight().moveUp().rotateLeft();
    }

    private LinkedList<Byte> makeByteListIgnoringZeroes(byte a, byte b, byte c, byte d) {
        LinkedList<Byte> column = new LinkedList<Byte>();
        if (a != 0) column.add(a);
        if (b != 0) column.add(b);
        if (c != 0) column.add(c);
        if (d != 0) column.add(d);
        return column;
    }
    private LinkedList<Byte> mergeNumbersInList(LinkedList<Byte> column) {
        LinkedList<Byte> out = new LinkedList<Byte>();
        while (!column.isEmpty()) {
            byte first = column.pop();
            if (!column.isEmpty()) {
                if (first == column.peek()) {
                    out.add(++first);
                    column.pop();
                    continue;
                }
            }
            out.add(first);
        }
        return out;
    }
    private byte[] listToArray(LinkedList<Byte> list) {
        byte[] out = new byte[4];
        for (int i = 0; i < 4; i++) {
            out[i] = list.isEmpty() ? 0 : list.pop();
        }
        return out;
    }

    public int[][] getRows() {
        return new int[][] {{toIntValue(r0c0), toIntValue(r0c1), toIntValue(r0c2), toIntValue(r0c3)}, {toIntValue(r1c0), toIntValue(r1c1), toIntValue(r1c2), toIntValue(r1c3)}, {toIntValue(r2c0), toIntValue(r2c1), toIntValue(r2c2), toIntValue(r2c3)}, {toIntValue(r3c0), toIntValue(r3c1), toIntValue(r3c2), toIntValue(r3c3)}};
    }

    private byte[][] getRowsAsByteArrays() {
        return new byte[][] {{r0c0, r0c1, r0c2, r0c3}, {r1c0, r1c1, r1c2, r1c3}, {r2c0, r2c1, r2c2, r2c3}, {r3c0, r3c1, r3c2, r3c3}};
    }
    public static int toIntValue(byte b) {
        if (b == 0) return 0;
        return (int) Math.pow(2, b);
    }
    public static byte toByteValue(int i) {
        if (i == 0) return 0;
        return (byte) (int) (Math.log(i)/Math.log(2));
    }

    public LinkedList<BoardPosition> getFreePositions() {

        LinkedList<BoardPosition> list = new LinkedList<>();
        byte[][] rows = this.getRowsAsByteArrays();
        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 4; c++) {
                if (rows[r][c] == 0) list.add(new BoardPosition(r,c));
            }
        }
        return list;
    }

    @Override
    public String toString() {
        int[][] rows = getRows();
        String out = String.format("%s%n%s%n%s%n%s", Arrays.toString(rows[0]), Arrays.toString(rows[1]), Arrays.toString(rows[2]), Arrays.toString(rows[3]));

        return out;
    }

    public Board setTile(BoardPosition boardPosition) {
        byte[][] bytes = getRowsAsByteArrays();
        bytes[boardPosition.getRow()][boardPosition.getColumn()] = boardPosition.getValue();
        return  boardFromRowsAsBytes(bytes, score);
    }

    public Board rotateRight() {
        return new Board(
                r3c0, r2c0, r1c0, r0c0,
                r3c1, r2c1, r1c1, r0c1,
                r3c2, r2c2, r1c2, r0c2,
                r3c3, r2c3, r1c3, r0c3,
                score);
    }

    public Board rotateLeft() {
        return new Board(
                r0c3, r1c3, r2c3, r3c3,
                r0c2, r1c2, r2c2, r3c2,
                r0c1, r1c1, r2c1, r3c1,
                r0c0, r1c0, r2c0, r3c0,
                score);
    }
    public Board invertRows() {
        return new Board(
                r3c0, r3c1, r3c2, r3c3,
                r2c0, r2c1, r2c2, r2c3,
                r1c0, r1c1, r1c2, r1c3,
                r0c0, r0c1, r0c2, r0c3,
                score);
    }
    public static Board boardFromRows(int[][] rows){
        return new Board(
                toByteValue(rows[0][0]), toByteValue(rows[0][1]), toByteValue(rows[0][2]), toByteValue(rows[0][3]),
                toByteValue(rows[1][0]), toByteValue(rows[1][1]), toByteValue(rows[1][2]), toByteValue(rows[1][3]),
                toByteValue(rows[2][0]), toByteValue(rows[2][1]), toByteValue(rows[2][2]), toByteValue(rows[2][3]),
                toByteValue(rows[3][0]), toByteValue(rows[3][1]), toByteValue(rows[3][2]), toByteValue(rows[3][3]),
                0);
    }
    private static Board boardFromRowsAsBytes(byte[][] rows, int score) {
        return new Board(
                rows[0][0], rows[0][1], rows[0][2], rows[0][3],
                rows[1][0], rows[1][1], rows[1][2], rows[1][3],
                rows[2][0], rows[2][1], rows[2][2], rows[2][3],
                rows[3][0], rows[3][1], rows[3][2], rows[3][3],
                score);
    }
    public int[][] getColumns() {
        return new int[][] {{toIntValue(r0c0), toIntValue(r1c0), toIntValue(r2c0), toIntValue(r3c0)}, {toIntValue(r0c1), toIntValue(r1c1), toIntValue(r2c1), toIntValue(r3c1)}, {toIntValue(r0c2), toIntValue(r1c2), toIntValue(r2c2), toIntValue(r3c2)}, {toIntValue(r0c3), toIntValue(r1c3), toIntValue(r2c3), toIntValue(r3c3)}};
    }

}
