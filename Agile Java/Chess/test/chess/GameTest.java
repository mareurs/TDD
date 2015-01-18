package chess;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import pieces.*;
import static pieces.Piece.COLOR.BLACK;
import static pieces.Piece.COLOR.WHITE;

public class GameTest {

    static private final double DELTA = 0.001;

    private Game game;

    public GameTest() {
    }

    @Test
    public void testCreate() {
        game = new Game();
    }

    @Test
    public void testCountPoints() {
        game = new Game();
        game.put(new Pawn(WHITE), "f2");
        assertPoints(1, game.countWhitesPoints());

        game.put(new Pawn(WHITE), "f3");
        assertPoints(1, game.countWhitesPoints());

        game.put(new Knight(WHITE), "f1");
        assertPoints(3.5, game.countWhitesPoints());
        game.put(new Queen(BLACK), "e6");
        assertPoints(9, game.countBlacksPoints());

        game = new Game(BoardTest.createRandomBoardWithLabels());
        System.out.println(game.print());

        assertPoints(20, game.countBlacksPoints());
        assertPoints(19.5, game.countWhitesPoints());
    }

    /*
     Privates
     */
    private void assertPoints(final double expected, final double actual) {
        assertEquals(expected, actual, DELTA);
    }

}
