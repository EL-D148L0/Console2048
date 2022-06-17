package max.sander;

import io.webfolder.curses4j.Window;

import static io.webfolder.curses4j.Curses.*;
import static io.webfolder.curses4j.Curses.addstr;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Printer printer = new Printer();
        int[][] rows = new int[][] {
                {2, 2, 0, 0},
                {2, 0, 0, 2},
                {0, 0, 0, 0},
                {0, 0, 2, 2}    };
        Board board = Board.boardFromRows(rows);
//        Board board = new Board(2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 0, 0);
//        Board board = new Board(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        
//        printer.drawGame(board);
//        printer.screen.print();
//        System.out.println();

        CursesPrinter cursesPrinter = new CursesPrinter();

        //cursesPrinter.drawBackground(0, 1);
        cursesPrinter.drawField(0, 0, board);
        
        refresh();
        getch();
        Board endboard = null;
        for (int i = 1; i < 7; i++) {
            endboard = cursesPrinter.drawAnimatedFrame(0, 0, i, 7, board, Constants.DIR_UP);
            refresh();

//            getch();
            napms(15);
        }
        cursesPrinter.drawField(0, 0, endboard);
        refresh();
        getch();

        endwin();
    }
}


