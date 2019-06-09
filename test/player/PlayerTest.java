package player;

import card.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    Player player;
    Deck deck;

    @BeforeEach
    void setUp() {
        player = new Player("あなた");
        deck = new Deck();
    }

    @Test
    void testDraw() {
        player.draw(deck);
        assertEquals("あなたはハートの2を引きました", player.showHand(0));
    }

    @Test
    void testSumHands() {
        player.draw(deck);  // 2
        player.draw(deck);  // 3
        player.draw(deck);  // 4
        assertEquals(9, player.sumHands());
    }

    @Test
    void testBurst() {
        Card[] c = new Card[]{
                new Card(Rank.TEN, Suite.HEART),
                new Card(Rank.TEN, Suite.DIAMOND),
                new Card(Rank.ACE, Suite.HEART),
                new Card(Rank.ACE, Suite.DIAMOND),
        };
        prepareDeck(c);

        player.draw(deck);  // 10
        player.draw(deck);  // 10
        player.draw(deck);  // 1
        assertFalse(player.isBursted());

        player.draw(deck);  // 1
        assertTrue(player.isBursted());
    }

    @Test
    void testDiffer() {
        player.draw(deck);  // 2
        player.draw(deck);  // 3
        player.draw(deck);  // 4
        assertEquals(12, player.differ());
    }

    private void prepareDeck(Card[] c) {
        List<Card> cards = Arrays.stream(c).collect(Collectors.toList());
        deck = new TestDeck(cards);
    }
}
