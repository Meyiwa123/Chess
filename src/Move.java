import java.util.ArrayList;

public class Move {
    private Board board;
    private int[] index;
    public int[] selectedPieceIndex;
    public ArrayList<Square> possibleMoves;
    public Move(Board board, int[] index, ArrayList<Square> possibleMoves, int[] selectedPieceIndex) {
        this.board = board;
        this.index = index;
        this.possibleMoves = possibleMoves;
        this.selectedPieceIndex = selectedPieceIndex;
    }

    public boolean isValidMove() {
        if(possibleMoves.contains(board.getSquare(index[0],index[1]))) {
            playMove();
            return true;
        }
        return false;
    }

    public void playMove() {
        Piece piece = board.getSquare(selectedPieceIndex[0],selectedPieceIndex[1]).getPiece();
        board.getSquare(selectedPieceIndex[0],selectedPieceIndex[1]).removePiece();
        board.getSquare(index[0],index[1]).placePiece(piece);
    }

    public ArrayList<Square> generatePossibleMoves() {
        return board.getSquare(index[0],index[1]).getPiece().generatePossibleMoves(board, index);
    }

}
