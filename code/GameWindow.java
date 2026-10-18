import java.awt.*;
import javax.swing.*;

// The main window. It extends JFrame and implements our ScreenChanger interface.
// It keeps all 3 screens and switches between them using CardLayout.
public class GameWindow extends JFrame implements ScreenChanger {
    private CardLayout cardLayout = new CardLayout();
    private JPanel container = new JPanel(cardLayout);

    private MenuScreen menuScreen;
    private GameScreen gameScreen;
    private ResultScreen resultScreen;

    public GameWindow() {
        setTitle("XO Game");
        setSize(500, 550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);   // open in centre of the screen
        setResizable(false);

        // "this" is a GameWindow, but the screens only see it as a ScreenChanger
        menuScreen = new MenuScreen(this);
        gameScreen = new GameScreen(this);
        resultScreen = new ResultScreen(this);

        container.add(menuScreen, "MENU");
        container.add(gameScreen, "GAME");
        container.add(resultScreen, "RESULT");
        add(container);

        showMenu();
    }

    @Override
    public void showMenu() {
        cardLayout.show(container, "MENU");
    }

    @Override
    public void startGame() {
        gameScreen.startNewGame();     // always start fresh
        cardLayout.show(container, "GAME");
    }

    @Override
    public void showResult(Player winner) {
        resultScreen.showResult(winner);
        cardLayout.show(container, "RESULT");
    }

    @Override
    public void showResult() {
        resultScreen.showResult();
        cardLayout.show(container, "RESULT");
    }

    @Override
    public void exitGame() {
        System.exit(0);
    }
}
