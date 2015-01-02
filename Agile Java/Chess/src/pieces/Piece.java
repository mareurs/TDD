package pieces;

/**
 *
 * A chess pawn class
 */
public class Piece {

    public static final String WHITE = "white";
    public static final String BLACK = "black";

    public static final String PAWN = "pawn";
    public static final String KNIGHT = "knight";
    public static final String ROOK = "rook";
    public static final String BISHOP = "bishop";
    public static final String QUEEN = "queen";
    public static final String KING = "king";

    public static Piece make(String name, String color) {
        return new Piece(name, color);
    }

    private final String color;
    private final String name;

    private Piece(String name, String color) {
        this.color = color;
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    boolean isWhite() {
        return color.equals(Piece.WHITE);
    }

    boolean isBlack() {
        return color.equals(Piece.BLACK);
    }

    public String getShortName() {
        switch (name) {
            case PAWN:
                return getPawnsShortName(color);
        }
        return ".";
    }

    /*
     Privates
     */
    private String getPawnsShortName(String inputColor) {
        return inputColor == WHITE ? "p" : "P";
    }

}
