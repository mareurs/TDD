package pieces;

import chess.Board;
import java.util.ArrayList;
import java.util.List;

public class Queen extends Piece {

    static final char REPRESENTATION = 'q';
    static private final double DEFAULT_POINTS = 9;

    public Queen(COLOR color) {
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
        int rank = Board.getRankFromPosition(position);
        int file = Board.getFileFromPosition(position);
        List<String> allMoves = new ArrayList<>();

        allMoves.addAll(removeLastElement(getQueenMovesUp(rank, file)));
        allMoves.addAll(removeLastElement(getQueenMovesDown(rank, file)));
        allMoves.addAll(removeLastElement(getQueenMovesLefts(rank, file)));
        allMoves.addAll(removeLastElement(getQueenMovesRights(rank, file)));
        allMoves.addAll(removeLastElement(getQueenMovesUpLefts(rank, file)));
        allMoves.addAll(removeLastElement(getQueenMovesUpRights(rank, file)));
        allMoves.addAll(removeLastElement(getQueenMovesDownLefts(rank, file)));
        allMoves.addAll(removeLastElement(getQueenMovesDownRights(rank, file)));

        return allMoves;
    }

    /*
     Privates
     */
    private List<String> removeLastElement(List<String> list) {
        list.remove(list.size() - 1);
        return list;
    }

    private List<String> getQueenMovesUp(int rank, int file) {
        List<String> result = new ArrayList();
        if (rank < 7)
            result.addAll(getQueenMovesUp(rank + 1, file));
        result.add(Board.positionToString(rank, file));
        return result;
    }

    private List<String> getQueenMovesDown(int rank, int file) {
        List<String> result = new ArrayList();
        if (rank > 0)
            result.addAll(getQueenMovesDown(rank - 1, file));
        result.add(Board.positionToString(rank, file));
        return result;
    }

    private List<String> getQueenMovesLefts(int rank, int file) {
        List<String> result = new ArrayList();
        if (file > 0)
            result.addAll(getQueenMovesLefts(rank, file - 1));
        result.add(Board.positionToString(rank, file));
        return result;
    }

    private List<String> getQueenMovesRights(int rank, int file) {
        List<String> result = new ArrayList();
        if (file < 7)
            result.addAll(getQueenMovesRights(rank, file + 1));
        result.add(Board.positionToString(rank, file));
        return result;
    }

    private List<String> getQueenMovesUpLefts(int rank, int file) {
        List<String> result = new ArrayList();
        if (rank < 7 && file > 0)
            result.addAll(getQueenMovesUpLefts(rank + 1, file - 1));
        result.add(Board.positionToString(rank, file));
        return result;
    }

    private List<String> getQueenMovesUpRights(int rank, int file) {
        List<String> result = new ArrayList();
        if (rank < 7 && file < 7)
            result.addAll(getQueenMovesUpRights(rank + 1, file + 1));
        result.add(Board.positionToString(rank, file));
        return result;
    }

    private List<String> getQueenMovesDownLefts(int rank, int file) {
        List<String> result = new ArrayList();
        if (rank > 0 && file > 0)
            result.addAll(getQueenMovesDownLefts(rank - 1, file - 1));
        result.add(Board.positionToString(rank, file));
        return result;
    }

    private List<String> getQueenMovesDownRights(int rank, int file) {
        List<String> result = new ArrayList();
        if (rank > 0 && file < 7)
            result.addAll(getQueenMovesDownRights(rank - 1, file + 1));
        result.add(Board.positionToString(rank, file));
        return result;
    }

}
