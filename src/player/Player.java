package player;

import card.Card;
import card.Deck;
import card.Rank;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

public class Player {
    String name;
    List<Card> hands = new ArrayList<>();
    Formatter messageFormatter = new Formatter();

    final String MESSAGE_DRAW = "%sは%sを引きました";
    final String MESSAGE_SUM = "%sの合計は%dです";
    final String MESSAGE_WIN = "%sが勝ちました！";

    Player(String name) {
        this.name = name;
    }

    void draw(Deck deck) {
        hands.add(deck.draw());
    }

    String showHand(int index) {
        Formatter messageText = messageFormatter.format(MESSAGE_DRAW, name, hands.get(index));
        return messageText.toString();
    }

    String showLastHand() {
        int lastIndex = hands.size() - 1;
        return showHand(lastIndex);
    }

    String drawAndShow(Deck deck) {
        draw(deck);
        return showLastHand();
    }

    int sumHands() {
        return hands.stream()
                .map(Card::getRank)
                .mapToInt(Rank::value)
                .sum();
    }

    boolean isBurst() {
        return sumHands() > 21;
    }

    int differ() {
        return 21 - sumHands();
    }

    String showSum() {
        Formatter messageText = messageFormatter.format(MESSAGE_SUM, name, sumHands());
        return messageText.toString();
    }

    boolean isWon(Player other) {
        return other.isBurst() || differ() < other.differ();
    }

    boolean isEven(Player other) {
        return differ() == other.differ();
    }

    String win() {
        Formatter messageText = messageFormatter.format(MESSAGE_WIN, name);
        return messageText.toString();
    }
}
