import java.util.Scanner;

class Game {
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Scanner scanner;

    public Game() {
        board = new Board();
        scanner = new Scanner(System.in);
        player1 = new Player('X', "Player 1");
        player2 = new Player('O', "Player 2");
        currentPlayer = player1; // Player 1 starts
    }

    public void startGame() {
        board.initializeBoard();
        while (true) {
            board.displayBoard();
            System.out.println(currentPlayer.getName() + " (" + currentPlayer.getSymbol() + "), enter your move (e.g., A 1): ");
            String move = scanner.nextLine();

            if (board.makeMove(currentPlayer.getSymbol(), move)) {
                if (board.checkWin(currentPlayer.getSymbol())) {
                    board.displayBoard();
                    System.out.println(currentPlayer.getName() + " wins!");
                    break;
                }
                if (board.isBoardFull()) {
                    board.displayBoard();
                    System.out.println("The game is a draw!");
                    break;
                }
                switchPlayer();
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }
}
