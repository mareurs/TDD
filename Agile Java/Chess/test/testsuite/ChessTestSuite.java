package testsuite;

import chess.BoardTest;
import gui.CharacterIT;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import pieces.*;
import util.StringUtilTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    BoardTest.class,
    KingTest.class,
    QueenTest.class,
    PawnTest.class,
    BishopTest.class,
    KnightTest.class,
    CharacterIT.class,
    StringUtilTest.class
})
public class ChessTestSuite {
}
