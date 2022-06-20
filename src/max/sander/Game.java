package max.sander;

import java.util.Random;

public class Game {
    Board board;

    public Game(Board board) {
        this.board = board;
    }
    public Game() {
        this.board = new Board(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    }
    private int[] getNewTile() throws BadGameLogicException {
        //returns [x, y, number]
        //does not modify the board
        //AnimationMap should get a function to add extra features such as spawning tiles
        int count = countFreeTiles();
        if (count == 0) throw new BadGameLogicException("trying to spawn new tiles without space");
        Random random = new Random();
        int pick = random.nextInt(count);
        int x = -1;
        int y = -1;
        int[][] rows = this.board.getRows();
        int count2 = 0;
        int number = 2;
        for (int yb = 0; yb < 4; yb++) {
            for (int xb = 0; xb < 4; xb++) {
                if (rows[yb][xb] == 0) {
                    if (pick == count2) {
                        x = xb;
                        y = yb;
                        if (random.nextInt(10) == 0) {
                            number = 4;
                        }
                        break;
                    }

                    count2 += 1;
                }
            }
        }
        return new int[] {x, y, number};
    }

    private int countFreeTiles() {
        int count = 0;
        int[][] rows = this.board.getRows();
        for (int[] row: rows) {
            for (int number: row) {
                if (number == 0) {
                    count += 1;
                }
            }
        }
        return count;
    }
}
