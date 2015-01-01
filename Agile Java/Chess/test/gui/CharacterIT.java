package gui;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import pieces.Pawn;

public class CharacterIT {

    public CharacterIT() {
    }

    @Test
    public void testWhiteSpaces() {
        char input = 'x';
        assertEquals(false, Character.isWhitespace(input));
        input = ' ';
        assertEquals(true, Character.isWhitespace(input));
        input = '\t';
        assertEquals(true, Character.isWhitespace(input));
    }

    @Test
    public void testSetCharacter() {
        Pawn blackPawn = new Pawn(Pawn.BLACK);
        Pawn whitePawn = new Pawn(Pawn.WHITE);

        assertEquals((Character) 'P', blackPawn.getName());
        assertEquals((Character) 'p', whitePawn.getName());

    }

}
