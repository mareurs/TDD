package pieces;

import java.util.List;

public class Pawn extends Piece {

    static final char REPRESENTATION = 'p';
    static private final double DEFAULT_POINTS = 1;
    static private final double HANDICAPPED_POINTS = 0.5;

    private boolean isHandicappedPawn = false;

    public Pawn(COLOR color) {
        super(color);
    }

    public void setAsHandicappedPawn() {
        this.isHandicappedPawn = true;
    }

    @Override
    public double getPoints() {
        return isHandicappedPawn ? HANDICAPPED_POINTS : DEFAULT_POINTS;
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
