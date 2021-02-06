package com.bin23.socket;

import com.bin23.entity.Student;

import java.io.*;
import java.net.Socket;

public class DClient3 {
    public static void main(String[] args) {
        Socket socket = null;
        OutputStream out = null;
        ObjectOutputStream oos = null;
        InputStream in = null;
        BufferedReader br = null;
        try {
            socket = new Socket("localhost",8888);
            System.out.println("连接上服务器了");
            Student student = new Student(1009,"Antony",34);
            //把输出流包装成对象流
            out = socket.getOutputStream();
            oos = new ObjectOutputStream(out);
            //发送对象
            oos.writeObject(student);
            socket.shutdownOutput();

            in = socket.getInputStream();
            br = new BufferedReader(new InputStreamReader(in));
            String info = null;
            while((info = br.readLine())!=null){
                System.out.println("收到服务端消息："+info);
            }
            socket.shutdownInput();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(br!=null)br.close();
                if(in!=null)in.close();
                if(oos!=null)oos.close();
                if(out!=null)out.close();
                if(socket!=null)socket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
