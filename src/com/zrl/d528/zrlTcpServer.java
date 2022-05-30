package com.zrl.d528;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Vector;



class SreverThread extends Thread {

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
					String sql = "insert into msginfo(clientid,msg,msgdate) values (\" " + socket.getRemoteSocketAddress().toString()+ "\",\"" + msg + "\",now()); ";
					st.executeUpdate(sql);
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}

				for (Socket skt : lstSocket) {
					if (skt==socket) continue;
					skt.getOutputStream().write(b, 0, len);
				}

			} catch (Exception e) {
				return;
			}
		}
	}
}

public class zrlTcpServer {
	public static void main(String[] args) throws IOException {
		int port = 0;
		ServerSocket serverSocket = null;
		try {
			port = Integer.parseInt(args[0]);
			if (port > 9000 || port < 5000)
				throw new portIllegl(port);
			if (args.length > 1)
				throw new parameterFalut();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("needs parameter: port\nusage:java zrlTcpServer port");
			return;
		} catch (NumberFormatException e) {
			System.err.println("please input a port \nusage:java zrlTcpServer port");
		} catch (portIllegl | parameterFalut e) {
			System.err.println(e.getMessage());
			System.err.println("usage:java zrlTcpServer port");
			return;
		}

		try {
			serverSocket = new ServerSocket(port);
			Vector<Socket> lstSocket = new Vector<Socket>();
			while (true) {
				Socket socket = serverSocket.accept();//链接
				lstSocket.add(socket);
				System.out.println(socket.getRemoteSocketAddress());
				new SreverThread(lstSocket, socket).start();
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
