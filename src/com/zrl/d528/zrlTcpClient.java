package com.zrl.d528;


import java.io.IOException;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static com.zrl.d530.zrlTcpUtil.*;



class portIllegl extends Exception {
	public portIllegl(int port) {
		super("port " + port + " is illegal.\nPlease enter a value between 5000 and 9000.\n");
	}
}

class parameterFalut extends Exception {
	public parameterFalut() {
		super("Parameter number error.\nPlease check your input.");
	}
}

class ipIllegal extends Exception {
	public ipIllegal(String s) {
		System.err.println("ip address " + s + " is illegal.\nPlease enter a valid IPv4 address.");
	}
}

class CilentThread extends Thread {
	private Socket socket;

	public CilentThread(Socket socket) {
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


public class zrlTcpClient {

	public static void main(String[] args) throws IOException {
		int port = 0;
		String ipaddr;
		Socket socket = null;

		try {

			if (args.length != 2)
				throw new parameterFalut();
			else {
				ipaddr = args[0];
				port = Integer.parseInt(args[1]);
				if (port > 9000 || port < 5000)
					throw new portIllegl(port);
				else if (!isPort(ipaddr)) {
					throw new ipIllegal(ipaddr);
				}

				socket = new Socket(ipaddr, port);
			}

		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("usage : needs parameter\nusage:java zrlTcpClient ipaddress port");
			return;
		} catch (portIllegl  |ipIllegal | parameterFalut e) {
			System.err.println(e.getMessage() + "\nusage:java zrlTcpClient ipaddress port");
			return;
		} catch (UnknownHostException |NumberFormatException  e) {
			System.err.println("ip address " + args[0] + " is illegal.\nPlease enter a valid IPv4 address.");
			return;
		} catch (ConnectException e) {
			System.err.println("Connection refused");
			System.err.println("Please start the service host.");
		}

		try {

			Scanner scanner = new Scanner(System.in);
			OutputStream out = socket.getOutputStream();
			new CilentThread(socket).start();
			//System.out.print("zrlchat>");
			while (scanner.hasNextLine()) {
				String s = scanner.nextLine();
				if (s.equals("exit") || s.equals("quit"))
					System.exit(1);
				if (s.length() > 0) {
					out.write(s.getBytes(StandardCharsets.UTF_8));
					//System.out.print("zrlchat>");
				}
			}
		}catch (Exception e){
			//System.err.println(e.getMessage());

		} finally {

		}
	}

}
