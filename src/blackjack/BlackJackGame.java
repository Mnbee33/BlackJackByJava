package blackjack;

import card.Deck;
import player.Dealer;
import player.Judge;
import player.Player;

import java.util.Scanner;

public class BlackJackGame {
    Deck deck;
    Player player;
    Dealer dealer;

    BlackJackGame() {
        deck = Deck.prepareShuffleDeck();
        player = new Player("あなた");
        dealer = new Dealer();
    }

    public static void main(String[] args) {
        BlackJackGame game = new BlackJackGame();
        game.start();

        game.letPlayerFirstDraw();
        game.letDealerFirstDraw();

        game.playsPlayersTurn();
        game.playDealersTurn();

        Player winner = game.showDown();
        game.isOver(winner);
    }

    private void start(){
        System.out.println("■■■ ブラックジャックへようこそ ■■■");
        System.out.println("--- ゲームを開始します ---");
    }

    private void lineBreak() {
        System.out.println();
    }

    private void letPlayerFirstDraw() {
        System.out.println(player.drawAndShow(deck));
        System.out.println(player.drawAndShow(deck));
        lineBreak();
        checkBurst();
    }

    private void letDealerFirstDraw() {
        System.out.println(dealer.drawAndShow(deck));
        System.out.println(dealer.drawAndHide(deck));
        lineBreak();
    }

    private void playsPlayersTurn() {
        System.out.println("--- あなたのターンです ---");
        System.out.println(player.showSum());

        boolean isPlayerTurn = true;
        while (isPlayerTurn) {
            System.out.print("[y(カードを引く)またはn(カードを引かない)を入力してください]： ");
            Scanner scan = new Scanner(System.in);
            String input = scan.nextLine();
            switch (input) {
                case "y":
                    letPlayerDraw();
                    break;
                case "n":
                    isPlayerTurn = false;
                    break;
                default:
                    System.out.println("[入力値が正しくありません]");
                    break;
            }
        }
        lineBreak();
    }

    private void letPlayerDraw() {
        System.out.println(player.drawAndShow(deck));
        System.out.println(player.showSum());
        checkBurst();
    }

    private void checkBurst() {
        if (player.isBurst()) {
            System.out.println("あなたはバーストしました…");
            lineBreak();
            isOver(dealer);
        }
    }

    private void playDealersTurn() {
        System.out.println("--- ディーラーのターンです ----");
        System.out.println(dealer.showLater(1));
        while (dealer.isUnder17()) {
            System.out.println(dealer.drawAndShow(deck));
        }
        lineBreak();
    }

    private Player showDown() {
        System.out.println("-- ショウダウン！ --");
        System.out.println(player.showSum());
        System.out.println(dealer.showSum());

        return new Judge().judgeWinner(player, dealer);
    }

    private void isOver(Player winner) {
        System.out.println("＼ " + winner.win() + " ／");
        lineBreak();
        System.out.println("■■■ ゲームを終了します。また遊んでね！ ■■■");
        System.exit(0);
    }
}
