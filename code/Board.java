// The Board holds the 3x3 grid and knows the game rules (no GUI code here).
public class Board {
    private char[][] cells = new char[3][3];

    public Board() {
        reset();
    }

    // Make every cell empty (a space means empty)
    public void reset() {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                cells[r][c] = ' ';
            }
        }
    }

    // Put a symbol in a cell. Returns false if the cell is already used.
    public boolean placeMark(int row, int col, char symbol) {
        if (cells[row][col] != ' ') {
            return false;
        }
        cells[row][col] = symbol;
        return true;
    }

    // Has this symbol completed a row, column or diagonal?
    public boolean hasWon(char s) {
        for (int i = 0; i < 3; i++) {
            if (cells[i][0] == s && cells[i][1] == s && cells[i][2] == s) return true; // row
            if (cells[0][i] == s && cells[1][i] == s && cells[2][i] == s) return true; // column
        }
        if (cells[0][0] == s && cells[1][1] == s && cells[2][2] == s) return true;     // diagonal
        if (cells[0][2] == s && cells[1][1] == s && cells[2][0] == s) return true;     // diagonal
        return false;
    }

    // Is every cell filled?
    public boolean isFull() {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (cells[r][c] == ' ') return false;
            }
        }
        return true;
    }
}
