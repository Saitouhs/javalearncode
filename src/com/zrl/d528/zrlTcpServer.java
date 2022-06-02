package com.zrl.d528;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;


public class zrlTcpServer {
	public static void main(String[] args) throws IOException {
		int port = 0;
		ServerSocket serverSocket = null;
		try {
			port = Integer.parseInt(args[0]);
			if (port > 9000 || port < 5000)
				throw new portIllegal(port);
			if (args.length > 1)
				throw new parameterFalut();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("needs parameter: port\nusage:java zrlTcpServer port");
			return;
		} catch (NumberFormatException e) {
			System.err.println("please input a port \nusage:java zrlTcpServer port");
		} catch (portIllegal | parameterFalut e) {
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
