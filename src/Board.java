import javax.swing.*;
import java.text.Bidi;

public class Board {
    private Square[][] grid;
    public static final int BOARD_SIZE = 8;

    public Board() {
        createBoard();
        createPieces();
    }

    private void createBoard() {
        grid = new Square[BOARD_SIZE][BOARD_SIZE];
        for(int i=0; i<BOARD_SIZE; i++) {
            for(int j=0; j<BOARD_SIZE; j++) {
                grid[i][j] = new Square(Square.SquareColor.WHITE);
            }
        }
    }

    private void createPieces() {
        grid[0][0].placePiece(new Rook(Piece.PieceColor.BLACK));
        grid[0][1].placePiece(new Knight(Piece.PieceColor.BLACK));
        grid[0][2].placePiece(new Bishop(Piece.PieceColor.BLACK));
        grid[0][3].placePiece(new Queen(Piece.PieceColor.BLACK));
        grid[0][4].placePiece(new King(Piece.PieceColor.BLACK));
        grid[0][5].placePiece(new Bishop(Piece.PieceColor.BLACK));
        grid[0][6].placePiece(new Knight(Piece.PieceColor.BLACK));
        grid[0][7].placePiece(new Rook(Piece.PieceColor.BLACK));
        for(int i=0; i<8; i++) {
            grid[1][i].placePiece(new Pawn(Piece.PieceColor.BLACK));
        }

        grid[7][0].placePiece(new Rook(Piece.PieceColor.WHITE));
        grid[7][1].placePiece(new Knight(Piece.PieceColor.WHITE));
        grid[7][2].placePiece(new Bishop(Piece.PieceColor.WHITE));
        grid[7][3].placePiece(new Queen(Piece.PieceColor.WHITE));
        grid[7][4].placePiece(new King(Piece.PieceColor.WHITE));
        grid[7][5].placePiece(new Bishop(Piece.PieceColor.WHITE));
        grid[7][6].placePiece(new Knight(Piece.PieceColor.WHITE));
        grid[7][7].placePiece(new Rook(Piece.PieceColor.WHITE));
        for(int i=0; i<8; i++) {
            grid[6][i].placePiece(new Pawn(Piece.PieceColor.WHITE));
        }
    }

    public ImageIcon getIcon(int i, int j) {
        return grid[i][j].getIcon();
    }

    public String getSquareColor(int i, int j) {
        return grid[i][j].getSquareColor();
    }

    public Square getSquare(int i, int j) {
        try {
            return grid[i][j];
        }
        catch (ArrayIndexOutOfBoundsException e) {
        }
        return null;
    }

    public boolean hasPiece(int i, int j) {
        return grid[i][j].hasPiece();
    }
}
