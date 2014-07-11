package kadai001;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class SaveData2 {
	void save2(String name, int HP, int EXP, int MONEY) {
		try {
			File saveFile2 = new File("i:\\savedata2.save");
			if (checkBeforeWritefile(saveFile2)) {
				BufferedWriter bw = new BufferedWriter(new FileWriter(saveFile2));

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
