package com.bin23.socket;

import java.io.*;
import java.net.Socket;

public class MyClient {
    public static void main(String[] args) {

        Socket socket = null;
        OutputStream out = null;
        InputStream in = null;
        BufferedReader br = null;
        try {
            socket = new Socket("127.0.0.1",8888);
            System.out.println("客户端连接上了本地服务端");
            //通过Socket产生输入输出流，也就是数据流
            out = socket.getOutputStream();
            out.write("hello server".getBytes());
            socket.shutdownOutput();
            //接受服务端的反馈
            in = socket.getInputStream();
            br = new BufferedReader(new InputStreamReader(in));
            String info = null;
            while((info = br.readLine())!=null){
                System.out.println("I am client，接收的服务端消息是："+info);
            }
            socket.shutdownInput();

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(out!=null)out.close();
                if(in!=null)in.close();
                if(socket!=null)socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
