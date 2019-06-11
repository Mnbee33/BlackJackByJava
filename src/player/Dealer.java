package player;

import card.Deck;

import java.util.Formatter;

public class Dealer extends Player {
    Formatter messageFormatter = new Formatter();
    final String MESSAGE_DRAW_LATER = "%sは%d枚目に%sを引きました";

    Dealer() {
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
        return "ディーラーの" + count + "枚目のカードは分かりません";
    }

    public String showLater(int index) {
        int count = index + 1;
        Formatter massageText = messageFormatter.format(MESSAGE_DRAW_LATER, name, count, hands.get(index));
        return massageText.toString();
    }
}
