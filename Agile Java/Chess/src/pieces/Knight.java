package pieces;

import java.util.List;

public class Knight extends Piece {

    static private final double DEFAULT_POINTS = 2.5;
    static final char REPRESENTATION = 'n';

    public Knight(COLOR color) {
        super(color);
    }

    @Override
    public double getPoints() {
        return DEFAULT_POINTS;
    }

    @Override
    List<String> getPossibleMoves(String position) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public char getRepresentation() {
        return isWhite() ? REPRESENTATION : Character.toUpperCase(REPRESENTATION);
    }

}
