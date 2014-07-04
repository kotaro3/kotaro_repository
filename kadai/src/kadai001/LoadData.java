package kadai001;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LoadData {
	void load(){

		try {
			File saveFile = new File("i:\\savedata.save");
			BufferedReader br = new BufferedReader(new FileReader(saveFile));
			CharaData c = new CharaData();
			br.readLine();
			br.readLine();
			br.readLine();
		
			br.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
