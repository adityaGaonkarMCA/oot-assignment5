import java.awt.*;
import javax.swing.*;

// Shows who won (or draw) with Play Again and Main Menu buttons
public class ResultScreen extends Screen {
    private JLabel resultLabel;

    public ResultScreen(ScreenChanger changer) {
        super(changer);
        buildScreen();
    }

    @Override
    protected void buildScreen() {
        setLayout(new BorderLayout(20, 20));
        setBorder(BorderFactory.createEmptyBorder(60, 60, 60, 60));

        resultLabel = makeLabel("", 36);
        add(resultLabel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 20, 0));
        buttonPanel.setBackground(new Color(30, 30, 50));

        JButton playAgain = makeButton("Play Again");
        JButton mainMenu = makeButton("Main Menu");
        playAgain.addActionListener(e -> changer.startGame());
        mainMenu.addActionListener(e -> changer.showMenu());

        buttonPanel.add(playAgain);
        buttonPanel.add(mainMenu);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    // METHOD OVERLOADING: same name, different parameters
    public void showResult(Player winner) {
        resultLabel.setText(winner.getName() + " (" + winner.getSymbol() + ") Wins!");
    }

    public void showResult() {
        resultLabel.setText("It's a Draw!");
    }
}
