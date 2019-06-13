package player;

import card.Deck;

public class Dealer extends Player {
    final String MESSAGE_DRAW_LATER = "%sは%d枚目に%sを引きました";
    final String MESSAGE_HIDE = "%sの%d枚目のカードは分かりません";

    public Dealer() {
        super("ディーラー");
    }

    public void autoDraw(Deck deck) {
        while (sumHands() < 17) {
            draw(deck);
        }
    }

    public String drawAndHide(Deck deck) {
        draw(deck);
        int count = hands.size();
        return formatMessage(MESSAGE_HIDE, name, count);
    }

    public String showLater(int index) {
        int count = index + 1;
        return formatMessage(MESSAGE_DRAW_LATER, name, count, hands.get(index));
    }

    public boolean isUnder17() {
        return sumHands() < 17;
    }
}
