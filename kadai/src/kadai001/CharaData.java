package kadai001;

import java.io.*;
import java.util.Scanner;

public class CharaData {
	int HP, EXP, MONEY;
	String name;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Scanner hp = new Scanner(System.in);
		Scanner exp = new Scanner(System.in);
		Scanner money = new Scanner(System.in);
		
		System.out.println("名前を入力してください");
		String name =s.next();
		System.out.println("スターテスを入力してください");
		System.out.print("HP:");
		int HP = hp.nextInt();
		System.out.print("EXP:");
		int EXP = exp.nextInt();
		System.out.print("MONEY:");
		int MONEY = money.nextInt();
		
		
		
		try{
		File saveFile = new File("i:\\\\savedata.txt");
		BufferedWriter br = new BufferedWriter(new FileWriter(saveFile));
		
		
		}catch(FileNotFoundException e){
			System.out.println(e);
		}catch(IOException e){
			System.out.println(e);
		}
	

	}
}
