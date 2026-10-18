import java.awt.*;
import javax.swing.*;

// ABSTRACTION + INHERITANCE:
// Screen is an abstract parent class. It cannot be used directly.
// Every screen (Menu, Game, Result) extends it and must write its own buildScreen().
public abstract class Screen extends JPanel {
    protected ScreenChanger changer;   // used to ask the window to change screen

    public Screen(ScreenChanger changer) {
        this.changer = changer;
        setBackground(new Color(30, 30, 50));
    }

    // Abstract method: no body here, each child class fills it in differently.
    protected abstract void buildScreen();

    // Common helper shared by all child screens (code reuse)
    protected JButton makeButton(String text) {
        JButton b = new JButton(text);
        b.setFont(new Font("Arial", Font.BOLD, 22));
        b.setBackground(new Color(70, 130, 180));
        b.setForeground(Color.WHITE);
        b.setFocusPainted(false);
        return b;
    }

    // Common helper for big labels
    protected JLabel makeLabel(String text, int size) {
        JLabel l = new JLabel(text, SwingConstants.CENTER);
        l.setFont(new Font("Arial", Font.BOLD, size));
        l.setForeground(Color.WHITE);
        return l;
    }
}
