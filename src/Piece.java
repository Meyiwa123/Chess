import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

public abstract class Piece {

    private ImageIcon icon;
    PieceType pieceType;
    public PieceColor pieceColor;
    public ArrayList<Square> possibleMoves;

    public enum PieceColor {WHITE, BLACK}
    public enum PieceType {KING, ROOK, BISHOP, QUEEN, KNIGHT, PAWN};

    public Piece(PieceType pieceType, PieceColor pieceColor) {
        this.pieceType = pieceType;
        this.pieceColor = pieceColor;
        possibleMoves = new ArrayList<>();
        setIcon();
    }

    private void setIcon() {
        File image = new File("src/Graphics/" + pieceType.toString() + "_" + pieceColor.toString() + ".png");
        if(!image.exists()) {
            image = new File("src/Graphics/UNAVAILABLE.png");
        }
        Image resizedImage = (new ImageIcon(image.toString())).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        icon = new ImageIcon(resizedImage);
    }

    public boolean isOpponent(Piece piece) {
        if(pieceColor.equals(piece.pieceColor)) {
            return false;
        }
        return true;
    }

    public abstract ArrayList<Square> generatePossibleMoves(Board board, int[] index);
    public ImageIcon getIcon() {
        return icon;
    }
}
