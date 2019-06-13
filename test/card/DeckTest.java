package card;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DeckTest {
    Deck deck;

    @BeforeEach
    void setUp() {
        deck = new Deck();
    }

    @Test
    void testPreparesDeck() {
        List<Card> cards = deck.cards;

        assertEquals(52, cards.size());

        Map<Rank, List<Card>> rankGroup = cards.stream()
                .collect(Collectors.groupingBy(card -> card.rank));
        rankGroup.forEach((k, v) -> {
            int size = v.size();
            assertEquals(4, size);
        });

        Map<Suite, List<Card>> suiteGroup = cards.stream()
                .collect(Collectors.groupingBy(card -> card.suite));
        suiteGroup.forEach((k, v) -> {
            int size = v.size();
            assertEquals(13, size);
        });
    }

    // @Test
    void testShuffle() {
        deck.shuffle();
        deck.cards.forEach(System.out::println);
    }


    // @Test
    void testShuffleDeck() {
        deck = Deck.prepareShuffleDeck();
        deck.cards.forEach(System.out::println);
    }

    @Test
    void testDraw() {
        Card card = deck.draw();
        assertEquals("ハートの2", card.toString());
        assertEquals(51, deck.cards.size());

        Card nextFirst = deck.cards.get(0);
        assertEquals("ハートの3", nextFirst.toString());
    }
}