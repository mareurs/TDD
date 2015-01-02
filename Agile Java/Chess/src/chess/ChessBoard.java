package chess;

import java.util.ArrayList;
import java.util.List;
import pieces.Piece;
import util.StringUtil;

/**
 *
 * A board of pawns
 */
class ChessBoard {

    static private final int PIECES_PER_RANK = 8;
    static private final int RANKS_PER_BOARD = 8;

    private int piecesCount;
    private final List<Piece> pieces = new ArrayList<>();
    private final List<List<Piece>> allRanks = new ArrayList<>();

    ChessBoard() {
    }

    public void initialize() {
        addEmptyRanks();
        addOtherRank(Piece.WHITE);
        addPawnRank(Piece.WHITE);
        addPawnRank(Piece.BLACK);
        addOtherRank(Piece.BLACK);
    }

    int piecesCount() {
        return piecesCount;
    }

    List<Piece> getPieces() {
        return pieces;
    }

    String printRank(int index) {
        List<Piece> rank = allRanks.get(index - 1);
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < PIECES_PER_RANK; i++)
            result.append(rank.get(i).getShortName());

        return result.toString();
    }

    String print() {
        StringBuilder result = new StringBuilder();
        for (int i = RANKS_PER_BOARD - 1; i >= 0; i--) {
            List<Piece> rank = allRanks.get(i);
            for (int j = 0; j < PIECES_PER_RANK; j++) {
                Piece piece = rank.get(i);
                if (piece == null)
                    result.append(".");
                else
                    result.append(piece.getShortName());
            }
            if (i != 0)
                result.append(StringUtil.NEWLINE);
        }

        return result.toString();
    }


    /*
     Privates
     */
    private void addEmptyRanks() {
        for (int i = 0; i < RANKS_PER_BOARD; i++) {
            List<Piece> newRank = new ArrayList<>();
            for (int j = 0; j < PIECES_PER_RANK; j++)
                newRank.add(null);
            allRanks.add(newRank);
        }
    }

    private void addPawnRank(final String color) {
        List<Piece> pawnRank = new ArrayList<>();
        for (int i = 0; i < PIECES_PER_RANK; i++) {
            pawnRank.add(Piece.make(Piece.PAWN, color));
            piecesCount++;
        }
        if (color.equals(Piece.WHITE))
            allRanks.set(1, pawnRank);
        else
            allRanks.set(6, pawnRank);
    }

    private void addOtherRank(final String color) {
        List<Piece> rank = makeFigurePieces(color);
        piecesCount += 8;
        if (color.equals(Piece.WHITE))
            allRanks.set(0, rank);
        else
            allRanks.set(7, rank);
    }

    private List<Piece> makeFigurePieces(final String color) {
        List<Piece> rank = new ArrayList<>();
        rank.add(Piece.make(Piece.ROOK, color));
        rank.add(Piece.make(Piece.KNIGHT, color));
        rank.add(Piece.make(Piece.BISHOP, color));
        rank.add(Piece.make(Piece.QUEEN, color));
        rank.add(Piece.make(Piece.KING, color));
        rank.add(Piece.make(Piece.BISHOP, color));
        rank.add(Piece.make(Piece.KNIGHT, color));
        rank.add(Piece.make(Piece.ROOK, color));
        return rank;
    }

}
