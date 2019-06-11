package player;

import card.Card;
import card.Deck;
import card.TestDeck;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestDeckCreator {
    public Deck prepareDeck(Card[] c) {
        List<Card> cards = Arrays.stream(c).collect(Collectors.toList());
        return new TestDeck(cards);
    }
}
