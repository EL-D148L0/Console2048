package max.sander;

import static io.webfolder.curses4j.Curses.*;

public class CursesPrinter {

    public CursesPrinter() {
        initscr();
        CursesColorInit.init();
    }
    private void drawBackground(int x, int y) {
        attrset(COLOR_PAIR(CursesColorInit.PAIR_BACKGROUND));
        drawString(x, y, CursesPrinterInfo.BACKGROUND);
    }
    void drawString(int x, int y, String str) {
        String[] strings = str.split("\n");
        for (int i = 0; i < strings.length; i++) {
            drawStringNoLinebreak(x, y + i, strings[i]);
        }
    }
    void drawField(int x, int y, Board board) {
        drawBackground(x, y);
        int[][] rows = board.getRows();
        for (int yb = 0; yb < 4; yb++) {
            for (int xb = 0; xb < 4; xb++) {
                drawTile(x+2+xb*19, y+ 1 +yb*10, rows[yb][xb]);
            }
        }

    }
    Board drawAnimatedFrame(int x, int y, int frameNumber, int framesTotal, Board board, int direction) {
        //layer them in the opposite direction of movement
        AnimationMap animationMap = new AnimationMap(board, direction);
        drawBackground(x, y);
        int[][] rows = board.getRows();
        if (direction == Constants.DIR_UP) {
            for (int yb = 3; yb > -1; yb--) {
                for (int xb = 0; xb < 4; xb++) {
                    double yAdd = 0;
                    double xAdd = 0;
                    if (animationMap.map[yb][xb][0] != -1) {
                        yAdd = animationMap.map[yb][xb][1] - yb;
                        xAdd = animationMap.map[yb][xb][0] - xb;

                        yAdd *= ((double) frameNumber / (double)framesTotal);
                        xAdd *= ((double) frameNumber / (double)framesTotal);

                    }
                    drawTile((int) (x+2+(xb + xAdd)*19), (int) (y+ 1 +(yb + yAdd)*10), rows[yb][xb]);
                }
            }
        }
        return animationMap.endBoard;

    }
    private void drawTile(int x, int y, int number) {
        if (number != 0) {
            int colorPair = CursesColorInit.PAIR_4096;
            if (CursesPrinterInfo.NUMBER_COLOR_PAIRS.containsKey(number)) {
                colorPair = CursesPrinterInfo.NUMBER_COLOR_PAIRS.get(number);
            }
            String image;
            if (CursesPrinterInfo.NUMBER_GRAPHICS.containsKey(number)) {
                image = CursesPrinterInfo.NUMBER_GRAPHICS.get(number);
            } else {
                image = "                 \n".repeat(4) + Util.centerString(Integer.toString(number), 17) + "\n" + "                 \n".repeat(4);
            }

            attrset(COLOR_PAIR(colorPair));
            drawString(x, y, image);
        }

    }
    private void drawStringNoLinebreak(int x, int y, String str) {
        //dont feed \n into this
        for (int i = 0; i < str.length(); i++) {
            move(y, x+i);
            delch();
            insch(str.charAt(i));
        }

    }
}
