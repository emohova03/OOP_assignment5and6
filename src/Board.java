
class Board {
    private static final int SIZE = 3;
    private char[][] grid;

    public Board() {
        grid = new char[SIZE][SIZE];
    }

    public void initializeBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                grid[i][j] = '□';
            }
        }
    }

    public void displayBoard() {
        System.out.println("   A B C");
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(" " + grid[i][j]);
            }
            System.out.println();
        }
    }

    public boolean makeMove(char player, String move) {
        String[] parts = move.split(" ");
        if (parts.length != 2) return false;

        char column = parts[0].charAt(0);
        char row = parts[1].charAt(0);

        int colIndex = column - 'A';
        int rowIndex = row - '1';

        if (colIndex < 0 || colIndex >= SIZE || rowIndex < 0 || rowIndex >= SIZE || grid[rowIndex][colIndex] != '□') {
            return false;
        }

        grid[rowIndex][colIndex] = player;
        return true;
    }

    public boolean checkWin(char player) {
        // Check rows, columns, and diagonals for a winning line
        for (int i = 0; i < SIZE; i++) {
            if ((grid[i][0] == player && grid[i][1] == player && grid[i][2] == player) || // Row
                    (grid[0][i] == player && grid[1][i] == player && grid[2][i] == player)) { // Column
                return true;
            }
        }

        return (grid[0][0] == player && grid[1][1] == player && grid[2][2] == player) || // Diagonal 1
                (grid[0][2] == player && grid[1][1] == player && grid[2][0] == player);  // Diagonal 2
    }

    public boolean isBoardFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (grid[i][j] == '□') return false;
            }
        }
        return true;
    }
}