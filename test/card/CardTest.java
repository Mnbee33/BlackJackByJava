package card;

import org.junit.jupiter.api.Test;

class CardTest {
    @Test
    void testRankValue(){
        assert(1, Rank.ACE.value());
        assert(2, Rank.TWO.value());
        assert(11, Rank.KING.value());
    }
}