package pieces;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PieceIT {

    public PieceIT() {
    }

    protected void verifyCreation(Piece whitePiece, Piece blackPiece,
            Class type, char representation) {
        assertTrue(whitePiece.isWhite());
        assertEquals(type, whitePiece.getClass());
        assertEquals(representation, whitePiece.getRepresentation());
        assertTrue(blackPiece.isBlack());
        assertEquals(type, blackPiece.getClass());
        assertEquals(Character.toUpperCase(representation), blackPiece.getRepresentation());
    }


    /*
     Privates
     */
}
