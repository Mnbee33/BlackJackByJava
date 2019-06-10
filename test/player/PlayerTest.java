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
    void testBurst() {
        Card[] c = new Card[]{
                new Card(Rank.TEN, Suite.HEART),
                new Card(Rank.TEN, Suite.DIAMOND),
                new Card(Rank.ACE, Suite.HEART),
                new Card(Rank.ACE, Suite.DIAMOND),
        };
        prepareDeck(c);

        drawTimes(3);   // 21
        assertFalse(player.isBurst());

        player.draw(deck);  // 1
        assertTrue(player.isBurst());
    }

    @Test
    void testDiffer() {
        drawTimes(3);
        assertEquals(12, player.differ());
    }

    @Test
    void testWin() {
        assertEquals("あなたが勝ちました！", player.win());
    }

    @Test
    void testShowCurrentSum() {
        drawTimes(3);

        assertEquals("あなたの合計は9です", player.showSum());
    }

    protected void prepareDeck(Card[] c) {
        List<Card> cards = Arrays.stream(c).collect(Collectors.toList());
        deck = new TestDeck(cards);
    }

    protected void drawTimes(int times) {
        for (int i = 0; i < times; i++) {
            player.draw(deck);
        }
    }
}
