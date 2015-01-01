package gui;

import org.junit.Test;
import static org.junit.Assert.*;

public class CharacterIT {

    public CharacterIT() {
    }

    @Test
    public void testWhiteSpaces() {
        char input = 'x';
        assertEquals(false, Character.isWhitespace(input));        
        input = ' ';
        assertEquals(true, Character.isWhitespace(input));
        input =  '\t';
        assertEquals(true, Character.isWhitespace(input));
    }
    
    @Test
    public void testIdentifiers(){
        String input = "";
//        assertEquals(false, Character.isUnicodeIdentifierStart(input));
//        input = "_test";
//        assertEquals(false, Character.isGoodIdentifier(input));
//        input = "goodName";
//        assertEquals(true, Character.isGoodIdentifier(input));
        
    }
    
}