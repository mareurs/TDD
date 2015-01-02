package testsuite;

import chess.ChessBoardTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import pieces.PieceIT;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    ChessBoardTest.class, 
    PieceIT.class
})
public class NewTestSuite {    
}