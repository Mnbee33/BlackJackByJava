package card;

public enum Suite {
    HEART("ハート"),
    DIAMOND("ダイヤ"),
    CLOVER("クローバー"),
    SPADE("スペード");

    private String value;

    Suite(String value){
        this.value = value;
    }

    public String value() {
        return value;
    }
}
