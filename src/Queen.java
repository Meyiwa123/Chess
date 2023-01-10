import java.util.ArrayList;

public class Queen extends Piece{
    public Queen(PieceColor pieceColor) {
        super(PieceType.QUEEN, pieceColor);
    }

    @Override
    public ArrayList<Square> generatePossibleMoves(Board board, int[] index) {
        possibleMoves.clear();
        Piece[] pieces = {
                new Rook(pieceColor),
                new Bishop(pieceColor)
        };
        for (Piece piece : pieces) {
            possibleMoves.addAll(piece.generatePossibleMoves(board, index));
        }
        return possibleMoves;
    }
}
