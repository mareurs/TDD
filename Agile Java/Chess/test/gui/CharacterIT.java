package gui;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import pieces.Pawn;
import pieces.Piece;
import static pieces.Piece.COLOR.BLACK;
import static pieces.Piece.COLOR.WHITE;

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
        Piece blackPawn = new Pawn(BLACK);
        Piece whitePawn = new Pawn(WHITE);

        assertEquals('P', blackPawn.getRepresentation());
        assertEquals('p', whitePawn.getRepresentation());

    }

}
