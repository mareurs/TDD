package pieces;

import java.util.List;

public class Bishop extends Piece {

    static final char REPRESENTATION = 'b';
    static private final double DEFAULT_POINTS = 3;

    public Bishop(COLOR color) {
        super(color);
    }

    @Override
    public double getPoints() {
        return DEFAULT_POINTS;
    }

    @Override
    public char getRepresentation() {
        return isWhite() ? REPRESENTATION : Character.toUpperCase(REPRESENTATION);
    }

    @Override
    List<String> getPossibleMoves(String position) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
