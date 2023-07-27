
package study;
import constants.FruitsConstants;
import fruits.Fruits;
//①FruitsConstants.javaをインポートしなさい。

//②Fruits.javaをインポートしなさい。

/**
* 本課題では、基本的なJavaの構造と、importについて理解を深めていきましょう。
*
* 問①〜問③まであります。
* 全て回答し、課題にある画像と同じ表示になるようにしてください。
*
*/
public class Study {

  public static void main(String[] args) {
	  String fl4 = FruitsConstants.FRUITS_LEMON_04;
	  int fc20 = FruitsConstants.FRUITS_COUNT_20;
	  Fruits.printFruits(fl4,fc20);
      /* ③ Fruits.javaのprintFruitsメソッドを呼び出しなさい。
       *     また、課題の画像と同じ表示になるように
       *     printFruitsの引数にはFruitsConstantsに指定されている定数を設定してください。
       */

  }
}