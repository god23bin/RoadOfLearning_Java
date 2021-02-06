package com.bin23.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class DServer {
    public static void main(String[] args) {

        ServerSocket serverSocket = null;
        Socket socket = null;
        try {
            serverSocket = new ServerSocket(8888);
            System.out.println("服务端已经开启，目前没有客户端连接上");
            int count = 1;
            while(true){
                socket = serverSocket.accept();
                System.out.println("有客户端连接，目前已连接过的个数为："+count);
                DServerThread dServerThread = new DServerThread(socket);
                dServerThread.start();
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(socket!=null)socket.close();
                if(serverSocket!=null)serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
