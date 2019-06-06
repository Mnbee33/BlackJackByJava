package card;

public class Card {
    Suite suite;
    Rank rank;

    Card(Rank rank, Suite suite) {
        this.rank = rank;
        this.suite = suite;
    }

    @Override
    public String toString() {
        return suite.value() + "の" + rank.rank();
    }
}
