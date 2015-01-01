package pieces;

/**
 *
 * A chess pawn class
 */
public class Pawn {

    public static final String WHITE = "white";
    public static final String BLACK = "black";

    private final String color;
    private Character name;

    public Pawn(String color) {
        this.color = color;
        setName(color);
    }

    public Pawn() {
        this.color = "white";
    }

    public String getColor() {
        return color;
    }

    public Character getName() {
        return name;
    }

    /*
     Privates
     */
    private void setName(String inputColor) {
        switch (inputColor) {
            case WHITE:
                this.name = 'p';
                break;
            case BLACK:
                this.name = 'P';
                break;
        }
    }

}
