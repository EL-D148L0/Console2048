package max.sander;

public class Styleset {
    //container for number styles
    int foregroundColor;
    int backgroundColor;
    int style;
    int foregroundText; //i have forgotten what this does
    char letter;

    public Styleset(int foregroundColor, int backgroundColor, int style, char letter, int foregroundText) {
        this.foregroundColor = foregroundColor;
        this.backgroundColor = backgroundColor;
        this.style = style;
        this.foregroundText = foregroundText;
        this.letter = letter;
    }
    public Styleset(int foregroundColor, int backgroundColor, int style, char letter) {
        this.foregroundColor = foregroundColor;
        this.backgroundColor = backgroundColor;
        this.style = style;
        this.letter = letter;
    }
}
