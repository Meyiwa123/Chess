import java.util.ArrayList;
import java.util.EventObject;

public class Event extends EventObject {

    private Board board;
    private Model.GameStatus status;
    private ArrayList<Square> possibleMoves;

    public Event(Model model, Board board, ArrayList<Square> possibleMoves, Model.GameStatus status) {
        super(model);
        this.board = board;
        this.status = status;
        this.possibleMoves = possibleMoves;
    }

    public Board getBoard() {
        return board;
    }

    public Model.GameStatus getStatus() {
        return status;
    }
    public ArrayList<Square> getPossibleMoves() {return possibleMoves;}
}
