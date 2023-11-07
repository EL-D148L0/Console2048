package max.sander;

import io.webfolder.curses4j.Curses;

import java.util.LinkedList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int[][] rows = new int[][] {
                {4, 2, 8, 2},
                {4, 0, 8, 2},
                {4, 16, 16, 2},
                {128, 0, 16, 2}    };

        int[][] rows2 = new int[][] {
                {4, 2, 8, 2},
                {2, 4, 2, 16},
                {4, 2, 16, 2},
                {2, 16, 8, 2}    };
        Board board = Board.boardFromRows(rows);
        Board board2 = Board.boardFromRows(rows);
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
        while (!done) {
            int ch = Curses.getch();
            if (ch == 81 || ch == 113) break;
            Solver solver = new Solver(board);
            int move = solver.next();
            solver.destroyTree();
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
        }


        Curses.refresh();
        Curses.getch();

        Curses.endwin();
    }
}


