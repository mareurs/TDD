package chess;

import java.util.ArrayList;
import java.util.List;
import pieces.Pawn;

/**
 *
 * A board of pawns
 */
class ChessBoard {

    static private final int PIECES_PER_RANK = 8;
    static private final int RANKS_PER_BOARD = 8;
    static private final String NEW_LINE = System.getProperty("line.separator");

    private int piecesCount;
    private final List<Pawn> pieces = new ArrayList<>();
    private final List<List<Pawn>> allRanks = new ArrayList<>();

    ChessBoard() {
        initialize();
    }

    private void initialize() {
        addEmptyRanks();
        addWhitePawns();
        addBlackPawns();
    }

    int getPiecesCount() {
        return piecesCount;
    }

    final void add(Pawn pawn) {
        piecesCount++;
        pieces.add(pawn);
    }

    List<Pawn> getPieces() {
        return pieces;
    }

    String printRank(int index) {
        List<Pawn> rank = allRanks.get(index - 1);
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < PIECES_PER_RANK; i++)
            result.append(rank.get(i).getName());

        return result.toString();
    }

    /*
     Privates
     */
    private void addEmptyRanks() {
        for (int i = 0; i < RANKS_PER_BOARD; i++) {
            List<Pawn> newRank = new ArrayList<>();
            for (int j = 0; j < PIECES_PER_RANK; j++)
                newRank.add(null);
            allRanks.add(newRank);
        }

    }

    private void addBlackPawns() {
        List<Pawn> seventhRank = new ArrayList<>();
        for (int i = 0; i < PIECES_PER_RANK; i++) {
            seventhRank.add(new Pawn(Pawn.BLACK));
            piecesCount++;
        }
        allRanks.set(6, seventhRank);
    }

    private void addWhitePawns() {
        List<Pawn> secondRank = new ArrayList<>();
        for (int i = 0; i < PIECES_PER_RANK; i++) {
            secondRank.add(new Pawn(Pawn.WHITE));
            piecesCount++;
        }
        allRanks.set(1, secondRank);
    }

    String printBoard() {
        StringBuilder result = new StringBuilder();
        for (int i = RANKS_PER_BOARD - 1; i >= 0; i--) {
            List<Pawn> rank = allRanks.get(i);
            for (int j = 0; j < PIECES_PER_RANK; j++) {
                Pawn piece = rank.get(i);
                if (piece == null)
                    result.append(".");
                else
                    result.append(piece.getName());
            }
            if (i != 0)
                result.append(NEW_LINE);
        }

        return result.toString();
    }

}
