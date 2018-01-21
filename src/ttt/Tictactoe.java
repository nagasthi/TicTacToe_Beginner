package ttt;

public class TicTacToe {

    public static void main(String[] args) {
        GameBoard game = new GameBoard();
        int counter = 1;
        game.clearBoard();
        game.displayBoard();
        while (game.gameActive() && counter < 10) {
            if (counter % 2 == 0) {
                game.askPlayer('O');
            } else {
                game.askPlayer('X');
            }
            counter++;
            game.displayBoard();
            game.checkForWinner();
            if (counter == 10 && !game.checkForWinner()) {
                System.out.println("Game Draw");
            }
        }
        game.closeBoard();
    }
}
