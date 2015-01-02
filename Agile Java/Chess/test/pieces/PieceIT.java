package pieces;

import static junit.framework.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class PieceIT {

    public PieceIT() {
    }

    @Test
    public void testCreate() {
        Piece piece = Piece.make(Piece.PAWN, Piece.WHITE);
        assertEquals(Piece.WHITE, piece.getColor());

        Piece blackPawn = Piece.make(Piece.PAWN, Piece.BLACK);
        assertEquals(Piece.BLACK, blackPawn.getColor());
    }

    @Test
    public void testPieceColor() {
        Piece piece1 = Piece.make(Piece.KING, Piece.WHITE);
        assertTrue(piece1.isWhite());
        assertFalse(piece1.isBlack());

        Piece piece2 = Piece.make(Piece.QUEEN, Piece.BLACK);
        assertTrue(piece2.isBlack());
        assertFalse(piece2.isWhite());

    }
}
