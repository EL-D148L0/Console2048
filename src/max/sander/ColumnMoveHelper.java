package max.sander;

import java.util.LinkedList;

public class ColumnMoveHelper {
    private LinkedList<Byte> column;
    private int scoreChange = 0;

    private byte[] byteArray;
    public ColumnMoveHelper(byte a, byte b, byte c, byte d) {
        column = new LinkedList<Byte>();
        if (a != 0) column.add(a);
        if (b != 0) column.add(b);
        if (c != 0) column.add(c);
        if (d != 0) column.add(d);
        merge();
        byteArray = toArray();
    }

    private void merge() {
        LinkedList<Byte> out = new LinkedList<Byte>();
        while (!column.isEmpty()) {
            byte first = column.pop();
            if (!column.isEmpty()) {
                if (first == column.peek()) {
                    out.add(++first);
                    scoreChange += Board.toIntValue(first);
                    column.pop();
                    continue;
                }
            }
            out.add(first);
        }
        column = out;
    }

    public byte[] getByteArray() {
        return byteArray;
    }

    private byte[] toArray() {
        byte[] out = new byte[4];
        for (int i = 0; i < 4; i++) {
            out[i] = column.isEmpty() ? 0 : column.pop();
        }
        return out;
    }

    public int getScoreChange() {
        return scoreChange;
    }
}
