package card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    List<Card> cards = new ArrayList<>();

    public Deck() {
        for (Suite suite : Suite.values()) {
            for (Rank rank : Rank.values()) {
                Card card = new Card(rank, suite);
                cards.add(card);
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card draw() {
        return cards.remove(0);
    }
}
