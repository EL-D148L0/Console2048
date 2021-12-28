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
        return " ".repeat(spaces) +  input;
    }
}
