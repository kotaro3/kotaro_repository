package kadai004;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBCall {

	Statement stmt;
	Connection con = null;

	public DBCall() {

		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:exam004.db");
			System.out.println("接続完了");
			stmt = con.createStatement();
			stmt.executeUpdate("drop table if exists exam004");
			stmt.execute("create table exam004(Day String,MAX double,MIN double,AVG double)");
			System.out.println("unko");

		} catch (Exception e) {
			e.printStackTrace();
		}
		DBsave();

	}

	public static void main(String[] args) {
		new DBCall();

	}

	public void DBsave() {

		try {
			File csv = new File("hunabashi.csv");
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(new FileReader(csv));
			String s;

			while ((s = br.readLine()) != null) {
				String array[] = s.split(",");
				if (array.length != 4)
					throw new NumberFormatException();
				String days = array[0];
				double maxC = Double.parseDouble(array[1]);
				double minC = Double.parseDouble(array[2]);
				double avg = Double.parseDouble(array[3]);
				System.out.println(days + "|" + maxC + "|" + minC + "|" + avg);
				stmt.execute("insert into exam004 values('" + days + "'," + "'"
						+ maxC + "'," + "'" + minC + "'," + "'" + avg + "')");
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
