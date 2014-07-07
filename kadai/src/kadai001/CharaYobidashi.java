package kadai001;

import java.util.Scanner;

public class CharaYobidashi {
	static int n;
//	static int x[] = new int[n];
	static CharaData c = new CharaData();

	public static void main(String[] args) {
		System.out.println("1~2までのキャラ数を設定してください");
		Scanner num = new Scanner(System.in);
		int n = num.nextInt();
		System.out.println("キャラごとのステータスを設定します");
		for (int i = 0;i>=n;n--) {
			c.Charaset();
		}
	}

}
