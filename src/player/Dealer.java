package player;

import card.Deck;

public class Dealer extends Player {
    Dealer() {
        super("ディーラー");
    }

    public void autoDraw(Deck deck) {
        while (sumHands() < 17) {
            draw(deck);
        }
    }
}
