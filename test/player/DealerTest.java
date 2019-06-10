package player;

import card.Card;
import card.Rank;
import card.Suite;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DealerTest extends PlayerTest {
    Dealer dealer;

    @BeforeEach
    void setUp(){
        super.setUp();
        dealer = new Dealer();
    }

    @Test
    void testDealer() {
        assertEquals("ディーラーが勝ちました！", dealer.win());
    }

    @Test
    void testAutoDraw() {
        Card[] c = new Card[]{
                new Card(Rank.TEN, Suite.HEART),
                new Card(Rank.ACE, Suite.HEART),
                new Card(Rank.SIX, Suite.HEART),
        };
        prepareDeck(c);

        dealer.autoDraw(deck);
        assertEquals(17, dealer.sumHands());
    }
}
