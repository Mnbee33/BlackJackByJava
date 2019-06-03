package card;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DeckTest {
    @Test
    void testPreparesDeck() {
        Deck deck = new Deck();
        List<Card> cards = deck.cards;

        assertEquals(52, cards.size());

        assertEquals(Rank.TWO, cards.get(0).rank);
        assertEquals(Suite.HEART, cards.get(0).suite);

        assertEquals(Rank.ACE, cards.get(51).rank);
        assertEquals(Suite.SPADE, cards.get(51).suite);

    }
}