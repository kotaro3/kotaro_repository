package kadai004;

import java.io.*;
import java.sql.*;

public class DBcmd {

	public static void main(String[] args) throws ClassNotFoundException{
		Class.forName("org.sqlite.JDBC");
		Connection con = null;
		String csv = args.length > 0 ? args[0] : "hunabashi.csv";
		String table = args.length > 0 ? args[1] : "exam004";
		try {
			con = DriverManager.getConnection("jdbc:sqlite.exam004.db");
			Statement stmt = con.createStatement();

			stmt.executeUpdate("create table if not exists " + table
					+ " (uid integer UNIQUE,"
					+ " url string, contents string, value string)");
			FileInputStream fis = new FileInputStream(csv);
			InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
			BufferedReader br = new BufferedReader(isr);
			String line = "";
			String insert = "";
			while ((line = br.readLine()) != null) {
				insert = line;
			}
			br.close();
			stmt.executeUpdate(insert);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				System.err.println(e);
			}

		}

	}

}
