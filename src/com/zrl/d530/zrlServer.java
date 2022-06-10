package com.zrl.d530;

import com.zrl.d528.SreverThread;
import com.zrl.d528.parameterFalut;
import com.zrl.d528.portIllegal;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

import static com.zrl.d601.mysUtil.isport;

class ClientThread implements Runnable {
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

public class zrlServer{
        public static void main(String[] args) throws IOException {
            int port = 0;
            ServerSocket serverSocket = null;
            try {
                port = port = isport(args[0]);
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
                    new Thread(new  SreverThread(lstSocket, socket)).start();
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
}

