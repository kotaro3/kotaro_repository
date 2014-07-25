package NotePad;

//文字を入力するための命令
import java.util.Scanner;
//ファイルを作成するための命令
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.PrintWriter;

public class NotePad {
	public static void main(String args[]){
		Scanner s = new Scanner(System.in);

		System.out.println("文字を入力してください");
		File newfile = new File("i:\\text.txt");

		try {

			if (newfile.createNewFile()) {
				System.out.println("保存できませんでした");
			} else {

				PrintWriter pw = new PrintWriter(new BufferedWriter(
						new FileWriter(newfile)));

				 while (true) {
				String x = s.next();
				 if (x.equals("/end")) {
				 // 終了したい場合
				pw.close();// ファイル書き込み
				 break;// ループ終了
				
				 }
				 // 改行する場合
				pw.write(x);
				pw.println();
				
				 }

			}
			System.out.println("保存しました");
		} catch (IOException e) {
			System.out.println(e);

		}
	}
}

