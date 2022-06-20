package max.sander;

public class Util {
    public static String changeEscapes(String input){
        return input.replace("\\x1b", "\u001B");
    }
    public static String centerString(String input, int length) {
        //does not actually center it, moves to the side instead
        if (input.length() >= length) {
            return input;
        }
        int spaces = (length - input.length())/2;
        String out = " ".repeat(spaces) +  input;
        return out + " ".repeat(length - out.length());
    }
    public static int getchToDir(int ch) {
        if (ch == 119 || ch == 87) {
            return Constants.DIR_UP;
        }
        if (ch == 97 || ch == 65) {
            return Constants.DIR_LEFT;
        }
        if (ch == 115 || ch == 83) {
            return Constants.DIR_DOWN;
        }
        if (ch == 100 || ch == 68) {
            return Constants.DIR_RIGHT;
        }
        return Constants.DIR_NONE;
    }

}
