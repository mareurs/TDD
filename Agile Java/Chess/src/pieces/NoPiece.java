package pieces;

import java.util.List;

public class NoPiece extends Piece {

    static final char REPRESENTATION = '.';

    public NoPiece() {
        super();
    }

    @Override
    public double getPoints() {
        return 0;
    }

    @Override
    public char getRepresentation() {
        return REPRESENTATION;
    }

    @Override
    List<String> getPossibleMoves(String position) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
