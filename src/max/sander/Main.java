package max.sander;

import io.webfolder.curses4j.Window;

import static io.webfolder.curses4j.Curses.*;
import static io.webfolder.curses4j.Curses.addstr;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Printer printer = new Printer();
        Board board = new Board(2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 0, 0);
        printer.drawGame(board);
        //printer.screen.print();
//        System.out.println();


        initscr();

        //addstr(printer.screen.getScreenString());
        start_color();
        int ok = init_color((short) 300, (short) 0, (short) 1000, (short) 0);
        int ok2 = init_pair(1, (short) 300, (short) 300);
        init_pair(2, COLOR_RED, COLOR_RED);

        attrset(COLOR_PAIR(1));
        addstr("#");
        //attrset(COLOR_PAIR(2));
        addstr("#");
        /*for (int i = 0; i < 256; i++) {
            init_pair(i, (short) 0, (short) (i + 256));
        }
        for (int i = 0; i < 256; i++) {
            attrset(COLOR_PAIR(i));
            addstr("#");
        }
        addstr(String.valueOf(COLORS()));*/

        refresh();



        getch();
        endwin();
    }
}


