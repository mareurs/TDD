package chess;

import pieces.Pawn;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * A board of pawns
 */
class ChessBoard {
    private int piecesCount;
    private final List<Pawn> pieces = new ArrayList<>();
    
    int getPiecesCount() {
        return piecesCount;
    }

    void add(Pawn pawn) {
        piecesCount++;
        pieces.add(pawn);
    }

    List<Pawn> getPieces() {
        return pieces;
    }
    
}

