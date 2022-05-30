package com.zrl.d528;
import com.zrl.d527.dao.zrlDao;

import java.sql.SQLException;

public class zrlsql {
	public static void main(String[]args) throws SQLException {
		System.out.println(zrlDao.getAny("select * from student"));
		System.out.println(zrlDao.getAny("select * from student where s_sex = '男'"));
		System.out.println(zrlDao.getAny("select * from score"));
		System.out.println(zrlDao.getAny("select * from course"));
		System.out.println(zrlDao.getAny("select stu.s_id,s_name,avg(s_score) pj from student stu join score scr where stu.s_id = scr.s_id group by stu.s_id,s_name"));

	}
}
