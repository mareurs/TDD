package pieces;

/**
 *
 * A chess pawn class
 */
public class Piece implements Comparable<Piece> {

    static final char PAWN_REPRESENTATION = 'p';
    static final char ROOK_REPRESENTATION = 'r';
    static final char KNIGHT_REPRESENTATION = 'n';
    static final char BISHOP_REPRESENTATION = 'b';
    static final char QUEEN_REPRESENTATION = 'q';
    static final char KING_REPRESENTATION = 'k';
    static final char NO_PIECE_REPRESENTATION = '.';

    private final COLOR color;
    private final Type type;
    private double points = 0;

    private static enum COLOR {

        WHITE, BLACK;
    }

    public static enum Type {

        PAWN, KNIGHT, ROOK, BISHOP, QUEEN, KING, NO_PIECE
    }

    static public Piece createWhite(Type type) {
        return new Piece(type, COLOR.WHITE);
    }

    static public Piece createBlack(Type type) {
        return new Piece(type, COLOR.BLACK);
    }

    static public Piece noPiece() {
        return new Piece(Piece.Type.NO_PIECE, null);
    }

    public static Piece createPieceByRepresentation(char p) {
        Type type = charToType(p);
        COLOR color = Character.isLowerCase(p) ? COLOR.WHITE : COLOR.BLACK;
        if (type == Type.NO_PIECE)
            color = null;
        return new Piece(type, color);
    }

    private Piece(Type type, COLOR color) {
        this.color = color;
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public boolean isWhite() {
        return (color != null && color.equals(COLOR.WHITE));
    }

    public boolean isBlack() {
        return (color != null && color.equals(COLOR.BLACK));
    }

    public char getRepresentation() {
        switch (type) {
            case PAWN:
                return getPawnsShortName(color);
            case KNIGHT:
                return getKnightShortName(color);
            case ROOK:
                return getRookShortName(color);
            case BISHOP:
                return getBishopShortName(color);
            case QUEEN:
                return getQueenShortName(color);
            case KING:
                return getKingShortName(color);

        }
        return NO_PIECE_REPRESENTATION;
    }

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    @Override
    public int compareTo(Piece other) {
        return Double.compare(this.points, other.points);
    }

    /*
     Privates
     */
    private char getPawnsShortName(COLOR inputColor) {
        return inputColor == COLOR.WHITE ? PAWN_REPRESENTATION : Character.toUpperCase(PAWN_REPRESENTATION);
    }

    private char getKnightShortName(COLOR inputColor) {
        return inputColor == COLOR.WHITE ? KNIGHT_REPRESENTATION : Character.toUpperCase(KNIGHT_REPRESENTATION);
    }

    private char getRookShortName(COLOR inputColor) {
        return inputColor == COLOR.WHITE ? ROOK_REPRESENTATION : Character.toUpperCase(ROOK_REPRESENTATION);
    }

    private char getBishopShortName(COLOR inputColor) {
        return inputColor == COLOR.WHITE ? BISHOP_REPRESENTATION : Character.toUpperCase(BISHOP_REPRESENTATION);
    }

    private char getQueenShortName(COLOR inputColor) {
        return inputColor == COLOR.WHITE ? QUEEN_REPRESENTATION : Character.toUpperCase(QUEEN_REPRESENTATION);
    }

    private char getKingShortName(COLOR inputColor) {
        return inputColor == COLOR.WHITE ? KING_REPRESENTATION : Character.toUpperCase(KING_REPRESENTATION);
    }

    private static Type charToType(char p) {
        switch (Character.toLowerCase(p)) {
            case PAWN_REPRESENTATION:
                return Type.PAWN;
            case ROOK_REPRESENTATION:
                return Type.ROOK;
            case BISHOP_REPRESENTATION:
                return Type.BISHOP;
            case KNIGHT_REPRESENTATION:
                return Type.KNIGHT;
            case QUEEN_REPRESENTATION:
                return Type.QUEEN;
            case KING_REPRESENTATION:
                return Type.KING;
            case NO_PIECE_REPRESENTATION:
                return Type.NO_PIECE;
        }
        throw new InvalidTypeException();
    }

    private static class InvalidTypeException extends RuntimeException {

        public InvalidTypeException() {
        }
    }

}
