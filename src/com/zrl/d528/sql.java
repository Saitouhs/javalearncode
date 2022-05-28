package com.zrl.d528;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class sql {

	private static Connection getConn() {
		Connection con = null;
		try {//静态函数
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javtest?serverTimezone=UTC", "root", "114514");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return con;
	}

	public static Student[] getStus() {
		Student stu[] = null;
		try (Connection con = getConn()) {

			Statement st = con.createStatement();//查询
			ResultSet rs = st.executeQuery("drop table student");//结果
			int cnt = 0;//统计
			while (rs.next()) {
				cnt = rs.getInt(1);
			}//统计表内行数
			if (cnt == 0)
				return null;
			stu = new Student[cnt];//建立数组存储数据

			rs = st.executeQuery("select * from student");
			int i = 0;
			while (rs.next()) {
				Student s = new Student();
				s.setS_id(rs.getInt("s_id"));
				s.setS_name(rs.getString("s_name"));
				s.setS_brith(rs.getString("s_birth"));
				s.setS_sex(rs.getString("s_sex"));

				stu[i++] = s;//更新数据，后i+1
			}

		} catch (Exception e) {
			System.err.println();
		}
		return stu;
	}


	public static Course[] getScore(){
		Score scr[] = null;
		try (Connection con = getConn()) {
			Statement st = con.createStatement();//查询
			ResultSet rs = st.executeQuery("select count(*) from score");//结果
			int cnt = 0;//统计
			if (rs.next()) {
				cnt = rs.getInt(1);
			}//统计表内行数
			if (cnt == 0)
				return null;
			scr = new Score[cnt];//建立数组存储数据

			rs = st.executeQuery("select * from score");
			int i = 0;
			while (rs.next()) {
				Score s = new Score();
				s.setS_id(rs.getInt("s_id"));
				s.setS_score(rs.getInt("s_score"));
				s.setC_id(rs.getInt("c_id"));

				scr[i++] = s;//更新数据，后i+1
			}

		} catch (Exception e) {
			System.err.println();
		}
		return scr;

	}


	public static Course[] getCourse(){
		Course crs[] = null;
		try (Connection con = getConn()) {
			Statement st = con.createStatement();//查询
			ResultSet rs = st.executeQuery("select count(*) from course");//结果
			int cnt = 0;//统计
			if (rs.next()) {
				cnt = rs.getInt(1);
			}//统计表内行数
			if (cnt == 0)
				return null;
			crs = new Course[cnt];//建立数组存储数据

			rs = st.executeQuery("select * from score");
			int i = 0;
			while (rs.next()) {
				Course s = new Course();
				s.setT_id(rs.getInt("t_id"));
				s.setC_name(rs.getString("c_name"));
				s.setC_id(rs.getInt("c_id"));

				crs[i++] = s;//更新数据，后i+1
			}

		} catch (Exception e) {
			System.err.println();
		}
		return crs;

	}
}
