import java.util.ArrayList;

public class Bishop extends Piece{
    public Bishop(PieceColor pieceColor) {
        super(PieceType.BISHOP, pieceColor);
    }

    @Override
    public ArrayList<Square> generatePossibleMoves(Board board, int[] index) {
        int row = index[0];
        int column = index[1];
        possibleMoves.clear();
        //all possible moves in the down positive diagonal
        for (int j = column + 1, i = row + 1; j < Board.BOARD_SIZE && i < Board.BOARD_SIZE; j++, i++) {
            Square square = board.getSquare(i, j);
            if (square.getPiece() == null) {
                possibleMoves.add(square);
            } else if (isOpponent(square.getPiece())) {
                possibleMoves.add(square);
                break;
            } else {
                break;
            }
        }
        //all possible moves in the up positive diagonal
        for (int j = column - 1, i = row + 1; j > -1 && i < Board.BOARD_SIZE; j--, i++) {
            Square square = board.getSquare(i, j);
            if (square.getPiece() == null) {
                possibleMoves.add(square);
            } else if (isOpponent(square.getPiece())) {
                possibleMoves.add(square);
                break;
            } else {
                break;
            }
        }
        //all possible moves in the up negative diagonal
        for (int j = column - 1, i = row - 1; j > -1 && i > -1; j--, i--) {
            Square square = board.getSquare(i, j);
            if (square.getPiece() == null) {
                possibleMoves.add(square);
            } else if (isOpponent(square.getPiece())) {
                possibleMoves.add(square);
                break;
            } else {
                break;
            }
        }
        //all possible moves in the down negative diagonal
        for (int j = column + 1, i = row - 1; j < Board.BOARD_SIZE && i > -1; j++, i--) {
            Square square = board.getSquare(i, j);
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
