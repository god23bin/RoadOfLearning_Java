package com.bin23.socket;

import com.bin23.entity.Student;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.Socket;

public class DServerThread extends Thread {
    Socket socket;

    public DServerThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        InputStream in = null;
        ObjectInputStream ois = null;
        OutputStream out = null;
        try {
            in = socket.getInputStream();
            ois = new ObjectInputStream(in);
            Object s = (Student)ois.readObject();
            System.out.println("接受到客户端发送的对象为："+s);
            socket.shutdownInput();

            out = socket.getOutputStream();
            out.write("我（服务器）已经收到你发送的对象了".getBytes());
            socket.shutdownOutput();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                if(out!=null)out.close();
                if(ois!=null)ois.close();
                if(in!=null)in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
