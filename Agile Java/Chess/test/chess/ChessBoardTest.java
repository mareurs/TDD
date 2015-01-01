package chess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import pieces.Pawn;

public class ChessBoardTest {

    private ChessBoard board;
    private Pawn whitePawn;
    private Pawn blackPawn;

    private final String expectedBoard
            = "........\n"
            + "PPPPPPPP\n"
            + "........\n"
            + "........\n"
            + "........\n"
            + "........\n"
            + "pppppppp\n"
            + "........";

    public ChessBoardTest() {

    }

    @Before
    public void setUp() {
        board = new ChessBoard();
        whitePawn = new Pawn();
        blackPawn = new Pawn(Pawn.BLACK);
    }

    @Test
    public void boardInitializedProperly() {
        assertEquals(16, board.getPiecesCount());
    }

    @Test
    public void onInit_PawnsAreProperlySet() {
        assertEquals("pppppppp", board.printRank(2));
        assertEquals("PPPPPPPP", board.printRank(7));
        assertEquals(expectedBoard, board.printBoard());
    }


    /*
     Privates
     */
    private List<Pawn> list(Pawn... pawns) {
        return new ArrayList<>(Arrays.asList(pawns));
    }

}
