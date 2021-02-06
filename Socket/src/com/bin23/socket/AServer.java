package com.bin23.socket;

import com.bin23.entity.Student;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class AServer {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream in = null;
        ObjectInputStream ois = null;
        OutputStream out = null;
        try {
            serverSocket = new ServerSocket(8888);
            System.out.println("服务器启动，未有客户端连接");
            socket = serverSocket.accept();
            System.out.println("监听到客户端连接了");
            in = socket.getInputStream();
            ois = new ObjectInputStream(in);
            try {
                Object s = (Student)ois.readObject();
                System.out.println(s);
                socket.shutdownInput();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            out = socket.getOutputStream();
            out.write("我已经收到你（客户端）发送的对象了".getBytes());
            socket.shutdownOutput();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(out!=null)out.close();
                if(ois!=null)ois.close();
                if(in!=null)in.close();
                if(socket!=null)socket.close();
                if(serverSocket!=null)serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
