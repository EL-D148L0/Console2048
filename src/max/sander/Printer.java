package max.sander;

public class Printer {
    PrinterScreen screen;

    public Printer() {
        screen = new PrinterScreen();
    }

    public void printBoard(Board board) {

    }
    public void drawMenu() {
        screen.drawSquare(0, 0, PrinterInfo.OUTPUT_MAX_X, PrinterInfo.OUTPUT_MAX_Y, ' ', 30, 43, 0);
        screen.drawImage(PrinterInfo.MENU_TEXT, 17, 10, 37, 43, 1, true);
    }

    public void drawGame(Board field) {
        screen = new PrinterScreen();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                screen.drawSquare(2+i*19, 1+j*10, 19+i*19, 10+j*10, /*'░'*/'#', 30, 107, 1);

                int number = field.getColumns()[i][j];
                if (number != 0) {
                    Styleset styleset = PrinterInfo.NUMBER_OVER_2048_STYLE;
                    if (PrinterInfo.NUMBER_STYLES.containsKey(number)) {
                        styleset = PrinterInfo.NUMBER_STYLES.get(number);
                    }
                    String image;
                    if (PrinterInfo.NUMBER_GRAPHICS.containsKey(number)) {
                        image = PrinterInfo.NUMBER_GRAPHICS.get(number);
                    } else {
                        image = "\n".repeat(3) + Util.centerString(Integer.toString(number), 17);
                    }

                    screen.drawSquare(2+i*19, 1+j*10, 19+i*19, 10+j*10, styleset.letter, styleset.foregroundColor, styleset.backgroundColor, styleset.style);
                    screen.drawImage(image, 2+i*19, 2+j*10, styleset.foregroundText, styleset.backgroundColor, styleset.style, true);
                }
            }
        }
    }


}
