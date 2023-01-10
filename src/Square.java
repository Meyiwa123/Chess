import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Square {

    private Piece piece;
    private ImageIcon icon;
    private final SquareColor squareColor;
    public enum SquareColor {WHITE, BLACK, DARK_BROWN};

    public Square(SquareColor squareColor) {
        this.squareColor = squareColor;
    }

    public ImageIcon getIcon() {
        return icon;
    }
    public Piece getPiece() {return piece;}

    public String getSquareColor() {
        return squareColor.toString();
    }

    public void placePiece(Piece piece) {
        this.piece = piece;
        icon = piece.getIcon();
    }

    public void removePiece() {
        piece = null;
        icon = null;
    }

    public boolean hasPiece() {
        if(piece==null) {
            return false;
        }
        return true;
    }

}
