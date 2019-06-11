package player;

public class NoWinner extends Player {

    NoWinner() {
        super("");
    }

    @Override
    String win() {
        return "引き分け！勝者なし";
    }
}
