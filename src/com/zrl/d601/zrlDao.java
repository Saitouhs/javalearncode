package com.zrl.d601;

import java.sql.*;


/**
 * @author mys
 * @version 1.0
 * @Description：
 * @date 2022/5/27 14:45
 */

public class zrlDao {
    private static Connection getConn() {
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://rm-bp11ur36179ijw890yo.mysql.rds.aliyuncs.com:3306/chat?serverTimezone=UTC", "saitou", "Aa114514@");
            //con = DriverManager.getConnection("jdbc:mysql://192.168.24.130:3306/mys1?serverTimezone=UTC", "root", "root");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return con;
    }



}



