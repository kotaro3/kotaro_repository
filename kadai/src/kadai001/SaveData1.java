package kadai001;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;


public class SaveData1 {



	void save1(String name, int HP, int EXP, int MONEY) {
		try {
			File saveFile1 = new File("i:\\savedata1.save");
			if (checkBeforeWritefile(saveFile1)) {
				BufferedWriter bw = new BufferedWriter(new FileWriter(saveFile1));

				bw.write("NAME:" + name);
				bw.newLine();
				bw.write("HP:" + HP);
				bw.newLine();
				bw.write("EXP:" + EXP);
				bw.newLine();
				bw.write("MONEY:" + MONEY);
				bw.newLine();
				bw.close();

				System.out.println("セーブが完了しました");


			} else {
				System.out.println("セーブ失敗しました。");
			}

		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	private static boolean checkBeforeWritefile(File file) {
		if (file.exists()) {
			if (file.isFile() && file.canWrite()) {
				return true;
			}
		}

		return false;
	}
}
