package pieces;

import org.junit.Test;

public class RookTest extends PieceIT {

    public RookTest() {
    }

    @Test
    public void testCreate() {
        verifyCreation(new Rook(Piece.COLOR.WHITE), new Rook(Piece.COLOR.BLACK),
                Rook.class, 'r');
    }

}
