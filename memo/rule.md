# BlackJack ルールメモ
## 使うカード
- 初期カード（山札）は52枚
- 数字が13種×絵柄4種 ジョーカー抜き
- ゲーム開始時に山札をシャッフルする
- 2〜10, J,Q,K,A
- A = 1
- J, Q, K = 10

## プレイヤーについて
- プレイヤーVSディーラー（CPU）

## ゲームの進め方
- ゲーム開始時、プレイヤーとディーラーは２枚カードを山札から引く
- 引いた後にカードを提示する
- プレイヤーは２枚とも、ディーラーは１枚目だけ提示
- プレイヤーが先に１枚ずつカードを引く
- プレイヤーは引いたカードを見て次引くか引かないかを選択できる
- プレイヤーの手札の合計が21を超えたらバースト→その時点でゲームオーバー
- プレイヤーがゲームオーバーせずにカードを引き終えたらディーラーのターン
- ディーラーは手札の合計が17以上になるまでカードを引く
- ディーラーがカードを引き終わったらショウダウン
- 21に近い方が勝ち
- ディーラーもバーストしたらディーラーの負け