package com.zrl.d601;

import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class zrlCilent {
	public static void main(String[] args) {
		Socket socket = null;
		Scanner scan = new Scanner(System.in);
		try {
			socket = new Socket("0.0.0.0", 9876);
			OutputStream out = socket.getOutputStream();
			System.out.println("czs>");
			while (scan.hasNextLine()) {
				String s = scan.nextLine();
				if (s.equals("quit") || s.equals("exit")) {
					System.exit(1);
				}
				if (s.length() > 0) {
					out.write(s.getBytes());
					System.out.print("czschat>");

				}
			}
			socket.getOutputStream().write("czs".getBytes());
			System.in.read();

		} catch (Exception e) {

		} finally {

		}
	}
}

