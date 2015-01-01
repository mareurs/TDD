package pieces;

import pieces.Pawn;
import org.junit.Test;
import static org.junit.Assert.*;

public class PawnTest {
    
    public PawnTest() {
    }
    

    @Test
    public void testCreate()
    {
        Pawn pawn = new Pawn();
        assertEquals(Pawn.WHITE, pawn.getColor() );
        
        final String blackColor = Pawn.BLACK;
        Pawn blackPawn = new Pawn(blackColor); 
       assertEquals(blackColor,blackPawn.getColor());
        
    }
}
