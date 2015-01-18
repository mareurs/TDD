package chess;

import java.util.*;
import pieces.Pawn;
import pieces.Piece;

public class Game {

    private final Board board;
    private final List<Piece> whitePieces = new ArrayList<>();
    private final List<Piece> blackPieces = new ArrayList<>();

    public Game() {
        board = new Board();
    }

    public Game(String initialGame) {
        board = new Board(initialGame);
    }

    void initializeWithNewGame() {
        this.board.initialize();
    }

    void put(Piece piece, String position) {
        board.put(piece, position);
    }

    double countWhitesPoints() {
        double total = 0;
        setPointsForAllPieces();
        updatePieceColections();

        for (Piece piece : whitePieces)
            total += piece.getPoints();

        return total;
    }

    double countBlacksPoints() {
        double total = 0;
        setPointsForAllPieces();
        updatePieceColections();

        for (Piece piece : blackPieces)
            total += piece.getPoints();

        return total;
    }

    String print() {
        return board.print();
    }


    /*
     Privates
     */
    private void updatePieceColections() {
        whitePieces.clear();
        blackPieces.clear();

        for (int i = 0; i < Board.RANKS_PER_BOARD; i++)
            for (int j = 0; j < Board.PIECES_PER_RANK; j++) {
                Piece piece = board.getPieceAt(i, j);
                if (piece.isWhite())
                    whitePieces.add(piece);
                else if (piece.isBlack())
                    blackPieces.add(piece);
            }
        Collections.sort(whitePieces);
        Collections.sort(blackPieces);
    }

    private void setPointsForAllPieces() {
        for (int i = 0; i < Board.RANKS_PER_BOARD; i++)
            for (int j = 0; j < Board.PIECES_PER_RANK; j++) {
                Piece piece = board.getPieceAt(i, j);
                if (piece.getClass() == Pawn.class)
                    checkIfHandicappedPawn(piece, j);
            }
    }

    private void checkIfHandicappedPawn(Piece piece, int file) {
        int pawnCount = 0;
        boolean isWhite = piece.isWhite();
        Pawn pawn = (Pawn) piece;

        for (int i = 0; i < Board.RANKS_PER_BOARD; i++) {
            Pawn p = (Pawn) board.getPieceAt(i, file);
            if (p.isWhite() == isWhite)
                pawnCount++;
        }
        if (pawnCount > 1)
            pawn.setAsHandicappedPawn();
    }

}
