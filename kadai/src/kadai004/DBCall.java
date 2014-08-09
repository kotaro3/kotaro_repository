package kadai004;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DBCall {

	Statement stmt = null;
	Connection con = null;
	static ResultSet rs = null;
	String sql = "select * from exam004";
	String days;
	double maxC;
	double minC;
	double avg;
	static String maxD;
	static String minD;
	static String avgD;

	public DBCall() {

		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:exam004.db");
			System.out.println("接続完了");
			stmt = con.createStatement();

			System.out.println("unko");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void DataMax() {
		try {
			rs = stmt
					.executeQuery("select Day from exam004 where MAXdata = (select max(MAXdata) from exam004)");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm/dd");
			Date maxday = sdf.parse(rs.getString("Day"));
			maxD = rs.getString("Day");
			System.out.println("最大気温日：" + maxday);
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void DataMin() {
		try {
			rs = stmt
					.executeQuery("select Day from exam004 where MINdata = (select min(MINdata) from exam004)");
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/mm/dd");
			Date minday = sdf1.parse(rs.getString("Day"));
			minD = rs.getString("Day");
			System.out.println("最低気温日：" + minday);
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void DataAvg() {
		try {
			rs = stmt.executeQuery("select avg(AVGdata) from exam004");
			avgD = rs.getString("avg(AVGdata)");
			System.out.println("年間平均気温:" + rs.getFloat(1));
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void printData() {
		try {
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String days = rs.getString("Day");
				String maxC = rs.getString("MAXdata");
				String minC = rs.getString("MINdata");
				String avg = rs.getString("AVGdata");
				System.out.println(days + "|" + maxC + "|" + minC + "|" + avg);
			}
			rs.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void DBcreate() {

		try {
			stmt.executeUpdate("drop table if exists exam004");
			stmt.execute("create table exam004(Day String,MAXdata double,MINdata double,AVGdata double)");

			File csv = new File("hunabashi.csv");
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(new FileReader(csv));
			String s;

			while ((s = br.readLine()) != null) {
				String array[] = s.split(",");
				if (array.length != 4)
					throw new NumberFormatException();
				days = array[0];
				maxC = Double.parseDouble(array[1]);
				minC = Double.parseDouble(array[2]);
				avg = Double.parseDouble(array[3]);

				stmt.execute("insert into exam004 values('" + days + "'," + "'"
						+ maxC + "'," + "'" + minC + "'," + "'" + avg + "')");
				System.out.println(days + "|" + maxC + "|" + minC + "|" + avg);

			}
			br.close();
			stmt.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("csvファイル読み込みエラー");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void close() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
