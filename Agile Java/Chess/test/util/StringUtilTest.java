package util;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class StringUtilTest {

    public StringUtilTest() {
    }

    @Test
    public void testNEWLINE() {
        String osNewLine = System.getProperty("line.separator");
        assertEquals(StringUtil.NEWLINE, osNewLine);
    }

    @Test
    public void testAppendNewLine() {
        String input = "this is a line with new line separator";
        String expected = input + StringUtil.NEWLINE;
        assertEquals(expected, StringUtil.appendNewLine(input));

    }

}
