package player;

import card.Card;
import card.Deck;
import card.Rank;
import card.Suite;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    TestDeckCreator deckCreator = new TestDeckCreator();
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
    void testShowLast() {
        player.draw(deck);
        assertEquals("あなたはハートの2を引きました", player.showLastHand());
    }

    @Test
    void testDrawAndShow() {
        assertEquals("あなたはハートの2を引きました", player.drawAndShow(deck));
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
        assertEquals("あなたの勝利です！", player.win());
    }

    @Test
    void testShowCurrentSum() {
        drawTimes(3);
        assertEquals("あなたの合計は9です", player.showSum());
    }

    protected void prepareDeck(Card[] c) {
        deck = deckCreator.prepareDeck(c);
    }

    protected void drawTimes(int times) {
        for (int i = 0; i < times; i++) {
            player.draw(deck);
        }
    }
}
