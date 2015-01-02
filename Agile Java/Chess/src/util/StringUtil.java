package util;

public class StringUtil {

    static public final String NEWLINE = System.getProperty("line.separator");

    public static String appendNewLine(String input) {
        return input + NEWLINE;
    }

    private StringUtil() {

    }

}
