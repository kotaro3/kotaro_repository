package kadai001;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class SaveData3 {

	void save3(String name, int HP, int EXP, int MONEY) {
		try {
			File saveFile3 = new File("i:\\savedata3.save");
			if (checkBeforeWritefile(saveFile3)) {
				BufferedWriter bw = new BufferedWriter(new FileWriter(saveFile3));

				bw.write("NAME:" + name);
				bw.newLine();
				bw.write("HP:" + HP);
				bw.newLine();
				bw.write("EXP:" + EXP);
				bw.newLine();
				bw.write("MONEY:" + MONEY);
				bw.newLine();
				bw.close();

				return;

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
				return false;
			}
		}

		return true;
	}

}

