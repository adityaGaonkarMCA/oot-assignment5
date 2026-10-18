import java.awt.*;
import javax.swing.*;

// The screen where the 3x3 game is played.
public class GameScreen extends Screen {
    private Board board = new Board();
    private Player playerX = new Player("Player 1", 'X');
    private Player playerO = new Player("Player 2", 'O');
    private Player currentPlayer;
    private JButton[][] buttons = new JButton[3][3];
    private JLabel statusLabel;
    private boolean gameOver;

    public GameScreen(ScreenChanger changer) {
        super(changer);
        buildScreen();
        startNewGame();
    }

    @Override
    protected void buildScreen() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        statusLabel = makeLabel("", 24);
        add(statusLabel, BorderLayout.NORTH);

        JPanel grid = new JPanel(new GridLayout(3, 3, 8, 8));
        grid.setBackground(new Color(30, 30, 50));

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                final int row = r;   // copies, needed to use inside the lambda
                final int col = c;
                JButton b = new JButton("");
                b.setFont(new Font("Arial", Font.BOLD, 60));
                b.setFocusPainted(false);
                b.addActionListener(e -> handleClick(row, col));
                buttons[r][c] = b;
                grid.add(b);
            }
        }
        add(grid, BorderLayout.CENTER);
    }

    // Called every time (also for "Play Again") to begin a fresh game
    public void startNewGame() {
        board.reset();
        currentPlayer = playerX;
        gameOver = false;
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                buttons[r][c].setText("");
            }
        }
        updateStatus();
    }

    private void handleClick(int row, int col) {
        if (gameOver) return;   // ignore clicks after the game has ended

        char symbol = currentPlayer.getSymbol();
        if (!board.placeMark(row, col, symbol)) {
            return;             // cell already used
        }
        buttons[row][col].setText(String.valueOf(symbol));
        buttons[row][col].setForeground(symbol == 'X' ? Color.RED : Color.BLUE);

        if (board.hasWon(symbol)) {
            gameOver = true;
            showResultAfterDelay(true);
        } else if (board.isFull()) {
            gameOver = true;
            showResultAfterDelay(false);
        } else {
            switchPlayer();
        }
    }

    // Wait a little so players can see the last move, then open the result screen
    private void showResultAfterDelay(boolean someoneWon) {
        Timer timer = new Timer(800, e -> {
            if (someoneWon) {
                changer.showResult(currentPlayer);
            } else {
                changer.showResult();
            }
        });
        timer.setRepeats(false);
        timer.start();
    }

    private void switchPlayer() {
        if (currentPlayer == playerX) {
            currentPlayer = playerO;
        } else {
            currentPlayer = playerX;
        }
        updateStatus();
    }

    private void updateStatus() {
        statusLabel.setText(currentPlayer.getName() + "'s turn (" + currentPlayer.getSymbol() + ")");
    }
}
