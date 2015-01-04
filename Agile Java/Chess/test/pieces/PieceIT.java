package pieces;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import static pieces.Piece.*;
import static pieces.Piece.Type.*;

public class PieceIT {

    public PieceIT() {
    }

    @Test
    public void testCreate() {
        verifyCreation(
                Piece.createWhite(PAWN), Piece.createBlack(PAWN),
                PAWN, PAWN_REPRESENTATION);
        verifyCreation(
                Piece.createWhite(ROOK), Piece.createBlack(ROOK),
                ROOK, ROOK_REPRESENTATION);
        verifyCreation(
                Piece.createWhite(KNIGHT), Piece.createBlack(KNIGHT),
                KNIGHT, KNIGHT_REPRESENTATION);
        verifyCreation(
                Piece.createWhite(BISHOP), Piece.createBlack(BISHOP),
                BISHOP, BISHOP_REPRESENTATION);
        verifyCreation(Piece.createWhite(QUEEN), Piece.createBlack(QUEEN),
                QUEEN, QUEEN_REPRESENTATION);
        verifyCreation(Piece.createWhite(KING), Piece.createBlack(KING),
                KING, KING_REPRESENTATION);
        Piece blank = Piece.noPiece();
        assertEquals('.', blank.getRepresentation());
        assertEquals(NO_PIECE, blank.getType());
    }

    private void verifyCreation(Piece whitePiece, Piece blackPiece,
            Piece.Type type, char representation) {
        assertTrue(whitePiece.isWhite());
        assertEquals(type, whitePiece.getType());
        assertEquals(representation, whitePiece.getRepresentation());
        assertTrue(blackPiece.isBlack());
        assertEquals(type, blackPiece.getType());
        assertEquals(Character.toUpperCase(representation), blackPiece.getRepresentation());
    }

}
