package com.zrl.d525;
import java.io.BufferedReader;
import java.sql.*;
import java.util.Scanner;

public class zrl2 {
	public static void main(String[] args) throws SQLException {
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://rm-bp11ur36179ijw890yo.mysql.rds.aliyuncs.com:3306/student?serverTimezone=UTC", "saitou", "Aa114514@");
			java.sql.Statement st = con.createStatement();

			Scanner scanner = new Scanner(System.in);

			st.executeUpdate("set sql_mode ='STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' ");
			System.out.print("zrlsql>");
			while (!scanner.equals(';')) {
				String sql = scanner.nextLine();
				if (sql.equals("quit") || sql.equals("exit"))
					System.exit(1);
				if (sql.length() > 5) {
					try {
						if (sql.startsWith("select")) {
							//System.out.println("query dbs..............");
							java.sql.ResultSet rs = st.executeQuery(sql);
							//sql text
							ResultSetMetaData md = rs.getMetaData();
							int fldcnt = md.getColumnCount();
							for (int i = 1; i <= fldcnt; i++) {
								System.out.print(md.getColumnLabel(i) + "\t\t\t\t");
							}
							System.out.println();
							while (rs.next()) {
								for (int i = 1; i <= fldcnt; i++) {
									System.out.print(rs.getString(i)+"\t\t\t\t");
								}
								System.out.println();
							}
						} else {
							//System.out.println("DDL/DML [INSERT|DELETE|UPDATE|..]........");
							st.executeUpdate(sql);
						}
					} catch (Exception e) {
						System.err.println(e.getMessage());
					}
					System.out.print("zrlsql>");
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			if (con != null)
				con.close();
		}
	}
}
