package kadai001;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class SaveData {
	void save(){
		try {
			File saveFile = new File("i:\\savedata.save");
			BufferedWriter bw = new BufferedWriter(new FileWriter(saveFile));
			CharaData c = new CharaData();
			bw.write(c.name);
			bw.write(" ");
			bw.write(c.HP);
			bw.write(c.EXP);
			bw.write(c.MONEY);
			
			
	} catch (FileNotFoundException e) {
		System.out.println(e);
	} catch (IOException e) {
		System.out.println(e);
	}
	}

}
