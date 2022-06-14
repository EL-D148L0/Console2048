package max.sander;

public class AnimationMap {
    Board startBoard;
    Board endBoard;
    int[][][] map;

    public AnimationMap(Board board, int direction) {

        this.map = new int[][][] { // map[y][x][xy]
                {{-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}},
                {{-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}},
                {{-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}},
                {{-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}}    };
        this.startBoard = board;
        //Board tempBoard = board;
        if (direction == Constants.DIR_UP) {
            int[][] rows = startBoard.getRows();
            for (int x = 0; x < 4; x++) {
                for (int y = 1; y < 4; y++) {
                    int currentNumber = rows[y][x];
                    if (currentNumber == 0) {
                        continue;
                    }
                    int finalPos = y;
                    for (int y2 = y - 1; y2 > -1; y2--) {
                        if (rows[y2][x] == 0) {
                            finalPos = y2;
                            continue;
                        }
                        if (rows[y2][x] == currentNumber) {
                            finalPos = y2;
                            rows[y2][x] = currentNumber * 2;
                            rows[y][x] = 0;
                            break;
                        }
                        if (finalPos != y) {
                            rows[y][x] = 0;
                            rows[finalPos][x] = currentNumber;
                        }
                        break;
                    }
                    if (finalPos != y) {
                        map[y][x] = new int[] {x, finalPos};
                    }
                }
            }
            this.endBoard = Board.boardFromRows(rows);
        }
    }
    public int[][][] getRows() {
        return map;
    }
    /*public int[][] getColumns() {
        return new int[][] {{r0c0, r1c0, r2c0, r3c0}, {r0c1, r1c1, r2c1, r3c1}, {r0c2, r1c2, r2c2, r3c2}, {r0c3, r1c3, r2c3, r3c3}};
    }*/
}