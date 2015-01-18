package pieces;

import org.junit.Test;

public class BishopTest extends PieceIT {

    public BishopTest() {
    }

    @Test
    public void testCreate() {
        verifyCreation(new Bishop(Piece.COLOR.WHITE), new Bishop(Piece.COLOR.BLACK),
                Bishop.class, 'b');
    }

}
