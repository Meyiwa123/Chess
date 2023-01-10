import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Controller implements ActionListener {

    private Model model;
    private Frame frame;

    public Controller(Model model, Frame frame) {
        this.model = model;
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(Objects.equals(e.getActionCommand(), "New Game")) {
            frame.confirmNewGame();
        }
        else if(Objects.equals(e.getActionCommand(), "Save")) {}
        else if(e.getActionCommand() == "Load") {}
        else if(e.getActionCommand() == "Undo") {}
        else{
            String[] input=e.getActionCommand().split(" ");
            int x =Integer.parseInt(input[0]);
            int y =Integer.parseInt(input[1]);
            int index[] = new int[2];
            index[0] = x;
            index[1] = y;

            model.attemptPlay(index);
        }
    }
}
