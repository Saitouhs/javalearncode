package com.zrl.d601;

import com.zrl.d528.ClientThread;
import com.zrl.d528.ipIllegal;
import com.zrl.d528.parameterFalut;
import com.zrl.d528.portIllegal;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static com.zrl.d530.zrlTcpUtil.isIp;
import static com.zrl.d601.mysUtil.isport;

public class zrlClient {

	public static void main(String[] args) throws IOException {
		int port = 0;
		String ipaddr;
		Socket socket = null;

		try {

			if (args.length != 2)
				throw new parameterFalut();
			else {
				ipaddr = args[0];
				port = isport(args[1]);
				if (!isIp(ipaddr)) {
					throw new ipIllegal(ipaddr);
				}

				socket = new Socket(ipaddr, port);
			}

		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("usage : needs parameter\nusage:java zrlTcpClient ipaddress port");
			return;
		} catch (portIllegal | ipIllegal | parameterFalut e) {
			System.err.println(e.getMessage() + "\nusage:java zrlTcpClient ipaddress port");
			return;
		} catch (UnknownHostException | NumberFormatException e) {
			System.err.println("ip address " + args[0] + " is illegal.\nPlease enter a valid IPv4 address.");
			return;
		} catch (ConnectException e) {
			System.err.println("Connection refused");
			System.err.println("Please start the service host.");
		}

		try {

			Scanner scanner = new Scanner(System.in);
			OutputStream out = socket.getOutputStream();
			new ClientThread(socket).start();
			while (scanner.hasNextLine()) {
				String s = scanner.nextLine();
				if (s.equals("exit") || s.equals("quit"))
					System.exit(1);
				if (s.length() > 0) {
					out.write(s.getBytes(StandardCharsets.UTF_8));
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());

		} finally {

		}
	}
}

