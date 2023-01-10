import java.util.ArrayList;

public class Knight extends Piece{
    public Knight(PieceColor pieceColor) {
        super(PieceType.KNIGHT, pieceColor);
    }

    @Override
    public ArrayList<Square> generatePossibleMoves(Board board, int[] index) {
        possibleMoves.clear();
        int[][] offsets = {
                {-2, 1},
                {-1, 2},
                {1, 2},
                {2, 1},
                {2, -1},
                {1, -2},
                {-1, -2},
                {-2, -1}
        };
        for (int[] o : offsets) {
            Square square = board.getSquare(index[0]+o[0], index[1]+o[1]);
            if (square != null && (!square.hasPiece() || isOpponent(square.getPiece()))) {
                possibleMoves.add(square);
            }
        }
        return possibleMoves;
    }
}
