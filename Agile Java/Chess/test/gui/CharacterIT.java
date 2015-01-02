package gui;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import pieces.Piece;

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
        Piece blackPawn = Piece.make(Piece.PAWN, Piece.BLACK);
        Piece whitePawn = Piece.make(Piece.PAWN, Piece.WHITE);

        assertEquals("P", blackPawn.getShortName());
        assertEquals("p", whitePawn.getShortName());

    }

}
