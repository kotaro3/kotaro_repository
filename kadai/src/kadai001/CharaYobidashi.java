package kadai001;

import java.util.Scanner;

public class CharaYobidashi {
	static int n;
	// static int x[] = new int[n];
	static CharaData c = new CharaData();

	static LoadData1 l1 = new LoadData1();
	static LoadData2 l2 = new LoadData2();
	static LoadData3 l3 = new LoadData3();

	static Scanner num = new Scanner(System.in);
	static Scanner cnum = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("1～3のキャラ数を設定してください");
		n = num.nextInt();
		if (n > 3 && n < 0) {
			System.out.println("エラー");
			return;
		}

		System.out.println("キャラごとのステータスを設定します");
		if (n == 1) {
			c.Charaset1();
		} else if (n == 2) {
			c.Charaset1();
			c.Charaset2();
		} else if (n == 3) {
			c.Charaset1();
			c.Charaset2();
			c.Charaset3();
		}

		System.out.println("呼び出すキャラを設定してください");
		int cn = num.nextInt();
		switch (cn) {
		case 1:
			l1.loadData1();
			break;
		case 2:
			l2.loadData2();
			break;
		case 3:
			l3.loadData3();
			break;
		}

	}

}
