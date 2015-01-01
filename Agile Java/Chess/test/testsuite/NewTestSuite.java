package testsuite;

import chess.ChessBoardTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import pieces.PawnTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    ChessBoardTest.class, 
    PawnTest.class
})
public class NewTestSuite {    
}