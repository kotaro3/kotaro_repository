package kadai001;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LoadData1 {

	void loadData1() {

		try {
			FileReader loadFile = new FileReader("i:\\savedata1.save");

			BufferedReader br = new BufferedReader(loadFile);

			String str = br.readLine();
			while (str != null) {
				System.out.println(str);

				str = br.readLine();
			}

			br.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
