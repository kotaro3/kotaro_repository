package kadai002;

import java.io.*;

public class Save {
	Save(String str) {
		try {
			File file = new File("i://メモ.txt");
			BufferedWriter wr = new BufferedWriter(new FileWriter(file));
			PrintWriter pw = new PrintWriter(wr);
			pw.write(str);
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
