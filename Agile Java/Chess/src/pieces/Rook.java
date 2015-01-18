package pieces;

import java.util.List;

public class Rook extends Piece {

    static final char REPRESENTATION = 'r';
    private final static double DEFAULT_POINTS = 5;

    public Rook(COLOR color) {
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
