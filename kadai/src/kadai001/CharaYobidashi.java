package kadai001;

import java.util.Scanner;

public class CharaYobidashi {
	static int n = 2;
	static int x[] = new int[n];
	static CharaData c = new CharaData();

	public static void main(String[] args) {
		System.out.println("キャラ数を設定してください");
		Scanner num = new Scanner(System.in);
		n = num.nextInt();
		System.out.println("キャラごとのステータスを設定します");
		while ((n - 1) >= 0) {
			c.Charaset();
			n--;
		}
	}

	

}
