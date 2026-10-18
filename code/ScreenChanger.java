// INTERFACE: a contract. Any class that "implements" it MUST write these methods.
// The screens use this to ask the window to change the screen.
public interface ScreenChanger {
    void showMenu();                  // go to main menu
    void startGame();                 // start a fresh game
    void showResult(Player winner);   // result screen when someone wins
    void showResult();                // result screen for a draw (METHOD OVERLOADING)
    void exitGame();                  // close the program
}
