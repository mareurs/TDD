package pieces;

import java.util.*;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import static util.Utils.list;

public class KingTest extends PieceIT {

    public KingTest() {
    }

    @Test
    public void testCreate() {
        verifyCreation(new King(Piece.COLOR.WHITE), new King(Piece.COLOR.BLACK),
                King.class, 'k');
    }

    @Test
    public void testMoveKing() {
        Piece king = new King(Piece.COLOR.WHITE);
        List<String> expected = list("e8", "e6", "d7", "f7", "d6", "d8", "f6", "f8");

        assertValidPositions(expected, king.getPossibleMoves("e7"));
    }

    /*
     Privates
     */
    private void assertValidPositions(List<String> expected, List<String> given) {
        List<String> expCopy = new ArrayList<>(expected);

        for (Iterator<String> it = expCopy.iterator(); it.hasNext();) {
            String expectedElement = it.next();
            for (String givenElement : given)
                if (givenElement.equals(expectedElement))
                    it.remove();
        }
        assertEquals(0, expCopy.size());
    }

}
