package max.sander;

import java.util.Arrays;
import java.util.Random;

import static io.webfolder.curses4j.Curses.*;

public class Game {
    Board board;
    boolean lost;

    public Game(Board board) {
        this.board = board;
        lost = false;
    }
    public Game() {
        this.board = new Board(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        lost = false;
    }

    private void playAnimationMap(AnimationMap animationMap) {
        for (int i = 1; i <= 7; i++) {
            CursesPrinter.drawAnimatedFrame(0, 0, i, 7, animationMap);
            refresh();

//            getch();
            napms(15);
        }
        napms(45);
        this.board = animationMap.endBoard;
        CursesPrinter.drawField(0, 0, board);
        refresh();
    }
    public void tryGameTurn(int dir) {
        if (dir == Constants.DIR_NONE) return;
        tryGameTurn(move(dir));
    }
    public void tryGameTurn(AnimationMap animationMap) {
        if (animationMap.emptyMove) return;
        if (animationMap.direction != Constants.DIR_NONE) {
            try {
                animationMap.spawnNumber(getNewTile(animationMap.endBoard));
            } catch (BadGameLogicException e) {
                throw new RuntimeException(e);
            }
        }
        playAnimationMap(animationMap);
    }
    public AnimationMap startGameMove() {
        AnimationMap animationMap = new AnimationMap(board, Constants.DIR_NONE);
        try {
            animationMap.spawnNumber(getNewTile(animationMap.endBoard));
            animationMap.spawnNumber(getNewTile(animationMap.endBoard));
        } catch (BadGameLogicException e) {
            throw new RuntimeException(e);
        }
        return animationMap;
    }
    public AnimationMap move(int dir) {
        // does not set new tiles
        AnimationMap animationMap = new AnimationMap(board, dir);
        if (board.equals(animationMap.endBoard)) {
            animationMap.emptyMove = true;
        }

        return animationMap;
    }
    private int[] getNewTile(Board board1) throws BadGameLogicException {
        //returns [x, y, number]
        //does not modify the board
        //AnimationMap should get a function to add extra features such as spawning tiles
        int count = board1.countFreeTiles();
        if (count == 0) throw new BadGameLogicException("trying to spawn new tiles without space");
        Random random = new Random();
        int pick = random.nextInt(count);
        int x = -1;
        int y = -1;
        int[][] rows = board1.getRows();
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


}
