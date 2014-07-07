package kadai001;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LoadData {

	void loadData() {

		try {
			FileReader loadFile = new FileReader("i:\\savedata.txt");

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
