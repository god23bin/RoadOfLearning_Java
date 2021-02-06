package com.bin23.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream in = null;
        BufferedReader br = null;
        OutputStream out = null;
        try {
            //1.准备服务端，ip，端口
            serverSocket = new ServerSocket(8888);
            //来一句准备完毕，可以接受监听客户端请求
            System.out.println("客户端未连接~");
            socket = serverSocket.accept();//一直阻塞，直到客户端连接成功
            System.out.println("有客户端连接，它成功连接了~");
            //2.通过Socket产生输入输出流
            in = socket.getInputStream();
            br = new BufferedReader((new InputStreamReader(in)));
            String info = null;
            while((info = br.readLine()) != null){
                System.out.println("I am server，收到的客户端信息是："+info);
            }
            socket.shutdownInput();
            //3.反馈一下给客户端
            out = socket.getOutputStream();
            out.write("welcome client".getBytes());

            socket.shutdownOutput();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(br!=null)br.close();
                if(out!=null)br.close();
                if(in!=null)br.close();
                if(socket!=null)br.close();
                if(serverSocket!=null)br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
