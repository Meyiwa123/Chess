import java.util.ArrayList;

public class Pawn extends Piece{
    public Pawn(PieceColor pieceColor) {
        super(PieceType.PAWN, pieceColor);
    }

    public void promote(PieceType pieceType) {
        this.pieceType = pieceType;
    }

    @Override
    public ArrayList<Square> generatePossibleMoves(Board board, int[] index) {
        possibleMoves.clear();
        boolean color=true;
        if(pieceColor.equals(PieceColor.BLACK)) {
            color=false;
        }
        int dx = color ? -1 : 1;

        Square ahead = board.getSquare(index[0]+dx, index[1]);
        if (ahead.getPiece() == null) {
            possibleMoves.add(ahead);
            if (index[0] == 6 && color) {
                Square aheadsecond = board.getSquare((index[0]+dx-1), index[1]);
                if (aheadsecond.getPiece() == null) {
                    possibleMoves.add(aheadsecond);
                }
            } else if (index[0] == 1 && !color) {
                Square aheadsecond = board.getSquare(index[0]+dx+1, index[1]);
                if (aheadsecond.getPiece() == null) {
                    possibleMoves.add(aheadsecond);
                }
            }
        }
        Square aheadLeft = board.getSquare(index[0]+dx, index[1]-1);
        if (aheadLeft != null && aheadLeft.getPiece() != null && isOpponent(aheadLeft.getPiece())) {
            possibleMoves.add(aheadLeft);
        }
        Square aheadRight = board.getSquare(index[0]+dx, index[1]+1);
        if (aheadRight != null && aheadRight.getPiece() != null && isOpponent(aheadRight.getPiece())) {
            possibleMoves.add(aheadRight);
        }
        return possibleMoves;
    }
}
