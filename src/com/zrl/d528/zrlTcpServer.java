package com.zrl.d528;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class zrlTcpServer {
	public static void main(String []args) throws IOException {
		ServerSocket serverSocket =null;
		try{
			serverSocket=new ServerSocket(9876);
			byte b[]=new byte[30];
			while (true){
				Socket socket = serverSocket.accept();//链接
				System.out.println(socket);
				int len = socket.getInputStream().read(b);
				System.out.println(len);
				System.out.println(new String(b,0,len));
			}
		}catch (Exception e){

		}finally {
			serverSocket.close();
		}
	}
}
