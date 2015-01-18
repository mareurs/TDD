package chess;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import pieces.*;
import static util.StringUtil.NEWLINE;
import static util.StringUtil.appendNewLine;

public class BoardTest {

    private Board board;

    public BoardTest() {

    }

    @Before
    public void setUp() {
        board = new Board();
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
        board = new Board(inputBoard);
        assertEquals('r', board.getPieceAt("e1").getRepresentation());

        inputBoard = reverseStringBoard(inputBoard);
        board = new Board(inputBoard);
        assertEquals('n', board.getPieceAt("f4").getRepresentation());

        inputBoard = createRandomBoard();
        board = new Board(inputBoard);
        assertEquals('p', board.getPieceAt("g2").getRepresentation());
    }

    @Test
    public void testCountPieces() {
        String inputBoard = createRandomBoardWithLabels();

        board = new Board(inputBoard);
        assertEquals(3, board.countPieces('P'));
        assertEquals(4, board.countPieces('p'));
        assertEquals(1, board.countPieces('k'));
    }

    @Test
    public void testGetPieceByPosition() {
        board.initialize();
        assertEquals('R', board.getPieceAt("a8").getRepresentation());
        assertEquals('k', board.getPieceAt("e1").getRepresentation());
    }

    @Test
    public void testPlacePiecesOnEmptyBoard() {
        board = new Board();
        assertEquals(0, board.piecesCount());

        Piece pawn = new Pawn(Piece.COLOR.WHITE);
        String position = "a2";
        board.put(pawn, position);
        assertEquals(pawn.getRepresentation(), board.getPieceAt(position).getRepresentation());

        position = "a3";
        Piece king = new King(Piece.COLOR.WHITE);
        board.put(king, position);
        assertEquals(king.getRepresentation(), board.getPieceAt(position).getRepresentation());

    }


    /*
     Privates
     */
    static String createRandomBoardWithLabels() {
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

}
