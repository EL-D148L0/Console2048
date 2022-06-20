package max.sander;

import java.util.HashMap;
import java.util.Map;

public class CursesPrinterInfo {

    static final Map<Integer, String> NUMBER_GRAPHICS = new HashMap<Integer, String>();
    static final Map<Integer, Integer> NUMBER_COLOR_PAIRS = new HashMap<Integer, Integer>();
    static {
        NUMBER_COLOR_PAIRS.put(2, CursesColorInit.PAIR_2);
        NUMBER_COLOR_PAIRS.put(4,  CursesColorInit.PAIR_4);
        NUMBER_COLOR_PAIRS.put(8,  CursesColorInit.PAIR_8);
        NUMBER_COLOR_PAIRS.put(16,  CursesColorInit.PAIR_16);
        NUMBER_COLOR_PAIRS.put(32,  CursesColorInit.PAIR_32);
        NUMBER_COLOR_PAIRS.put(64,  CursesColorInit.PAIR_64);
        NUMBER_COLOR_PAIRS.put(128,  CursesColorInit.PAIR_128);
        NUMBER_COLOR_PAIRS.put(256,  CursesColorInit.PAIR_256);
        NUMBER_COLOR_PAIRS.put(512,  CursesColorInit.PAIR_512);
        NUMBER_COLOR_PAIRS.put(1024,  CursesColorInit.PAIR_1024);
        NUMBER_COLOR_PAIRS.put(2048,  CursesColorInit.PAIR_2048);
    }
    static final Map<Integer, Short> NUMBER_BG_COLORS = new HashMap<Integer, Short>();
    static {
        NUMBER_BG_COLORS.put(2, CursesColorInit.COLOR_BG_2);
        NUMBER_BG_COLORS.put(4,  CursesColorInit.COLOR_BG_4);
        NUMBER_BG_COLORS.put(8,  CursesColorInit.COLOR_BG_8);
        NUMBER_BG_COLORS.put(16,  CursesColorInit.COLOR_BG_16);
        NUMBER_BG_COLORS.put(32,  CursesColorInit.COLOR_BG_32);
        NUMBER_BG_COLORS.put(64,  CursesColorInit.COLOR_BG_64);
        NUMBER_BG_COLORS.put(128,  CursesColorInit.COLOR_BG_128);
        NUMBER_BG_COLORS.put(256,  CursesColorInit.COLOR_BG_256);
        NUMBER_BG_COLORS.put(512,  CursesColorInit.COLOR_BG_512);
        NUMBER_BG_COLORS.put(1024,  CursesColorInit.COLOR_BG_1024);
        NUMBER_BG_COLORS.put(2048,  CursesColorInit.COLOR_BG_2048);
        NUMBER_BG_COLORS.put(4096,  CursesColorInit.COLOR_BG_4096);
    }
    public static final String MERGE_ANIM_FRAME_TOP = "▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄";
    public static final String MERGE_ANIM_FRAME_SIDES = " ################# \n" +
            " ################# \n" +
            " ################# \n" +
            " ################# \n" +
            " ################# \n" +
            " ################# \n" +
            " ################# \n" +
            " ################# \n" +
            " ################# ";
    public static final String MERGE_ANIM_FRAME_BOTTOM = "▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀";

    public static final String SPAWN_ANIM_FRAME = " ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄ \n" +
            " ############### \n" +
            " ############### \n" +
            " ############### \n" +
            " ############### \n" +
            " ############### \n" +
            " ############### \n" +
            " ############### \n" +
            " ▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀ ";
    public static final String BACKGROUND = """
            ██████████████████████████████████████████████████████████████████████████████
            ██                 ██                 ██                 ██                 ██
            ██                 ██                 ██                 ██                 ██
            ██                 ██                 ██                 ██                 ██
            ██                 ██                 ██                 ██                 ██
            ██                 ██                 ██                 ██                 ██
            ██                 ██                 ██                 ██                 ██
            ██                 ██                 ██                 ██                 ██
            ██                 ██                 ██                 ██                 ██
            ██                 ██                 ██                 ██                 ██
            ██████████████████████████████████████████████████████████████████████████████
            ██                 ██                 ██                 ██                 ██
            ██                 ██                 ██                 ██                 ██
            ██                 ██                 ██                 ██                 ██
            ██                 ██                 ██                 ██                 ██
            ██                 ██                 ██                 ██                 ██
            ██                 ██                 ██                 ██                 ██
            ██                 ██                 ██                 ██                 ██
            ██                 ██                 ██                 ██                 ██
            ██                 ██                 ██                 ██                 ██
            ██████████████████████████████████████████████████████████████████████████████
            ██                 ██                 ██                 ██                 ██
            ██                 ██                 ██                 ██                 ██
            ██                 ██                 ██                 ██                 ██
            ██                 ██                 ██                 ██                 ██
            ██                 ██                 ██                 ██                 ██
            ██                 ██                 ██                 ██                 ██
            ██                 ██                 ██                 ██                 ██
            ██                 ██                 ██                 ██                 ██
            ██                 ██                 ██                 ██                 ██
            ██████████████████████████████████████████████████████████████████████████████
            ██                 ██                 ██                 ██                 ██
            ██                 ██                 ██                 ██                 ██
            ██                 ██                 ██                 ██                 ██
            ██                 ██                 ██                 ██                 ██
            ██                 ██                 ██                 ██                 ██
            ██                 ██                 ██                 ██                 ██
            ██                 ██                 ██                 ██                 ██
            ██                 ██                 ██                 ██                 ██
            ██                 ██                 ██                 ██                 ██
            ██████████████████████████████████████████████████████████████████████████████""";

    static {
        NUMBER_GRAPHICS.put(2, "                 \n" +
                "                 \n" +
                "       ███       \n" +
                "         █       \n" +
                "       ███       \n" +
                "       █         \n" +
                "       ███       \n" +
                "                 \n" +
                "                 \n");
        NUMBER_GRAPHICS.put(4, "                 \n" +
                "                 \n" +
                "       █ █       \n" +
                "       █ █       \n" +
                "       ███       \n" +
                "         █       \n" +
                "         █       \n" +
                "                 \n" +
                "                 ");
        NUMBER_GRAPHICS.put(8, "                 \n" +
                "                 \n" +
                "       ███       \n" +
                "       █ █       \n" +
                "       ███       \n" +
                "       █ █       \n" +
                "       ███       \n" +
                "                 \n" +
                "                 ");
        NUMBER_GRAPHICS.put(16, "                 \n" +
                "                 \n" +
                "      █  ███     \n" +
                "     ██  █       \n" +
                "      █  ███     \n" +
                "      █  █ █     \n" +
                "     ███ ███     \n" +
                "                 \n" +
                "                 ");
        NUMBER_GRAPHICS.put(32, "                 \n" +
                "                 \n" +
                "     ███ ███     \n" +
                "       █   █     \n" +
                "      ██ ███     \n" +
                "       █ █       \n" +
                "     ███ ███     \n" +
                "                 \n" +
                "                 ");
        NUMBER_GRAPHICS.put(64, "                 \n" +
                "                 \n" +
                "     ███ █ █     \n" +
                "     █   █ █     \n" +
                "     ███ ███     \n" +
                "     █ █   █     \n" +
                "     ███   █     \n" +
                "                 \n" +
                "                 ");
        NUMBER_GRAPHICS.put(128, "                 \n" +
                "                 \n" +
                "    █  ███ ███   \n" +
                "   ██    █ █ █   \n" +
                "    █  ███ ███   \n" +
                "    █  █   █ █   \n" +
                "   ███ ███ ███   \n" +
                "                 \n" +
                "                 ");
        NUMBER_GRAPHICS.put(256, "                 \n" +
                "                 \n" +
                "   ███ ███ ███   \n" +
                "     █ █   █     \n" +
                "   ███ ███ ███   \n" +
                "   █     █ █ █   \n" +
                "   ███ ███ ███   \n" +
                "                 \n" +
                "                 ");
        NUMBER_GRAPHICS.put(512, "                 \n" +
                "                 \n" +
                "   ███  █  ███   \n" +
                "   █   ██    █   \n" +
                "   ███  █  ███   \n" +
                "     █  █  █     \n" +
                "   ███ ███ ███   \n" +
                "                 \n" +
                "                 ");
        NUMBER_GRAPHICS.put(1024, "                 \n" +
                "                 \n" +
                "  █  ███ ███ █ █ \n" +
                " ██  █ █   █ █ █ \n" +
                "  █  █ █ ███ ███ \n" +
                "  █  █ █ █     █ \n" +
                " ███ ███ ███   █ \n" +
                "                 \n" +
                "                 ");
        NUMBER_GRAPHICS.put(2048, "                 \n" +
                "                 \n" +
                " ███ ███ █ █ ███ \n" +
                "   █ █ █ █ █ █ █ \n" +
                " ███ █ █ ███ ███ \n" +
                " █   █ █   █ █ █ \n" +
                " ███ ███   █ ███ \n" +
                "                 \n" +
                "                 ");
        NUMBER_GRAPHICS.put(4096, "                 \n" +
                "                 \n" +
                " █ █ ███ ███ ███ \n" +
                " █ █ █ █ █ █ █   \n" +
                " ███ █ █ ███ ███ \n" +
                "   █ █ █   █ █ █ \n" +
                "   █ ███ ███ ███ \n" +
                "                 \n" +
                "                 ");
        NUMBER_GRAPHICS.put(8192, "                 \n" +
                "                 \n" +
                " ███  █  ███ ███ \n" +
                " █ █ ██  █ █   █ \n" +
                " ███  █  ███ ███ \n" +
                " █ █  █    █ █   \n" +
                " ███ ███ ███ ███ \n" +
                "                 \n" +
                "                 ");
    }
}
