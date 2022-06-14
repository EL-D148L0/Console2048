package max.sander;

import java.awt.*;

import static io.webfolder.curses4j.Curses.*;

public class CursesColorInit {
    static final int PAIR_BACKGROUND = 1;// line color is FG
    //static final int PAIR_BACKGROUND_LINE = 2;
    static final int PAIR_2 = 3;
    static final int PAIR_4 = 4;
    static final int PAIR_8 = 5;
    static final int PAIR_16 = 6;
    static final int PAIR_32 = 7;
    static final int PAIR_64 = 8;
    static final int PAIR_128 = 9;
    static final int PAIR_256 = 10;
    static final int PAIR_512 = 11;
    static final int PAIR_1024 = 12;
    static final int PAIR_2048 = 13;
    static final int PAIR_4096 = 14;
    /*static final int PAIR_ = 15;
    static final int PAIR_ = 16;
    static final int PAIR_ = 17;
    static final int PAIR_ = 18;
    static final int PAIR_ = 19;
    static final int PAIR_ = 20;*/

    private static final double MAGIC_NUMBER = 1000D/255D;
    public static final short COLOR_BACKGROUND_FG = (short) 301;
    public static final short COLOR_BACKGROUND_BG = (short) 302;
    public static final short COLOR_FG_2_4 = (short) 303;
    public static final short COLOR_FG_8 = (short) 304;
    public static final short COLOR_BG_2 = (short) 305;
    public static final short COLOR_BG_4 = (short) 306;
    public static final short COLOR_BG_8 = (short) 307;
    public static final short COLOR_BG_16 = (short) 308;
    public static final short COLOR_BG_32 = (short) 309;
    public static final short COLOR_BG_64 = (short) 310;
    public static final short COLOR_BG_128 = (short) 311;
    public static final short COLOR_BG_256 = (short) 312;
    public static final short COLOR_BG_512 = (short) 313;
    public static final short COLOR_BG_1024 = (short) 314;
    public static final short COLOR_BG_2048 = (short) 315;
    public static final short COLOR_BG_4096 = (short) 316;

    public static void init() {
        //call after initscr()
        start_color();

        init_color_hex(COLOR_BACKGROUND_FG, "bbada0");
        init_color_hex(COLOR_BACKGROUND_BG, "cdc1b4");


        init_color_hex(COLOR_FG_2_4, "776e65");
        init_color_hex(COLOR_FG_8, "f9f6f2");
        init_color_hex(COLOR_BG_2, "eee4da");
        init_color_hex(COLOR_BG_4, "ede0c8");
        init_color_hex(COLOR_BG_8, "f2b179");
        init_color_hex(COLOR_BG_16, "f59563");
        init_color_hex(COLOR_BG_32, "f67c5f");
        init_color_hex(COLOR_BG_64, "f65e3b");
        init_color_hex(COLOR_BG_128, "edcf72");
        init_color_hex(COLOR_BG_256, "edcc61");
        init_color_hex(COLOR_BG_512, "edc850");
        init_color_hex(COLOR_BG_1024, "edc53f");
        init_color_hex(COLOR_BG_2048, "edc22e");
        init_color_hex(COLOR_BG_4096, "3c3a32");

        init_pair(PAIR_BACKGROUND, COLOR_BACKGROUND_FG, COLOR_BACKGROUND_BG);

        init_pair(PAIR_2, COLOR_FG_2_4, COLOR_BG_2);
        init_pair(PAIR_4, COLOR_FG_2_4, COLOR_BG_4);
        init_pair(PAIR_8, COLOR_FG_8, COLOR_BG_8);
        init_pair(PAIR_16, COLOR_FG_8, COLOR_BG_16);
        init_pair(PAIR_32, COLOR_FG_8, COLOR_BG_32);
        init_pair(PAIR_64, COLOR_FG_8, COLOR_BG_64);
        init_pair(PAIR_128, COLOR_FG_8, COLOR_BG_128);
        init_pair(PAIR_256, COLOR_FG_8, COLOR_BG_256);
        init_pair(PAIR_512, COLOR_FG_8, COLOR_BG_512);
        init_pair(PAIR_1024, COLOR_FG_8, COLOR_BG_1024);
        init_pair(PAIR_2048, COLOR_FG_8, COLOR_BG_2048);
        init_pair(PAIR_4096, COLOR_FG_8, COLOR_BG_4096);

    }
    static int init_color_hex(short id, String color) {
        Color c = Color.decode(color);
        return init_color(id, (short) (c.getRed()*MAGIC_NUMBER), (short) (c.getGreen()*MAGIC_NUMBER), (short) (c.getBlue()*MAGIC_NUMBER));
    }
}
