import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Model {
    private Board board;
    private GameStatus status;
    private int currentPlayer;
    private ArrayList<View> views;
    public ArrayList<Square> possibleMoves;
    public int[] selectedPieceIndex;
    public enum GameStatus{PLAYING, WHITE_WON, BLACK_WON};

    public Model() {
        board = new Board();
        currentPlayer = 0;
        status = GameStatus.PLAYING;
        views = new ArrayList<>();
        possibleMoves = new ArrayList<>();
    }
    public void addView(View view) {
        views.add(view);
    }

    public void attemptPlay(int[] index) {
        if(!board.hasPiece(index[0],index[1]) && possibleMoves.isEmpty()) {
            return;
        }

        if(board.hasPiece(index[0],index[1])) {
            if(Piece.PieceColor.WHITE.equals(board.getSquare(index[0],index[1]).getPiece().pieceColor) && currentPlayer!=0 && !possibleMoves.contains(board.getSquare(index[0],index[1]))) {
                notifyViews("It's not your turn to play");
                return;
            }
            if(Piece.PieceColor.BLACK.equals(board.getSquare(index[0],index[1]).getPiece().pieceColor) && currentPlayer!=1 && !possibleMoves.contains(board.getSquare(index[0],index[1]))) {
                notifyViews("It's not your turn to play");
                return;
            }
        }

        Move move = new Move(board, index, possibleMoves, selectedPieceIndex);
        if(!possibleMoves.isEmpty()) {
            if(!move.isValidMove()) {
                notifyViews("Invalid move!");
                possibleMoves.clear();
            }
            else {
                //Play move
                possibleMoves.clear();
                currentPlayer = (currentPlayer + 1) % 2;
            }
        }
        else if(board.hasPiece(index[0],index[1])){
            selectedPieceIndex = index;
            possibleMoves = move.generatePossibleMoves();
        }
        updateViews(createEvent());
    }

    public Board getBoard() {
        return board;
    }

    private Event createEvent() {
        return new Event(this, board, possibleMoves, status);
    }

    private void updateViews(Event event) {
        for(View view : views) {
            view.update(event);
        }
    }

    private void notifyViews(String message) {
        for(View view : views) {
            view.notifyPlayer(message);
        }
    }
}
