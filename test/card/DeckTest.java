package card;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DeckTest {
    @Test
    void testPreparesDeck() {
        Deck deck = new Deck();
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
}