package ttt;

import java.util.Arrays;
import java.util.Scanner;

public class GameBoard {

    private char[][] board;
    private boolean gameOnGoing = true;
    Scanner in;

    public GameBoard() {
        board = new char[3][3];
        clearBoard();
    }

    public void clearBoard() {
        for (int row = 0; row < board.length; row++) {
            Arrays.fill(board[row], ' ');
        }
    }

    public void displayBoard() {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                System.out.print("\t" + board[row][col]);
                if (col == 0 || col == 1) {
                    System.out.print("|");
                }
            }
            if (row == 0 || row == 1) {
                System.out.println("\n --------------------------");
            }
        }
        System.out.println("\n");
    }

    public boolean makeMove(char player, int row, int col) {
        if (row >= 0 && row < 3 && col >= 0 && col < 3) {
            if (board[row][col] == ' ') {
                board[row][col] = player;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean gameActive() {
        return gameOnGoing;
    }

    public void askPlayer(char player) {
        in = new Scanner(System.in);
        int row, col;
        do {
            System.out.printf("Please enter row where to input %s : 1-3", player);
            row = in.nextInt();
            System.out.printf("Please enter col where to input %s : 1-3", player);
            col = in.nextInt();
        } while (notValid(row, col));
        makeMove(player, row - 1, col - 1);
    }

    public boolean notValid(int row, int col) {
        if (row < 1 || row > 3 || col < 1 || col > 3 || !isEmpty(row, col)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isEmpty(int row, int col) {
        if (board[row - 1][col - 1] == ' ') {
            return true;
        } else {
            System.out.println("That move is already taken please take another");
            return false;
        }
    }

    public boolean checkForWinner() {
        for (int row = 0; row < board.length; row++) {
            if (board[row][0] == board[row][1] && board[row][1] == board[row][2] && board[row][0] != ' ') {
                System.out.println("The winner is " + board[row][0]);
                gameOnGoing = false;
                return true;
            }
        }
        for (int col = 0; col < board[0].length; col++) {
            if (board[0][col] == board[1][col] && board[1][col] == board[2][col] && board[0][col] != ' ') {
                System.out.println("The winner is " + board[0][col]);
                gameOnGoing = false;
                return true;
            }
        }
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ') {
            System.out.println("The winner is " + board[0][0]);
            gameOnGoing = false;
            return true;
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != ' ') {
            System.out.println("The winner is " + board[0][2]);
            gameOnGoing = false;
            return true;
        }
        return false;
    }

    public void closeBoard() {
        in.close();
    }
}
