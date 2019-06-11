package player;

import card.Card;
import card.Deck;
import card.Rank;
import card.Suite;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JudgeTest {
    TestDeckCreator deckCreator = new TestDeckCreator();
    Player player;
    Player dealer;

    @BeforeEach
    void setUp() {
        player = new Player("あなた");
        dealer = new Dealer();
    }

    @Test
    void testPlayerWin() {
        Deck deck = deckCreator.prepareDeck(new Card[]{
                new Card(Rank.TEN, Suite.HEART),
                new Card(Rank.JACK, Suite.DIAMOND),
                new Card(Rank.TEN, Suite.SPADE),
                new Card(Rank.TEN, Suite.HEART),
        });

        player.draw(deck);
        player.draw(deck);

        dealer.draw(deck);
        dealer.draw(deck);

        assertEquals(player, new Judge().judgeWinner(player, dealer));
    }

    @Test
    void testDealerBurst() {
        Deck deck = deckCreator.prepareDeck(new Card[]{
                new Card(Rank.TEN, Suite.HEART),
                new Card(Rank.EIGHT, Suite.DIAMOND),
                new Card(Rank.TEN, Suite.SPADE),
                new Card(Rank.TEN, Suite.HEART),
                new Card(Rank.TWO, Suite.HEART),
        });

        player.draw(deck);
        player.draw(deck);

        dealer.draw(deck);
        dealer.draw(deck);
        dealer.draw(deck);

        assertEquals(player, new Judge().judgeWinner(player, dealer));
    }

    @Test
    void testEven() {
        Deck deck = deckCreator.prepareDeck(new Card[]{
                new Card(Rank.TEN, Suite.HEART),
                new Card(Rank.JACK, Suite.DIAMOND),
                new Card(Rank.TEN, Suite.SPADE),
                new Card(Rank.JACK, Suite.CLOVER),
        });

        player.draw(deck);
        player.draw(deck);

        dealer.draw(deck);
        dealer.draw(deck);

        Player noWinner = new Judge().judgeWinner(player, dealer);
        assertEquals("引き分け！勝者なし", noWinner.win());
    }

    @Test
    void testDealerWin() {
        Deck deck = deckCreator.prepareDeck(new Card[]{
                new Card(Rank.TEN, Suite.HEART),
                new Card(Rank.TEN, Suite.DIAMOND),
                new Card(Rank.TEN, Suite.SPADE),
                new Card(Rank.JACK, Suite.CLOVER),
        });

        player.draw(deck);
        player.draw(deck);

        dealer.draw(deck);
        dealer.draw(deck);

        assertEquals(dealer, new Judge().judgeWinner(player, dealer));
    }
}
