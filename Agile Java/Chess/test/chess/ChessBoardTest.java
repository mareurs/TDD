package chess;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import pieces.Piece;
import static pieces.Piece.Type.*;
import static util.StringUtil.NEWLINE;
import static util.StringUtil.appendNewLine;

public class ChessBoardTest {

    static private final double DELTA = 0.001;

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
        String blankRank = appendNewLine("........");
        assertEquals(
                appendNewLine("RNBQKBNR")
                + appendNewLine("PPPPPPPP")
                + blankRank + blankRank + blankRank + blankRank
                + appendNewLine("pppppppp")
                + appendNewLine("rnbqkbnr"),
                board.print());
    }

    @Test
    public void testInitializeBoardFromString() {
        String inputBoard = createRandomBoardWithLabels();
        board = new ChessBoard(inputBoard);
        assertEquals('r', board.getPieceAt("e1"));

        inputBoard = reverseStringBoard(inputBoard);
        board = new ChessBoard(inputBoard);
        assertEquals('n', board.getPieceAt("f4"));

        inputBoard = createRandomBoard();
        board = new ChessBoard(inputBoard);
        assertEquals('p', board.getPieceAt("g2"));
    }

    @Test
    public void testCountPieces() {
        String inputBoard = createRandomBoardWithLabels();

        board = new ChessBoard(inputBoard);
        assertEquals(3, board.countPieces('P'));
        assertEquals(4, board.countPieces('p'));
        assertEquals(1, board.countPieces('k'));
    }

    @Test
    public void testGetPieceByPosition() {
        board.initialize();
        assertEquals('R', board.getPieceAt("a8"));
        assertEquals('k', board.getPieceAt("e1"));
    }

    @Test
    public void testPlacePiecesOnEmptyBoard() {
        board = new ChessBoard();
        assertEquals(0, board.piecesCount());

        Piece pawn = Piece.createWhite(PAWN);
        String position = "a2";
        board.add(pawn, position);
        assertEquals(pawn.getRepresentation(), board.getPieceAt(position));

        position = "a3";
        Piece king = Piece.createBlack(Piece.Type.KING);
        board.add(king, position);
        assertEquals(king.getRepresentation(), board.getPieceAt(position));

    }

    @Test
    public void testCountPoints() {

        board = new ChessBoard();
        board.add(Piece.createWhite(PAWN), "f2");
        assertPoints(1, board.countWhitesPoints());

        board.add(Piece.createWhite(PAWN), "f3");
        assertPoints(1, board.countWhitesPoints());

        board.add(Piece.createWhite(KNIGHT), "f1");
        assertPoints(3.5, board.countWhitesPoints());

        board.add(Piece.createBlack(QUEEN), "e6");
        assertPoints(9, board.countBlacksPoints());

        board = new ChessBoard(createRandomBoardWithLabels());
        System.out.println(board.print());

        assertPoints(20, board.countBlacksPoints());
        assertPoints(19.5, board.countWhitesPoints());

    }

    /*
     Privates
     */
    private String createRandomBoardWithLabels() {
        return appendNewLine(".KR.....8")
                + appendNewLine("P.PB....7")
                + appendNewLine(".P..Q...6")
                + appendNewLine("........5")
                + appendNewLine(".....nq.4")
                + appendNewLine(".....p.p3")
                + appendNewLine(".....pp.2")
                + appendNewLine("....rk..1")
                + appendNewLine("abcdefgh");
    }

    private String reverseStringBoard(String inputBoard) {
        StringBuilder result = new StringBuilder();
        String[] lines = inputBoard.split(NEWLINE);
        for (int i = lines.length - 1; i >= 0; i--)
            result.append(appendNewLine(lines[i]));

        return result.toString();
    }

    private String createRandomBoard() {
        return appendNewLine(".KR.....")
                + appendNewLine("P.PB....")
                + appendNewLine(".P..Q...")
                + appendNewLine("........")
                + appendNewLine(".....nq.")
                + appendNewLine(".....p.p")
                + appendNewLine(".....pp.")
                + appendNewLine("....rk..");
    }

    private void assertPoints(final double expected, final double actual) {
        assertEquals(expected, actual, DELTA);
    }

}
