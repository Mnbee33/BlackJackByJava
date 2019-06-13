package player;

public class NoWinner extends Player {

    public NoWinner() {
        super("");
    }

    @Override
    public String win() {
        return "引き分け！勝者なし";
    }
}
