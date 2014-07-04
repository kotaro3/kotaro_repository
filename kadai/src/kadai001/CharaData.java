package kadai001;

import java.io.*;
import java.util.Scanner;

public class CharaData {
	static int HP, EXP, MONEY;
	static String name;

	public static void main(String[] args) {
		SaveData sd  = new SaveData();
	

		Scanner s = new Scanner(System.in);
		Scanner hp = new Scanner(System.in);
		Scanner exp = new Scanner(System.in);
		Scanner money = new Scanner(System.in);
		Scanner Y = new Scanner(System.in);
		Scanner n = new Scanner(System.in);


		System.out.println("名前を入力してください");
		name = s.next();	
		
		
		System.out.println("スターテスを入力してください");
		System.out.print("HP:");
		HP = hp.nextInt();
		
		
		System.out.print("EXP:");
		EXP = exp.nextInt();
		

		System.out.print("MONEY:");
		MONEY = money.nextInt();
		
		sd.save(name,HP,EXP,MONEY);
		
		System.out.println("ロードしますか？[y/n]");
		String y = Y.next();
		if(y.equals(Y)){
			LoadData l = new LoadData();
			l.load();
		}

	}
}
