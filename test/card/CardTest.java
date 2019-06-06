package card;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CardTest {
    @Test
    void testRankValue() {
        assertEquals(1, Rank.ACE.value());
        assertEquals("A", Rank.ACE.rank());
        assertEquals(2, Rank.TWO.value());
        assertEquals("2", Rank.TWO.rank());
        assertEquals(11, Rank.KING.value());
        assertEquals("K", Rank.KING.rank());
    }

    @Test
    void testSuiteValue() {
        assertEquals("ハート", Suite.HEART.value());
        assertEquals("ダイヤ", Suite.DIAMOND.value());
        assertEquals("クローバー", Suite.CLOVER.value());
        assertEquals("スペード", Suite.SPADE.value());
    }

    @Test
    void testToString() {
        Card card = new Card(Rank.ACE, Suite.HEART);
        assertEquals("ハートのA", card.toString());
    }
}