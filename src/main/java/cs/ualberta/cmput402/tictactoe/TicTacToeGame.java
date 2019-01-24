package cs.ualberta.cmput402.tictactoe;

import cs.ualberta.cmput402.tictactoe.board.Board;
import cs.ualberta.cmput402.tictactoe.board.Board.Player;
import cs.ualberta.cmput402.tictactoe.board.exceptions.InvalidMoveException;
import cs.ualberta.cmput402.tictactoe.scoreboard.Scoreboard;

import java.util.Scanner;

/**
 * Created by snadi on 2018-07-18.
 */
public class TicTacToeGame {

    private Board board;
    private Scoreboard scoreboard;
    private boolean gameFinished; // boolean indicating whether game is finished or not

    public TicTacToeGame() {
        board = new Board();
        scoreboard = new Scoreboard();
        gameFinished = false;
    }

    public void promptNextPlayer() {
        switch (board.getCurrentPlayer()) {
            case X:
                System.out.println("It's player " + board.getSymbol(board.getCurrentPlayer()) + "'s turn. Please enter the coordinates of your next move as x,y: ");
                break;
            case O:
                System.out.println("It's player " + board.getSymbol(board.getCurrentPlayer()) + "'s turn. Please enter the coordinates of your next move as x,y: ");
                break;
        }
    }

    public void playGame() {
        Scanner keyboardScanner = new Scanner(System.in);

        // The outer while loop is for the game to continue after each round.
        // It stops when player says they do not want to continue.
        // The inner while loop checks whether a round is finished or not.
        while (!gameFinished) {
            while (board.getWinner() == null && !board.getIsTie()) {
                board.printBoard();
                promptNextPlayer();
                String line = keyboardScanner.nextLine();
                String input[] = line.split(",");
                try {
                    board.playMove(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
                } catch (InvalidMoveException e) {
                    System.out.println("Invalid coordinates. Try again");
                    promptNextPlayer();
                }
            }

            // Printing the board and the state of the finished game
            board.printBoard();

            if (board.getIsTie()) {
                scoreboard.incrementTies();
                System.out.println("It is a tie!");
            } else {
                if (board.getWinner().equals(Player.X)) {
                    scoreboard.setPlayerXScore(scoreboard.getPlayerXScore() + 1);
                } else {
                    scoreboard.setPlayerOScore(scoreboard.getPlayerOScore() + 1);
                }

                System.out.println("Player " + board.getWinner() + " has won the game!");
            }

            scoreboard.printScoreboard();
            // Checks if player wants to continue or not, and do the appropriate action
            System.out.println("Would you like to play again? (enter \"yes\" for replay and \"no\" for showing the scoreboard and finishing the game)");
            String line = keyboardScanner.nextLine();
            if (line.equals("no")) {
                scoreboard.printScoreboard();
                gameFinished = true;
            } else {
                board = new Board();
            }
        }
    }

    public static void main(String args[]) {
        TicTacToeGame game = new TicTacToeGame();
        game.playGame();
    }
}
