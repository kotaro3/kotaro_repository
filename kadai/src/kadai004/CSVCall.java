package kadai004;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class CSVCall {
	public static void main(String args[]){
		try{
			File csv = new File("hunabashi.csv");
			BufferedReader br = new BufferedReader(new FileReader(csv));

			String line = "";
			while((line=br.readLine())!= null){

				StringTokenizer st = new StringTokenizer(line, ",");

		        while (st.hasMoreTokens()) {
		          System.out.print(st.nextToken() + "\t");
		        }
		        System.out.println();
		      }
		      br.close();

		    } catch (FileNotFoundException e) {
		      // Fileオブジェクト生成時の例外捕捉
		      e.printStackTrace();
		    } catch (IOException e) {
		      // BufferedReaderオブジェクトのクローズ時の例外捕捉
		      e.printStackTrace();
		    }
		  }
	public void setCsv(){

	}
		}