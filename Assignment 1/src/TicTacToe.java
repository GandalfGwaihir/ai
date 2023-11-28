import java.util.Scanner;


public class TicTacToe {
    private char[][] board;
    private char currentPlayer;


    public TicTacToe() {
        board = new char[3][3];
        currentPlayer = 'X';
        initializeBoard();
    }


    public void initializeBoard() {
        int cellValue = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = Character.forDigit(cellValue, 10);
                cellValue++;
            }
        }
    }


    public void printBoard() {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("---------");
        }
    }


    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (Character.isDigit(board[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }


    public boolean isWinner() {
        return checkRows() || checkColumns() || checkDiagonals();
    }


    private boolean checkRows() {
        for (int i = 0; i < 3; i++) {
            if (Character.isDigit(board[i][0])) continue;
            if (board[i][0] == board[i][1] && board[i][0] == board[i][2]) {
                return true;
            }
        }
        return false;
    }


    private boolean checkColumns() {
        for (int i = 0; i < 3; i++) {
            if (Character.isDigit(board[0][i])) continue;
            if (board[0][i] == board[1][i] && board[0][i] == board[2][i]) {
                return true;
            }
        }
        return false;
    }


    private boolean checkDiagonals() {
        if (!Character.isDigit(board[0][0])) {
            if (board[0][0] == board[1][1] && board[0][0] == board[2][2]) {
                return true;
            }
        }
        if (!Character.isDigit(board[0][2])) {
            if (board[0][2] == board[1][1] && board[0][2] == board[2][0]) {
                return true;
            }
        }
        return false;
    }


    public void makeMove(int move) {
        if (move >= 1 && move <= 9) {
            int row = (move - 1) / 3;
            int col = (move - 1) % 3;
            if (Character.isDigit(board[row][col])) {
                board[row][col] = currentPlayer;
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }
    }


    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        Scanner scanner = new Scanner(System.in);


        System.out.println("Welcome to our Tic-Tac-Toe Game");


        System.out.println(" Symbol - X would represent player 1");
        System.out.println(" Symbol - O would represent player 2");
        System.out.println("Enter a number from 1 to 9 to make a move.");


        while (!game.isBoardFull() && !game.isWinner()) {
            game.printBoard();


            int move;
            System.out.print("Player " + game.currentPlayer + ", enter your move: ");


            move = scanner.nextInt();


            game.makeMove(move);
        }


        game.printBoard();


        if (game.isWinner()) {
            game.currentPlayer = (game.currentPlayer == 'X') ? 'O' : 'X';
            System.out.println("Yayyy!! \uD83E\uDD73 \uD83E\uDD73 Player " + game.currentPlayer + " wins!");
        } else {
            System.out.println("It's a tie!");
        }


        scanner.close();
    }
}
