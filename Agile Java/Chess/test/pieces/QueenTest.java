package pieces;

import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class QueenTest extends PieceIT {

    public QueenTest() {
    }

    @Test
    public void testCreate() {
        verifyCreation(new Queen(Piece.COLOR.WHITE), new Queen(Piece.COLOR.BLACK),
                Queen.class, 'q');
    }

    @Test
    public void testMoveQueen() {
        Piece queen = new Queen(Piece.COLOR.WHITE);

        List<String> possibleMoves = queen.getPossibleMoves("e4");
        assertEquals(27, possibleMoves.size());
    }

}
