package kadai001;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class SaveData {
	void save(String name,int HP,int EXP,int MONEY){
		try {
			File saveFile = new File("i:\\savedata.save");
			BufferedWriter bw = new BufferedWriter(new FileWriter(saveFile));
	
			bw.write(CharaData.name);
			bw.write(CharaData.HP);
			bw.write(CharaData.EXP);
			bw.write(CharaData.MONEY);
			bw.close();
			
			
	} catch (FileNotFoundException e) {
		System.out.println(e);
	} catch (IOException e) {
		System.out.println(e);
	}
	}

}
