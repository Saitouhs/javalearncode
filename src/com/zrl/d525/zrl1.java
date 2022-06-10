package com.zrl.d525;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class zrl1 {

	public static void main(String[] args) throws SQLException, IOException {

		Connection conn=null;//127.0.0.1:
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javtest?serverTimezone=UTC","root","114514");
		//System.out.println(conn);
		System.in.read();

		java.sql.Statement st = conn.createStatement();

		/*st.executeUpdate("create table zrl1 (a decimal (10) ,b varchar(20)unique ,c decimal(8,2),primary key (a))");

		st.executeUpdate("insert into zrl1 values (1,'zs',111.2),(2,'ls',2222.2)");
		System.out.println(st.executeUpdate("insert into zrl1 values (3,'zs2',111.2),(4,'ls2',2222.2)"));
		System.out.println(st.executeUpdate("insert into zrl1 values (5,'zs5',111.2)"));*/

		System.out.println(st.executeUpdate("delete from zrl1 where 1>2"));
		System.out.println(st.executeUpdate("delete from zrl1 where 1<2"));

		/*java.sql.ResultSet rs = st.executeQuery("select * from zrl1");
		System.out.println("a\t|\tb\t|\tc");
		while (rs.next())
		{
			System.out.println(rs.getInt("a")+"\t|\t"+rs.getString("b")+"\t|\t"+rs.getFloat("c"));
		}
*/



	}
}
