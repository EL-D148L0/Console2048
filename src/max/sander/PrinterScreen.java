package max.sander;

public class PrinterScreen {
    String[][] screen;

    public PrinterScreen() {
        this.screen = new String[PrinterInfo.OUTPUT_HEIGHT][PrinterInfo.OUTPUT_WIDTH];
        for (int i = 0; i < PrinterInfo.OUTPUT_HEIGHT; i++) {
            for (int j = 0; j < PrinterInfo.OUTPUT_WIDTH; j++) {
                this.screen[i][j] = "\u001B[0;30;47m░\u001B[0m";
            }
        }
    }


    public String getScreenString() {
        StringBuilder lineToPrint = new StringBuilder();
        for (String[] line: this.screen) {
            for (String character: line) {
                lineToPrint.append(character);
            }
            lineToPrint.append("\n");
        }
        return lineToPrint.toString();
    };
    public void print() {
        System.out.println(getScreenString());
    }



    public void drawSquare(int x1, int y1, int x2, int y2, char letter, int foregroundColor, int backgroundColor, int style) {
        for (int y = y1; y < y2; y++) {
            for (int x = x1; x < x2; x++) {
                this.screen[y][x] = PrinterInfo.ESCAPE_SEQUENCE + style + ";" + foregroundColor + ";" + backgroundColor + "m" + letter + PrinterInfo.ESCAPE_SEQUENCE + "0m";
            }
        }
    }
    public void drawImage(String image, int x1, int y1, int foregroundColor, int backgroundColor, int style) {
        drawImage(image, x1, y1, foregroundColor, backgroundColor, style, false);
    }
    public void drawImage(String image, int x1, int y1, int foregroundColor, int backgroundColor, int style, boolean transparent) {
        String[] lineList = image.split("\n");
        for (int y = 0; y < lineList.length; y++) {
            for (int x = 0; x < lineList[y].length(); x++) {
                if (transparent) {
                    if (!(lineList[y].charAt(x) == ' ')) {
                        screen[y + y1][x + x1] = PrinterInfo.ESCAPE_SEQUENCE + style + ";" + foregroundColor + ";" + backgroundColor + "m" + lineList[y].charAt(x) + PrinterInfo.ESCAPE_SEQUENCE + "0m";
                    }
                } else {
                    screen[y + y1][x + x1] = PrinterInfo.ESCAPE_SEQUENCE + style + ";" + foregroundColor + ";" + backgroundColor + "m" + lineList[y].charAt(x) + PrinterInfo.ESCAPE_SEQUENCE + "0m";
                }
            }
        }
    }
}
