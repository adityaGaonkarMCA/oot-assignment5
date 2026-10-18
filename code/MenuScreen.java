import java.awt.*;
import javax.swing.*;

// Main menu: title + Play button + Exit button
public class MenuScreen extends Screen {

    public MenuScreen(ScreenChanger changer) {
        super(changer);
        buildScreen();
    }

    @Override   // POLYMORPHISM: same method name as in Screen, but menu-specific work
    protected void buildScreen() {
        setLayout(new GridLayout(3, 1, 20, 20));
        setBorder(BorderFactory.createEmptyBorder(60, 100, 60, 100));

        JLabel title = makeLabel("XO GAME", 40);
        JButton playButton = makeButton("Play");
        JButton exitButton = makeButton("Exit");

        playButton.addActionListener(e -> changer.startGame());
        exitButton.addActionListener(e -> changer.exitGame());

        add(title);
        add(playButton);
        add(exitButton);
    }
}
