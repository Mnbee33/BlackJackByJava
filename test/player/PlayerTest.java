package player;

import card.Card;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {
    @Test
    void testDraw() {
        Player player = new Player("あなた");
        player.draw();
        Card card = player.hands.get(0);
        assertEquals("ハートの2", card.toString());
    }
}
