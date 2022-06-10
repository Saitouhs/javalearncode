package com.zrl.d530;

import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class zrlDao {
	private static String zrldriver;
	private static String zrlurl;
	private static String zrluser;
	private static String zrlpass;


	static {
		FileReader fr = null;
		Properties pro = null;
		try {
			String filename = zrlDao.class.getResource("").getPath() + "Dao.properties";
			System.out.println(filename);
			fr = new FileReader(filename);
			pro = new Properties();
			pro.load(fr);
			zrldriver = pro.getProperty("zrldriver");
			zrlurl = pro.getProperty("zrlurl");
			zrluser = pro.getProperty("zrluser");
			zrlpass = pro.getProperty("zrlpass");
			System.out.println(zrlpass);

		} catch (Exception e) {

		} finally {

		}
	}

	private static Connection getConn() {

		Connection con = null;
		try {
			Class.forName(zrldriver);
			con = DriverManager.getConnection(zrlurl, zrluser, zrlpass);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		return con;
	}

}



