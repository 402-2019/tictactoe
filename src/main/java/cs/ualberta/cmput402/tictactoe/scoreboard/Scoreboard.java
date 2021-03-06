package cs.ualberta.cmput402.tictactoe.scoreboard;

public class Scoreboard {
    private int playerXScore;
    private int playerOScore;
    private int ties;

    public Scoreboard() {
        this.playerXScore = 0;
        this.playerOScore = 0;
        this.ties = 0;
    }

    public void printScoreboard() {
        System.out.println("Scoreboard:");
        System.out.print("Player X ----> ");
        System.out.println(playerXScore);
        System.out.print("Player O ----> ");
        System.out.println(playerOScore);
        System.out.print("Tie ----> ");
        System.out.println(ties);
    }

    public int getPlayerXScore() {
        return playerXScore;
    }

    public int getPlayerOScore() {
        return playerOScore;
    }

    public void setPlayerXScore(int playerXScore) {
        this.playerXScore = playerXScore;
    }

    public void setPlayerOScore(int playerOScore) {
        this.playerOScore = playerOScore;
    }

    public void incrementTies() {
        ties++;
    }
}
