package max.sander;

public class AnimationMap {
    Board startBoard;
    Board endBoard;
    int[][][] map;
    int[][] newNumberMap;
    int direction;
    boolean emptyMove = false;//must be externally set, doesnt get set automatically

    public AnimationMap(Board board, int direction) {
        this.direction = direction;
        this.newNumberMap = new int[][] { // map[y][x][xy]
                {-1, -1, -1, -1},
                {-1, -1, -1, -1},
                {-1, -1, -1, -1},
                {-1, -1, -1, -1}    };
        this.map = new int[][][] { // map[y][x][xy]
                {{-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}},
                {{-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}},
                {{-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}},
                {{-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}}    };
        this.startBoard = board;
        //Board tempBoard = board;
        if (direction == Constants.DIR_NONE) {
            this.endBoard = board;
            return;
        }
        if (direction == Constants.DIR_DOWN) {
            this.startBoard = this.startBoard.invertRows();
        }
        if (direction == Constants.DIR_RIGHT) {
            this.startBoard = this.startBoard.rotateLeft();
        }
        if (direction == Constants.DIR_LEFT) {
            this.startBoard = this.startBoard.rotateRight();
        }
        int[][] rows = startBoard.getRows();
        int[][] rowsNoAdd = startBoard.getRows();
        for (int x = 0; x < 4; x++) {
            for (int y = 1; y < 4; y++) {
                int currentNumber = rows[y][x];
                if (currentNumber == 0) {
                    continue;
                }
                int finalPos = y;
                boolean added = false;
                for (int y2 = y - 1; y2 > -1; y2--) {
                    if (rowsNoAdd[y2][x] == 0) {
                        finalPos = y2;
                        continue;
                    }
                    if (rowsNoAdd[y2][x] == currentNumber) {
                        //merge
                        finalPos = y2;
                        rows[y2][x] = currentNumber * 2;
                        newNumberMap[y2][x] = Constants.ANIM_MERGE;
                        rows[y][x] = 0;
                        rowsNoAdd[y2][x] = -1;
                        rowsNoAdd[y][x] = 0;
                        added = true;
                        break;
                    }

                    break;
                }/*
                    if (finalPos != y) {
                        map[y][x] = new int[] {x, finalPos};
                    }*/
                if (finalPos != y && !added) {
                    rows[y][x] = 0;
                    rows[finalPos][x] = currentNumber;
                    rowsNoAdd[y][x] = 0;
                    rowsNoAdd[finalPos][x] = currentNumber;
                }
                map[y][x] = new int[] {x, finalPos};
                //System.out.println(Arrays.deepToString(rows));
            }
        }
        this.endBoard = Board.boardFromRows(rows);

        if (direction == Constants.DIR_DOWN) {
            this.startBoard = this.startBoard.invertRows();
            this.endBoard = this.endBoard.invertRows();
            this.map = invertMapY(this.map);
            this.newNumberMap = Board.boardFromRows(newNumberMap).invertRows().getRows();
        }
        if (direction == Constants.DIR_RIGHT) {
            this.startBoard = this.startBoard.rotateRight();
            this.endBoard = this.endBoard.rotateRight();
            this.map = rotateMap(map);
            this.newNumberMap = Board.boardFromRows(newNumberMap).rotateRight().getRows();
        }
        if (direction == Constants.DIR_LEFT) {
            this.startBoard = this.startBoard.rotateLeft();
            this.endBoard = this.endBoard.rotateLeft();
            this.map = rotateMap(rotateMap(rotateMap(map)));
            this.newNumberMap = Board.boardFromRows(newNumberMap).rotateLeft().getRows();
        }
    }
    private static int[][][] invertMapY(int[][][] mapIn) {
        int[][][] newMap = new int[][][] {mapIn[3], mapIn[2], mapIn[1], mapIn[0]};

        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                newMap[y][x][1] = 3 - newMap[y][x][1];
            }
        }
        return newMap;
    }
    private static int[][][] rotateMap(int[][][] mapIn) {
        return new int[][][] {
                {{3 - mapIn[3][0][1],mapIn[3][0][0]},{3 - mapIn[2][0][1],mapIn[2][0][0]},{3 - mapIn[1][0][1],mapIn[1][0][0]},{3 - mapIn[0][0][1],mapIn[0][0][0]}},
                {{3 - mapIn[3][1][1],mapIn[3][1][0]},{3 - mapIn[2][1][1],mapIn[2][1][0]},{3 - mapIn[1][1][1],mapIn[1][1][0]},{3 - mapIn[0][1][1],mapIn[0][1][0]}},
                {{3 - mapIn[3][2][1],mapIn[3][2][0]},{3 - mapIn[2][2][1],mapIn[2][2][0]},{3 - mapIn[1][2][1],mapIn[1][2][0]},{3 - mapIn[0][2][1],mapIn[0][2][0]}},
                {{3 - mapIn[3][3][1],mapIn[3][3][0]},{3 - mapIn[2][3][1],mapIn[2][3][0]},{3 - mapIn[1][3][1],mapIn[1][3][0]},{3 - mapIn[0][3][1],mapIn[0][3][0]}}  };
    }
    public int[][][] getRows() {
        return map;
    }
    public void spawnNumber(int[] numberInfo) {
        int x = numberInfo[0];
        int y = numberInfo[1];
        int number = numberInfo[2];
        int[][] rows = endBoard.getRows();
        rows[y][x] = number;
        this.endBoard = Board.boardFromRows(rows);
        newNumberMap[y][x] = Constants.ANIM_SPAWN;
    }

}
