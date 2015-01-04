package testsuite;

import chess.ChessBoardTest;
import gui.CharacterIT;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import pieces.PieceIT;
import util.StringUtilTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    ChessBoardTest.class,
    PieceIT.class,
    CharacterIT.class,
    StringUtilTest.class
})
public class ChessTestSuite {
}
