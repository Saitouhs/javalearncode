package com.zrl.d528;

import java.io.IOException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class zrlTcpClient {

	public static void main(String[] args) throws IOException {
		Socket socket = null;
		try {
			socket = new Socket("0.0.0.0",5678);
			socket.getOutputStream().write("zrl".getBytes(StandardCharsets.UTF_8));
			System.in.read();
		} catch (Exception e) {

		} finally {

		}
	}
}
