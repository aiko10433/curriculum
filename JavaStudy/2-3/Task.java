package study;

public class Task extends Calculator {

//① TaskクラスにCalculatorクラスを継承させなさい。

/**
 * タスクの実行
 */
public void doTask() {
	Calculator calculator = new Calculator();
		System.out.println("plusメソッドの引数が1つの場合："+calculator.plus(10));
		System.out.println("plusメソッドの引数が2つの場合："+calculator.plus(10,20));
		System.out.println("plusメソッドの引数が3つの場合："+calculator.plus(10,20,70));
    // ② Calculator.javaのすべてのオーバーロードメソッド「plus」に適当な引数を与え、下記画像のよう出力されるようコーディングしなさい。
    // 尚、「どのクラスから呼び出しているか」を明確にするため、plus()には呼び出し元のキーワードを付与すること。

	}
}