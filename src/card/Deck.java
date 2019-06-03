package card;

import java.util.ArrayList;
import java.util.List;

public class Deck {
    List<Card> cards = new ArrayList<>();

    Deck() {
        for (Suite suite : Suite.values()) {
            for (Rank rank : Rank.values()) {
                Card card = new Card(rank, suite);
                cards.add(card);
            }
        }
    }
}
