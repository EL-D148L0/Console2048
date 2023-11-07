package max.sander;

public class BoardPosition {
    private byte row;
    private byte column;

    public void setValue(byte value) {
        this.value = value;
    }
    public void setValue(int value) {
        this.value = Board.toByteValue(value);
    }

    private byte value;

    BoardPosition(int row, int column, int value) {
        this.row = (byte) row;
        this.column = (byte) column;
        this.value = Board.toByteValue(value);
    }
    public BoardPosition(byte row, byte column, byte value) {
        this.row = row;
        this.column = column;
        this.value = value;
    }

    public byte getRow() {
        return row;
    }

    public byte getColumn() {
        return column;
    }

    public byte getValue() {
        return value;
    }

    public BoardPosition(int row, int column) {
        this(row, column,0);
    }
}
