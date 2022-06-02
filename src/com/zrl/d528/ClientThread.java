package com.zrl.d528;

import java.net.Socket;

public class ClientThread extends Thread {
	private Socket socket;

	public ClientThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		byte b[] = new byte[300];
		while (true) {
			try {
				int len = socket.getInputStream().read(b);
				System.out.println("\t\t\t\t\t\t\t\t\t^-^:" + new String(b, 0, len));
			} catch (Exception e) {
				return;
			} finally {

			}
		}
	}
}
