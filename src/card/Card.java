package card;

public class Card {
    Suite suite;
    Rank rank;

    Card(Rank rank, Suite suite) {
        this.rank = rank;
        this.suite = suite;
    }
}
