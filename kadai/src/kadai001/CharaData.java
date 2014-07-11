package kadai001;

import java.util.Scanner;

public class CharaData {
	static int HP, EXP;
	static int MONEY;
	static String name;

	void Charaset1() {
		SaveData1 sd1 = new SaveData1();

		Scanner s = new Scanner(System.in);
		Scanner hp = new Scanner(System.in);
		Scanner exp = new Scanner(System.in);
		Scanner money = new Scanner(System.in);

		System.out.println("名前を入力してください");
		System.out.println("NAME:");
		name = s.next();

		System.out.println("スターテスを入力してください");
		System.out.print("HP:");
		HP = hp.nextInt();

		System.out.print("EXP:");
		EXP = exp.nextInt();

		System.out.print("MONEY:");
		MONEY = money.nextInt();

		sd1.save1(name, HP, EXP, MONEY);

	}

	void Charaset2() {
		SaveData2 sd2 = new SaveData2();

		Scanner s = new Scanner(System.in);
		Scanner hp = new Scanner(System.in);
		Scanner exp = new Scanner(System.in);
		Scanner money = new Scanner(System.in);


		System.out.println("名前を入力してください");
		System.out.println("NAME:");
		name = s.next();

		System.out.println("スターテスを入力してください");
		System.out.print("HP:");
		HP = hp.nextInt();

		System.out.print("EXP:");
		EXP = exp.nextInt();

		System.out.print("MONEY:");
		MONEY = money.nextInt();

		sd2.save2(name, HP, EXP, MONEY);
		System.out.println("セーブしました");
	}

	void Charaset3(){
			SaveData3 sd3  = new SaveData3();

			Scanner s = new Scanner(System.in);
			Scanner hp = new Scanner(System.in);
			Scanner exp = new Scanner(System.in);
			Scanner money = new Scanner(System.in);


			System.out.println("名前を入力してください");
			System.out.println("NAME:");
			name = s.next();

			System.out.println("スターテスを入力してください");
			System.out.print("HP:");
			HP = hp.nextInt();

			System.out.print("EXP:");
			EXP = exp.nextInt();

			System.out.print("MONEY:");
			MONEY = money.nextInt();

			sd3.save3(name,HP,EXP,MONEY);
			System.out.println("セーブしました");
	}
}
