package kadai004;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.StringTokenizer;

public class GetData {

	public static void main(String[] args) throws ClassNotFoundException {
		Connection con = null;
		Class.forName("org.sqlite.JDBC");
		try {
			String csv = args.length > 0 ? args[0] : "hunabashi.csv";
			String table = args.length > 0 ? args[1] : "exam004";

			con = DriverManager.getConnection("jdbc:sqlite:exam004.db");
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(30);

			stmt.executeUpdate("create table if not exists "
					+ table
					+ "(uid integer UNIQUE,url string,contents string,value string)");

			try {
				FileInputStream fis = new FileInputStream(csv);
				InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
				@SuppressWarnings("resource")
				BufferedReader br = new BufferedReader(isr);
				String line = "";
				String insert = "";
				boolean header = true;

				while ((line = br.readLine()) != null) {
					StringTokenizer token = new StringTokenizer(line, ",");
					int column_queue = 0;

					while (token.hasMoreTokens()) {
						String tmpString = token.nextToken();
						System.out.println(tmpString);
						if (column_queue == 0) {
							insert += tmpString + " ,";

						} else if (column_queue <= 3) {
							insert += "\'" + tmpString + "\',";
						}
						column_queue++;
					}
					if (column_queue < 4) {
						while (column_queue < 4) {
							insert += "\'null\'.";
							column_queue++;
						}
					}
					if (header) {
						header = false;
					} else {
						insert = insert.substring(0, insert.length() - 2);
						insert = "insert or replace into " + table + " values("
								+ insert + ")";
						System.out.println(insert);
						stmt.executeUpdate(insert);
					}
					insert = "";
					System.out.println("--------------------------------");
				}

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			ResultSet rs = stmt.executeQuery("select * from " + table);
			while (rs.next()) {
				System.out.println("\t" + rs.getString("uid") + "\t"
						+ rs.getString("url") + "\t" + rs.getString("contents")
						+ "\t" + rs.getString("value"));
			}

		} catch (SQLException e) {
			System.err.println("exception:" + e.getMessage());
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				System.err.println(e);
			}
		}
	}

}
