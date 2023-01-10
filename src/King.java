import java.util.ArrayList;
import java.util.List;

public class King extends Piece{
    public King(PieceColor pieceColor) {
        super(PieceType.KING, pieceColor);
    }

    @Override
    public ArrayList<Square> generatePossibleMoves(Board board, int[] index) {
        possibleMoves.clear();
        List<Square> moves = new ArrayList<>();
        int[][] offsets = {
                {1, 0},
                {0, 1},
                {-1, 0},
                {0, -1},
                {1, 1},
                {-1, 1},
                {-1, -1},
                {1, -1}
        };
        for (int[] o : offsets) {
            Square square = board.getSquare(index[0]+o[0], index[1]+o[1]);
            if (square != null && (square.getPiece() == null || isOpponent(square.getPiece()))) {
                moves.add(square);
            }
        }
        possibleMoves.addAll(moves);
        return possibleMoves;
    }
}
