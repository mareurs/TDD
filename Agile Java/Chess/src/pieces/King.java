package pieces;

import chess.Board;
import java.util.ArrayList;
import java.util.List;

public class King extends Piece {

    static final char REPRESENTATION = 'k';
    private static final double DEFAULT_POINTS = 0;

    public King(COLOR color) {
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
        return getKingPossibleMoves(position);
    }

    /*
     Privates
     */
    private List<String> getKingPossibleMoves(String position) {
        List<String> result = new ArrayList<>();
        int rank = Board.getRankFromPosition(position);
        int file = Board.getFileFromPosition(position);

        if (isValidPosition(rank + 1, file))
            result.add(Board.positionToString(rank + 1, file));
        if (isValidPosition(rank - 1, file))
            result.add(Board.positionToString(rank - 1, file));
        if (isValidPosition(rank, file - 1))
            result.add(Board.positionToString(rank, file - 1));
        if (isValidPosition(rank, file + 1))
            result.add(Board.positionToString(rank, file + 1));
        if (isValidPosition(rank - 1, file - 1))
            result.add(Board.positionToString(rank - 1, file - 1));
        if (isValidPosition(rank - 1, file + 1))
            result.add(Board.positionToString(rank - 1, file + 1));
        if (isValidPosition(rank + 1, file - 1))
            result.add(Board.positionToString(rank + 1, file - 1));
        if (isValidPosition(rank + 1, file + 1))
            result.add(Board.positionToString(rank + 1, file + 1));

        return result;
    }

    private boolean isValidPosition(int rank, int file) {
        return (rank >= 0 && rank < 8 && file >= 0 && file < 8);
    }

}
