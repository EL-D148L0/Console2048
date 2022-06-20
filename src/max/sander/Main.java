package max.sander;

import static io.webfolder.curses4j.Curses.*;

public class Main {

    public static void main(String[] args) {
	// write your code here

//        Printer printer = new Printer();
        int[][] rows = new int[][] {
                {4, 2, 8, 2},
                {4, 0, 8, 2},
                {0, 16, 16, 2},
                {128, 0, 16, 2}    };
        Board board = Board.boardFromRows(rows);
//        Board board = new Board(2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 0, 0);
//        Board board = new Board(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        
//        printer.drawGame(board);
//        printer.screen.print();
//        System.out.println();

        CursesPrinter.init();

        //cursesPrinter.drawBackground(0, 1);
//        CursesPrinter.drawField(0, 0, board);
        Game game = new Game();
        CursesPrinter.drawField(0, 0, game.board);
        refresh();
        getch();
        game.tryGameTurn(game.startGameMove());
//        getch();

        while (!game.lost) {
            int ch = getch();
            game.tryGameTurn(Util.getchToDir(ch));
        }


        /*
        Board endboard = null;
        AnimationMap animationMap = new AnimationMap(board, Constants.DIR_UP);
        animationMap.spawnNumber(new int[] {3, 3, 4});
        for (int i = 1; i <= 7; i++) {
            endboard = CursesPrinter.drawAnimatedFrame(0, 0, i, 7, board, animationMap);
            refresh();

            getch();
//            napms(15);
        }
        napms(45);
        CursesPrinter.drawField(0, 0, endboard);*/
        refresh();
        getch();

        endwin();
    }
}


