package player;

import card.Card;
import card.Deck;
import card.Rank;

import java.util.ArrayList;
import java.util.List;

public class Player {
    String name;
    List<Card> hands = new ArrayList<>();

    Player(String name) {
        this.name = name;
    }

    void draw(Deck deck) {
        hands.add(deck.draw());
    }

    String showHand(int index) {
        return name + "は" + hands.get(index) + "を引きました";
    }

    int sumHands() {
        return hands.stream()
                .map(Card::getRank)
                .mapToInt(Rank::value)
                .sum();
    }

    boolean isBursted() {
        return sumHands() > 21;
    }

    int differ() {
        return 21 - sumHands();
    }
}
