package pieces;

import org.junit.Test;

public class PawnTest extends PieceIT {

    public PawnTest() {
    }

    @Test
    public void testCreate() {
        verifyCreation(
                new Pawn(Piece.COLOR.WHITE), new Pawn(Piece.COLOR.BLACK),
                Pawn.class, 'p');
    }

}
