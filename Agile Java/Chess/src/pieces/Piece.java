package pieces;

import java.util.List;
import static pieces.Piece.COLOR.BLACK;
import static pieces.Piece.COLOR.WHITE;

/**
 *
 * A chess piece class
 */
public abstract class Piece implements Comparable<Piece> {

    public static Piece createPieceByRepresentation(char inputPiece) {
        char p = Character.toLowerCase(inputPiece);
        boolean isWhite = Character.isLowerCase(inputPiece);

        if (p == Pawn.REPRESENTATION)
            return isWhite ? new Pawn(WHITE) : new Pawn(BLACK);
        if (p == King.REPRESENTATION)
            return isWhite ? new King(WHITE) : new King(BLACK);
        if (p == Queen.REPRESENTATION)
            return isWhite ? new Queen(WHITE) : new Queen(BLACK);
        if (p == Knight.REPRESENTATION)
            return isWhite ? new Knight(WHITE) : new Knight(BLACK);
        if (p == Bishop.REPRESENTATION)
            return isWhite ? new Bishop(WHITE) : new Bishop(BLACK);
        if (p == Rook.REPRESENTATION)
            return isWhite ? new Rook(WHITE) : new Rook(BLACK);
        if (p == NoPiece.REPRESENTATION)
            return new NoPiece();

        throw new InvalidPieceException();
    }

    protected final COLOR color;

    public static enum COLOR {

        WHITE, BLACK;
    }

    protected Piece() {
        this.color = null;
    }

    protected Piece(COLOR color) {
        this.color = color;
    }

//    public static enum Type {
//
//        PAWN(1), KNIGHT(2.5), BISHOP(3), ROOK(5), QUEEN(9), KING(0), NO_PIECE(0);
//        private final double points;
//
//        private Type(double points) {
//            this.points = points;
//        }
//
//        private double getPoints() {
//            return points;
//        }
//
//
//    }
//    static public Piece createWhite() {
//        return new Piece(type, COLOR.WHITE);
//    }
//
//    static public Piece createBlack(Type type) {
//        return new Piece(type, COLOR.BLACK);
//    }
//
//    static public Piece noPiece() {
//        return new Piece(Piece.Type.NO_PIECE, null);
//    }
//
//    public static Piece createPieceByRepresentation(char p) {
//        Type type = charToType(p);
//        COLOR color = Character.isLowerCase(p) ? COLOR.WHITE : COLOR.BLACK;
//        if (type == Type.NO_PIECE)
//            color = null;
//
//        return new Piece(type, color);
//    }
//
//    protected Piece(Type type, COLOR color) {
//        this.color = color;
//        this.type = type;
//    }
//
//    public Type getType() {
//        return type;
//    }
    abstract public double getPoints();

    abstract public char getRepresentation();

    abstract List<String> getPossibleMoves(String position);

    public boolean isWhite() {
        return (color != null && color.equals(COLOR.WHITE));
    }

    public boolean isBlack() {
        return (color != null && color.equals(COLOR.BLACK));
    }

    @Override
    public int compareTo(Piece other) {
        return Double.compare(this.getPoints(), other.getPoints());
    }

    private static class InvalidPieceException extends RuntimeException {

    }

}
