package max.sander;

import static io.webfolder.curses4j.Curses.*;

public class CursesPrinter {

    public static void init() {
        initscr();
        CursesColorInit.init();
    }
    private static void drawBackground(int x, int y) {
        attrset(COLOR_PAIR(CursesColorInit.PAIR_BACKGROUND));
        drawString(x, y, CursesPrinterInfo.BACKGROUND);
    }
    static void drawString(int x, int y, String str) {
        String[] strings = str.split("\n");
        for (int i = 0; i < strings.length; i++) {
            drawStringNoLinebreak(x, y + i, strings[i]);
        }
    }
    static void drawStringSkipChar(int x, int y, String str, char skipChar) {
        String[] strings = str.split("\n");
        for (int i = 0; i < strings.length; i++) {
            drawStringNoLinebreakSkipChar(x, y + i, strings[i], skipChar);
        }
    }
    static void drawField(int x, int y, Board board) {
        drawBackground(x, y);
        int[][] rows = board.getRows();
        for (int yb = 0; yb < 4; yb++) {
            for (int xb = 0; xb < 4; xb++) {
                drawTile(x+2+xb*19, y+ 1 +yb*10, rows[yb][xb]);
            }
        }

    }
    static Board drawAnimatedFrame(int x, int y, int frameNumber, int framesTotal, AnimationMap animationMap) {
        //layer them in the opposite direction of movement
        drawBackground(x, y);
        int[][] rows = animationMap.startBoard.getRows();
        if (animationMap.direction == Constants.DIR_UP || animationMap.direction == Constants.DIR_RIGHT || animationMap.direction == Constants.DIR_NONE) {
            for (int yb = 3; yb > -1; yb--) {
                for (int xb = 0; xb < 4; xb++) {
                    drawTileFromAnimationMap(x, y, (double) frameNumber, (double) framesTotal, animationMap, rows, yb, xb);
                }
            }
        } else if (animationMap.direction == Constants.DIR_DOWN || animationMap.direction == Constants.DIR_LEFT) {
            for (int yb = 0; yb < 4; yb++) {
                for (int xb = 3; xb > -1; xb--) {
                    drawTileFromAnimationMap(x, y, (double) frameNumber, (double) framesTotal, animationMap, rows, yb, xb);
                }
            }
        }
        if (frameNumber == framesTotal) {
            int pairDynamicCurrent = CursesColorInit.PAIR_DYNAMIC_START;
            int[][] endRows = animationMap.endBoard.getRows();
            for (int yb = 0; yb < 4; yb++) {
                for (int xb = 0; xb < 4; xb++) {
                    if (animationMap.newNumberMap[yb][xb] != -1) {
                        drawTile(x+2+xb*19, y+ 1 +yb*10, endRows[yb][xb]);
                        if (animationMap.newNumberMap[yb][xb] == Constants.ANIM_SPAWN) {
                            int number = endRows[yb][xb];
                            short fgColor = CursesColorInit.COLOR_BG_4096;
                            if (CursesPrinterInfo.NUMBER_BG_COLORS.containsKey(number)) {
                                fgColor = CursesPrinterInfo.NUMBER_BG_COLORS.get(number);
                            }
                            short bgColor = CursesColorInit.COLOR_BACKGROUND_BG;
                            init_pair(pairDynamicCurrent, fgColor, bgColor);
                            attrset(COLOR_PAIR(pairDynamicCurrent));
                            drawStringSkipChar(x+2+xb*19, y+ 1 +yb*10, CursesPrinterInfo.SPAWN_ANIM_FRAME, '#');
                            pairDynamicCurrent += 1;
                        }

                        if (animationMap.newNumberMap[yb][xb] == Constants.ANIM_MERGE) {
                            int number = endRows[yb][xb];
                            //top logic
                            short fgColor = CursesColorInit.COLOR_BG_4096;
                            if (CursesPrinterInfo.NUMBER_BG_COLORS.containsKey(number)) {
                                fgColor = CursesPrinterInfo.NUMBER_BG_COLORS.get(number);
                            }
                            boolean mergedNumberAbove = false;
                            if (yb != 0) {
                                if (animationMap.newNumberMap[yb - 1][xb] == Constants.ANIM_MERGE) {
                                    mergedNumberAbove = true; //dont draw since it was already drawn
                                }
                            }
                            short bgColor = CursesColorInit.COLOR_BACKGROUND_FG;
                            if (!mergedNumberAbove) {
                                init_pair(pairDynamicCurrent, fgColor, bgColor);
                                attrset(COLOR_PAIR(pairDynamicCurrent));
                                pairDynamicCurrent += 1;
                                drawStringSkipChar((x + 2 + xb * 19) - 1, (y + 1 + yb * 10) - 1, CursesPrinterInfo.MERGE_ANIM_FRAME_TOP, '#');
                            }
                            //side logic
                            int colorPair = CursesColorInit.PAIR_4096;
                            if (CursesPrinterInfo.NUMBER_COLOR_PAIRS.containsKey(number)) {
                                colorPair = CursesPrinterInfo.NUMBER_COLOR_PAIRS.get(number);
                            }
                            attrset(COLOR_PAIR(colorPair));
                            drawStringSkipChar((x+2+xb*19) - 1, (y+ 1 +yb*10), CursesPrinterInfo.MERGE_ANIM_FRAME_SIDES, '#');
                            //bottom logic
                            int mergedNumberBelow = 0;
                            if (yb != 3) {
                                if (animationMap.newNumberMap[yb + 1][xb] == Constants.ANIM_MERGE) {
                                    mergedNumberBelow = endRows[yb + 1][xb];
                                }
                            }
                            bgColor = CursesColorInit.COLOR_BACKGROUND_FG;
                            if (mergedNumberBelow != 0) {
                                bgColor = CursesColorInit.COLOR_BG_4096;
                                if (CursesPrinterInfo.NUMBER_BG_COLORS.containsKey(mergedNumberBelow)) {
                                    bgColor = CursesPrinterInfo.NUMBER_BG_COLORS.get(mergedNumberBelow);
                                }
                            }
                            init_pair(pairDynamicCurrent, fgColor, bgColor);
                            attrset(COLOR_PAIR(pairDynamicCurrent));
                            pairDynamicCurrent += 1;
                            drawStringSkipChar((x+2+xb*19) - 1, (y+ 1 +yb*10) + 9, CursesPrinterInfo.MERGE_ANIM_FRAME_BOTTOM, '#');
                        }

                    }
                }
            }
        }
        return animationMap.endBoard;

    }

    private static void drawTileFromAnimationMap(int x, int y, double frameNumber, double framesTotal, AnimationMap animationMap, int[][] rows, int yb, int xb) {
        //this is a seperate function to avoid me writing some code twice
        double yAdd = 0;
        double xAdd = 0;
        if (animationMap.map[yb][xb][0] != -1 && animationMap.map[yb][xb][0] != 4) {
            yAdd = animationMap.map[yb][xb][1] - yb;
            xAdd = animationMap.map[yb][xb][0] - xb;

            yAdd *= (frameNumber / framesTotal);
            xAdd *= (frameNumber / framesTotal);

        }
        drawTile((int) (x +2+(xb + xAdd)*19), (int) (y + 1 +(yb + yAdd)*10), rows[yb][xb]);
    }

    private static void drawTile(int x, int y, int number) {
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
    private static void drawStringNoLinebreak(int x, int y, String str) {
        //dont feed \n into this

        for (int i = 0; i < str.length(); i++) {
            move(y, x+i);
            delch();
            insch(str.charAt(i));
        }

    }
    private static void drawStringNoLinebreakSkipChar(int x, int y, String str, char skipChar) {
        //dont feed \n into this

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != skipChar) {
                move(y, x+i);
                delch();
                insch(str.charAt(i));
            }
        }

    }
}
