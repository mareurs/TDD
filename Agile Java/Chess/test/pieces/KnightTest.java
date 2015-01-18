package pieces;

import org.junit.Test;

public class KnightTest extends PieceIT {

    public KnightTest() {
    }

    @Test
    public void testCreate() {
        verifyCreation(new Knight(Piece.COLOR.WHITE), new Knight(Piece.COLOR.BLACK),
                Knight.class, 'n');
    }

}
