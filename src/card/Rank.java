package card;

public enum Rank {
    TWO(2, "2"),
    THREE(3, "3"),
    FOUR(4, "4"),
    FIVE(5, "5"),
    SIX(6, "6"),
    SEVEN(7, "7"),
    EIGHT(8, "8"),
    NINE(9, "9"),
    TEN(10, "10"),
    JACK(11, "J"),
    QUEEN(11, "Q"),
    KING(11, "K"),
    ACE(1, "A");

    private int value;
    private String rank;

    Rank(int value, String rank) {
        this.value = value;
        this.rank = rank;
    }

    public int value() {
        return value;
    }

    public String rank() {
        return rank;
    }
}
