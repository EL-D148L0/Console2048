package max.sander;



import java.util.HashMap;
import java.util.Map;

public class PrinterInfo {
    static final Map<Integer, Styleset> NUMBER_STYLES = new HashMap<Integer, Styleset>();
    static {
        NUMBER_STYLES.put(2, new Styleset(37, 47, 1, '░', 30));
        NUMBER_STYLES.put(4, new Styleset(33, 47, 1, '░', 30));
        NUMBER_STYLES.put(8, new Styleset(33, 41, 1, '▓', 37));
        NUMBER_STYLES.put(16, new Styleset(33, 41, 0, '▓', 37));
        NUMBER_STYLES.put(32, new Styleset(31, 47, 0, '▒', 37));
        NUMBER_STYLES.put(64, new Styleset(31, 47, 0, '▓', 37));
        NUMBER_STYLES.put(128, new Styleset(33, 47, 0, '▒', 37));
        NUMBER_STYLES.put(256, new Styleset(33, 43, 1, '▓', 37));
        NUMBER_STYLES.put(512, new Styleset(33, 43, 1, '▓', 37));
        NUMBER_STYLES.put(1024, new Styleset(33, 43, 1, '▓', 37));
        NUMBER_STYLES.put(2048, new Styleset(33, 43, 1, '▓', 37));
    }
    static final Styleset NUMBER_OVER_2048_STYLE = new Styleset(30, 40, 0, '█', 37);
    static final Styleset NUMBER_EMPTY_STYLE = new Styleset(30, 47, 1, '░');
    static final Map<Integer, String> NUMBER_GRAPHICS = new HashMap<Integer, String>();
    static {
        NUMBER_GRAPHICS.put(2, """

\040\040\040\040\040\040\040███
\040\040\040\040\040\040\040  █
\040\040\040\040\040\040\040███
\040\040\040\040\040\040\040█
\040\040\040\040\040\040\040███""");
        NUMBER_GRAPHICS.put(4, """

\040\040\040\040\040\040\040█ █
\040\040\040\040\040\040\040█ █
\040\040\040\040\040\040\040███
\040\040\040\040\040\040\040  █
\040\040\040\040\040\040\040  █""");
        NUMBER_GRAPHICS.put(8, """

\040\040\040\040\040\040\040███
\040\040\040\040\040\040\040█ █
\040\040\040\040\040\040\040███
\040\040\040\040\040\040\040█ █
\040\040\040\040\040\040\040███""");
        NUMBER_GRAPHICS.put(16, """

\040\040\040\040\040 █  ███
\040\040\040\040\040██  █
\040\040\040\040\040 █  ███
\040\040\040\040\040 █  █ █
\040\040\040\040\040███ ███""");
        NUMBER_GRAPHICS.put(32, """

\040\040\040\040\040███ ███
\040\040\040\040\040  █   █
\040\040\040\040\040 ██ ███
\040\040\040\040\040  █ █
\040\040\040\040\040███ ███""");
        NUMBER_GRAPHICS.put(64, """

\040\040\040\040\040███ █ █
\040\040\040\040\040█   █ █
\040\040\040\040\040███ ███
\040\040\040\040\040█ █   █
\040\040\040\040\040███   █""");
        NUMBER_GRAPHICS.put(128, """

\040\040\040 █  ███ ███
\040\040\040██    █ █ █
\040\040\040 █  ███ ███
\040\040\040 █  █   █ █
\040\040\040███ ███ ███""");
        NUMBER_GRAPHICS.put(256, """

\040\040\040███ ███ ███
\040\040\040  █ █   █
\040\040\040███ ███ ███
\040\040\040█     █ █ █
\040\040\040███ ███ ███""");
        NUMBER_GRAPHICS.put(512, """
    
\040\040\040███  █  ███\040
\040\040\040█   ██    █\040
\040\040\040███  █  ███\040
\040\040\040  █  █  █\040\040\040
\040\040\040███ ███ ███\040""");
        NUMBER_GRAPHICS.put(1024, """

 \040 █  ███ ███ █ █\040
 \040██  █ █   █ █ █\040
 \040 █  █ █ ███ ███\040
 \040 █  █ █ █     █\040
 \040███ ███ ███   █\040""");
        NUMBER_GRAPHICS.put(2048, """

 \040███ ███ █ █ ███\040
 \040  █ █ █ █ █ █ █\040
 \040███ █ █ ███ ███\040
 \040█   █ █   █ █ █\040
 \040███ ███   █ ███\040""");
        NUMBER_GRAPHICS.put(4096, """

 \040█ █ ███ ███ ███\040
 \040█ █ █ █ █ █ █\040\040\040
 \040███ █ █ ███ ███\040
 \040  █ █ █   █ █ █\040
 \040  █ ███ ███ ███\040""");
        NUMBER_GRAPHICS.put(8192, """

 \040███  █  ███ ███\040
 \040█ █ ██  █ █   █\040
 \040███  █  ███ ███\040
 \040█ █  █    █ █\040\040\040
 \040███ ███ ███ ███\040""");
    }
    static final String WIN_TEXT = """
 __     __                    _       _\040
 \\ \\   / /                   (_)     | |
  \\ \\_/ /__  _   _  __      ___ _ __ | |
   \\   / _ \\| | | | \\ \\ /\\ / / | '_ \\| |
    | | (_) | |_| |  \\ V  V /| | | | |_|
    |_|\\___/ \\__,_|   \\_/\\_/ |_|_| |_(_)""";
    static final String LOSE_TEXT = """
            __     __           _                _\040
            \\ \\   / /          | |              | |
             \\ \\_/ /__  _   _  | | ___  ___  ___| |
              \\   / _ \\| | | | | |/ _ \\/ __|/ _ \\ |
               | | (_) | |_| | | | (_) \\__ \\  __/_|
               |_|\\___/ \\__,_| |_|\\___/|___/\\___(_)""";
    static final String MENU_TEXT = """
             ▄▟████▙▄   ▄▟████▙▄      ▟████   ▄▟████▙▄\040\040
            ▟██▛  ▜██▙ ▟██▛  ▜██▙    ▟█▛███  ▟██▛  ▜██▙\040
                   ███ ███    ███   ▟█▛ ███  ▜██▙  ▟██▛\040
                 ▄▟██▛ ███    ███  ▟█▛  ███   ▝██████▘\040\040
             ▗▄▟███▛▘  ███    ███ ▟██   ███  ▗▟█▛▘▝▜█▙▖\040
            ▟██▛▀      ███    ███ ██████████ ███    ███\040
            ███▘       ▜██▙  ▟██▛       ███  ▜██▙  ▟██▛\040
            █████████   ▝▜████▛▘        ███   ▝▜████▛▘\040\040
                         
                         -- in console--""";
    static final int OUTPUT_HEIGHT = 41;
    static final int OUTPUT_WIDTH = 78;
    static final int OUTPUT_MAX_Y = OUTPUT_HEIGHT - 1;
    static final int OUTPUT_MAX_X = OUTPUT_WIDTH - 1;
    static final String ESCAPE_CHARACTER = "\u001B";
    static final String ESCAPE_SEQUENCE = "\u001B[";

}
