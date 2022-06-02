package com.zrl.d601;

import com.zrl.d528.SreverThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class zrlServer extends Thread{
    private Socket socket;

    public zrlServer(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run(){

        byte b[]=new byte[300];
        while (true){
            try {
                int len=socket.getInputStream().read(b);
                System.out.println(len);
                System.out.println(new String(b,0,len));
            }catch (Exception e){
                System.err.println(e.getMessage());
                return;
            }
        }
    }
}
class servers {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8978);
            while (true) {
                Socket socket = serverSocket.accept();//

                Vector<Socket> lstSocket = new Vector<Socket>();
                System.out.println(socket.getRemoteSocketAddress());

                System.out.println(socket.getRemoteSocketAddress());
                new SreverThread(lstSocket, socket).start();
            }
        } catch (Exception e) {
            //TODO:handle exception
        } finally {

        }
    }
}

