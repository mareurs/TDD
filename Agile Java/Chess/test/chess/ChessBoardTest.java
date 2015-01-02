package chess;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import util.StringUtil;

public class ChessBoardTest {

    private ChessBoard board;

    public ChessBoardTest() {

    }

    @Before
    public void setUp() {
        board = new ChessBoard();
    }

    @Test
    public void testCreate() {
        board.initialize();
        assertEquals(32, board.piecesCount());
        String blankRank = StringUtil.appendNewLine("........");
        assertEquals(
                StringUtil.appendNewLine("RNBQKBNR")
                + StringUtil.appendNewLine("PPPPPPPP")
                + blankRank + blankRank + blankRank + blankRank
                + StringUtil.appendNewLine("pppppppp")
                + StringUtil.appendNewLine("rnbqkbnr"),
                board.print());
    }

}
