package com.zrl.d528;

import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Vector;

public class SreverThread extends Thread {

	private Socket socket;
	private Vector<Socket> lstSocket;

	public SreverThread(Vector<Socket> lstSocket, Socket socket) {
		this.socket = socket;
		this.lstSocket = lstSocket;
	}

	@Override
	public void run() {
		byte[] b = new byte[30];
		while (true) {
			try {
				int len = socket.getInputStream().read(b);
				String msg = new String(b, 0, len);

				Connection con = null;
				try {
					con = DriverManager.getConnection("jdbc:mysql://rm-bp11ur36179ijw890yo.mysql.rds.aliyuncs.com:3306/chat?serverTimezone=UTC", "saitou", "Aa114514@");
					java.sql.Statement st = con.createStatement();
					String sql = "insert into msginfo(clientid,msg,msgdate) values (\" " + socket.getRemoteSocketAddress().toString() + "\",\"" + msg + "\",now()); ";
					st.executeUpdate(sql);
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}

				for (Socket skt : lstSocket) {
					if (skt == socket) continue;
					skt.getOutputStream().write(b, 0, len);
				}

			} catch (Exception e) {
				return;
			}
		}
	}
}
