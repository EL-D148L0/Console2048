package max.sander;

import io.webfolder.curses4j.Window;

import static io.webfolder.curses4j.Curses.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        /*
        Printer printer = new Printer();
        Board board = new Board(2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 0, 0);
        printer.drawGame(board);
        printer.screen.print();
//        System.out.println();
        */

        initscr();

        Window win1 = newwin(9, 9, 1, 1);


        getch();

        endwin();
    }
}


