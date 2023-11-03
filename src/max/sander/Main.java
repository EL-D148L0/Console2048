package max.sander;

import io.webfolder.curses4j.Curses;

public class Main {

    public static void main(String[] args) {
        int[][] rows = new int[][] {
                {4, 2, 8, 2},
                {4, 0, 8, 2},
                {0, 16, 16, 2},
                {128, 0, 16, 2}    };
        Board board = Board.boardFromRows(rows);

        CursesPrinter.init();

        Game game = new Game();
        CursesPrinter.drawField(0, 0, game.board);
        Curses.refresh();
//        Curses.getch();
        game.startGame();

        while (!game.lost) {
            int ch = Curses.getch();
            if (ch == 81 || ch == 113) break;
            game.tryGameTurn(Util.getchToDir(ch));
        }


        Curses.refresh();
//        Curses.getch();

        Curses.endwin();
    }
}


