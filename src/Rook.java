import java.util.ArrayList;

public class Rook extends Piece{
    public Rook(PieceColor pieceColor) {
        super(PieceType.ROOK, pieceColor);
    }

    @Override
    public ArrayList<Square> generatePossibleMoves(Board board, int[] index) {
        int row = index[0];
        int column = index[1];
        possibleMoves.clear();
        //all possible moves in the up
        for (int i = row + 1; i < Board.BOARD_SIZE; i++) {
            Square square = board.getSquare(i, column);
            if (square.getPiece() == null) {
                possibleMoves.add(square);
            } else if (isOpponent(square.getPiece())) {
                possibleMoves.add(square);
                break;
            } else {
                break;
            }
        }
        //all possible moves in the down
        for (int i = row - 1; i > -1; i--) {
            Square square = board.getSquare(i, column);
            if (square.getPiece() == null) {
                possibleMoves.add(square);
            } else if (isOpponent(square.getPiece())) {
                possibleMoves.add(square);
                break;
            } else {
                break;
            }
        }
        //all possible moves to the right
        for (int i = column + 1; i < Board.BOARD_SIZE; i++) {
            Square square = board.getSquare(row, i);
            if (square.getPiece() == null) {
                possibleMoves.add(square);
            } else if (isOpponent(square.getPiece())) {
                possibleMoves.add(square);
                break;
            } else {
                break;
            }
        }
        //all possible moves to the left
        for (int i = column - 1; i > -1; i--) {
            Square square = board.getSquare(row, i);
            if (square.getPiece() == null) {
                possibleMoves.add(square);
            } else if (isOpponent(square.getPiece())) {
                possibleMoves.add(square);
                break;
            } else {
                break;
            }
        }
        return possibleMoves;
    }
}
