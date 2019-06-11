package player;

public class Judge {
    public Player judgeWinner(Player player1, Player player2) {
        if (player1.isWon(player2)) {
            return player1;
        }

        if (player1.isEven(player2)) {
            return new NoWinner();
        }

        return player2;
    }
}
