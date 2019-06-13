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

    final String MESSAGE_DRAW = "%sは%sを引きました";
    final String MESSAGE_SUM = "%sの合計は%dです";
    final String MESSAGE_WIN = "%sの勝利です！";

    public Player(String name) {
        this.name = name;
    }

    void draw(Deck deck) {
        hands.add(deck.draw());
    }

    String showHand(int index) {
        return formatMessage(MESSAGE_DRAW, name, hands.get(index));
    }

    String showLastHand() {
        int lastIndex = hands.size() - 1;
        return showHand(lastIndex);
    }

    public String drawAndShow(Deck deck) {
        draw(deck);
        return showLastHand();
    }

    int sumHands() {
        return hands.stream()
                .map(Card::getRank)
                .mapToInt(Rank::value)
                .sum();
    }

    public boolean isBurst() {
        return sumHands() > 21;
    }

    int differ() {
        return 21 - sumHands();
    }

    public String showSum() {
        return formatMessage(MESSAGE_SUM, name, sumHands());
    }

    boolean isWon(Player other) {
        return other.isBurst() || differ() < other.differ();
    }

    boolean isEven(Player other) {
        return differ() == other.differ();
    }

    public String win() {
        return formatMessage(MESSAGE_WIN, name);
    }

    protected String formatMessage(String message, Object... args) {
        Formatter messageFormatter = new Formatter();
        Formatter messageText = messageFormatter.format(message, args);
        return messageText.toString();
    }
}
