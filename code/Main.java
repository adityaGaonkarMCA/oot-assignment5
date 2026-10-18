import javax.swing.*;

// Program starts here.
public class Main {
    public static void main(String[] args) {
        try {
            // Makes button colours show correctly on every operating system
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            // ignore, default look will be used
        }
        SwingUtilities.invokeLater(() -> new GameWindow().setVisible(true));
    }
}
