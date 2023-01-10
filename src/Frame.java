import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Frame extends JFrame implements View {

    private Model model;
    private final Controller controller;
    private JButton[][] gridButtons;

    private Frame() {
        model = new Model();
        model.addView(this);
        controller = new Controller(model, this);

        initializeGame();

        this.setTitle("Not Chess");
        this.setLocationRelativeTo(null);
        this.setSize(1000,800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }

    public void initializeGame() {
        JPanel initPanel = new JPanel();
        Choice playOption = new Choice();
        playOption.add("Human vs Human");
        playOption.add("Human vs AI");
        initPanel.add(playOption);

        if(JOptionPane.showConfirmDialog(this, initPanel, "Game Configuration", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            JPanel playerPanel = new JPanel(new GridLayout(3, 2));
            JTextField player1Name = new JTextField();
            JTextField player2Name = new JTextField();
            playerPanel.add(new JLabel("(White) Player 1's name: "));
            playerPanel.add(player1Name);
            if ("Human vs Human".equals(playOption.getSelectedItem())) {
                playerPanel.add(new JLabel("(Black) Player 2's name: "));
                playerPanel.add(player2Name);
            }


            if (JOptionPane.showConfirmDialog(this, initPanel, "Player Configuration", JOptionPane.OK_OPTION) == JOptionPane.YES_OPTION) {
                createGui();
            } else {
                JOptionPane.showMessageDialog(this, "Player setup incomplete!");
            }
        }
        else{
            JOptionPane.showMessageDialog(this, "Game setup incomplete!");
            this.dispose();
        }
    }

    private void createGui() {

        JMenuBar menuBar = new JMenuBar();
        JMenu gameOptions = new JMenu("Game Options");
        JMenuItem newGame = new JMenuItem("New Game");
        newGame.setActionCommand("New Game");
        newGame.addActionListener(controller);
        JMenuItem save = new JMenuItem("Save");
        save.setActionCommand("Save");
        save.addActionListener(controller);
        JMenuItem load = new JMenuItem("Load");
        load.setActionCommand("Load");
        load.addActionListener(controller);
        JMenuItem undo = new JMenuItem("Undo");
        undo.setActionCommand("Undo");
        undo.addActionListener(controller);
        gameOptions.add(newGame);
        gameOptions.add(save);
        gameOptions.add(load);
        gameOptions.add(undo);
        menuBar.add(gameOptions);
        menuBar.setMaximumSize(new Dimension(1000,50));

        JPanel playPanel = new JPanel(new GridLayout(Board.BOARD_SIZE, Board.BOARD_SIZE));
        gridButtons = new JButton[Board.BOARD_SIZE][Board.BOARD_SIZE];
        for(int i=0; i<Board.BOARD_SIZE; i++) {
            for(int j=0; j<Board.BOARD_SIZE; j++) {
                JButton button = new JButton();
                button.setActionCommand(i + " " + j);
                button.addActionListener(controller);

                if(model.getBoard().hasPiece(i, j)) {
                    button.setIcon(model.getBoard().getIcon(i,j));
                }

                if((i+j)%2 != 0) {
                    button.setBackground(Color.BLACK);
                }
                else {
                    button.setBackground(Color.WHITE);
                }

                gridButtons[i][j] = button;
                playPanel.add(button);
            }
        }

        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
        this.add(menuBar);
        this.add(playPanel);
    }

    public void confirmNewGame() {
        int result = JOptionPane.showConfirmDialog(this,"Sure? You want to start a new game?", "New Game",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if(result == JOptionPane.YES_OPTION){
            this.dispose();
            createGui();
        }
    }

    public void notifyPlayer(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    private void updateGame(Board board, ArrayList<Square> possibleMoves) {
        this.repaint();
        for(int i=0; i<Board.BOARD_SIZE; i++) {
            for(int j=0; j<Board.BOARD_SIZE; j++) {
                if (possibleMoves.contains(board.getSquare(i,j))) {
                    gridButtons[i][j].setBackground(Color.DARK_GRAY);
                } else if((i+j)%2 != 0) {
                    gridButtons[i][j].setBackground(Color.BLACK);
                }
                else {
                    gridButtons[i][j].setBackground(Color.WHITE);
                }

                if(board.hasPiece(i, j)) {
                    gridButtons[i][j].setIcon(model.getBoard().getIcon(i,j));
                }
                else {
                    gridButtons[i][j].setIcon(null);
                }
            }
        }
    }

    public void update(Event event) {
        if(event.getStatus() == Model.GameStatus.PLAYING) {
            updateGame(event.getBoard(), event.getPossibleMoves());
        }
    }

    public static void main(String[] args) {
        new Frame();
    }
}
