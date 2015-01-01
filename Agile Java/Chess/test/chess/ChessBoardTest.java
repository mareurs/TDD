package chess;

import pieces.Pawn;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class ChessBoardTest {

    private ChessBoard board;
    private Pawn whitePawn;
    private Pawn blackPawn;
    
    public ChessBoardTest() {
        
    }
    
    @Before
    public void setUp()
    {
        board = new ChessBoard();
        whitePawn = new Pawn();
        blackPawn = new Pawn(Pawn.BLACK);
    }
    
    @Test
    public void addingOneWhitePawn_BoardHasThatPawn()
    {
        board.add(whitePawn);
        assertEquals(1, board.getPiecesCount());
        assertEquals(list(whitePawn), board.getPieces());        
    }
    
    @Test
    public void addingAnotherBlackPawn_BoardHasTheTwoPawns()
    {
        board.add(whitePawn);
        board.add(blackPawn);
        assertEquals(2, board.getPiecesCount());
        assertEquals(list(whitePawn, blackPawn), board.getPieces());        
    }
    
    /*
    Privates
    */
    
    private List<Pawn> list(Pawn ... pawns)
    {
        return new ArrayList<>(Arrays.asList(pawns));
    }

}