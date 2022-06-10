package com.zrl.d602;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.zrl.d527.dao.zrlDao.getConn;

public class sqllock {
	public static void main(String[] args) throws SQLException {
		Connection con = null;
		try{
			con=getConn();
			Statement st = con.createStatement();//查询
			con.setAutoCommit(false);
			String sql = " update bank set bankmoney=bankmoney+1000 where bankid=60201;";
			st.executeUpdate(sql);
			sql = " update bank set bankmoney=bankmoney-1000 where bankid=60200;";
			st.executeUpdate(sql);
			con.commit();
			ResultSet rs = st.executeQuery("select * from bank");
			while (rs.next())
				System.out.println(rs.getInt("bankid")+"\t\t"+rs.getString("bankname")+"\t\t"+ rs.getInt("bankmoney"));
		} catch (SQLException e) {
			con.rollback();
		}

	}
}
