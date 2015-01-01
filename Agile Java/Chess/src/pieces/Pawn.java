package pieces;

/**
 * 
 * A chess pawn class
 */
public class Pawn
{
    public static final String WHITE = "white";
    public static final String BLACK = "black";
    
    
    private final String color;
    
    public Pawn(String color) {
        this.color = color;
    }

    public Pawn()
    {
        this.color = "white";
    }
    
    public String getColor() {
        return color;
    }
    
}

