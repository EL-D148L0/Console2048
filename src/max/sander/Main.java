package max.sander;

import io.webfolder.curses4j.Curses;

import java.sql.Time;
import java.util.LinkedList;
import java.util.Random;
import java.util.Timer;

public class Main {

    public static void main(String[] args) {
        int[][] rows = new int[][] {
                {4, 2, 8, 2},
                {4, 0, 8, 2},
                {4, 16, 16, 2},
                {128, 0, 16, 2}    };

        int[][] rows2 = new int[][] {
                {8, 16, 8, 32},
                {64, 128, 1024, 8},
                {8, 16, 512, 32},
                {4, 2, 4, 4}    };

        int[][] rows3 = new int[][] {
                {0, 0, 0, 0},
                {0, 2, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}    };
        Board board = Board.boardFromRows(rows3);
        Board board2 = Board.boardFromRows(rows);
        //board = new Board();
//        System.out.println(board.equals(board2));
        Random random = new Random();
        CursesPrinter.init();

        Game game = new Game();
        CursesPrinter.drawField(0, 0, board);
        Curses.refresh();
//        Curses.getch();
        /*game.startGame();

        while (!game.lost) {
            int ch = Curses.getch();
            if (ch == 81 || ch == 113) break;
            game.tryGameTurn(Util.getchToDir(ch));
        }*/
        boolean done = false;
        int counter = 0;
        while (!done) {
            /*if (counter <1) {
                counter = 10;
                int ch = Curses.getch();
                if (ch == 81 || ch == 113) break;
            }
            counter--;*/
            Solver solver = new Solver(board);
            int move = solver.next();
            solver.destroyTree();
            System.out.println(move);
            System.out.println(board);
            if (move == Constants.DIR_NONE) break;
            Board newBoard = board.move(move);
            if (!newBoard.equals(board)) {
                board = newBoard;

                LinkedList<BoardPosition> freePositions = board.getFreePositions();
                BoardPosition newTile = freePositions.get(random.nextInt(freePositions.size()));
                newTile.setValue((random.nextDouble() < Constants.CHANCE_FOR_4) ? 4 : 2);
                board = board.setTile(newTile);
            }
            if (!board.canMove()) done = true;
            //System.out.println(board.canMove());
            CursesPrinter.drawField(0, 0, board);

            Curses.refresh();
            /*try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }*/
        }


        Curses.refresh();
        Curses.getch();

        Curses.endwin();
    }
}


