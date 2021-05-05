package com.bin23.chat.server;

import com.bin23.chat.ui.ServerGUI;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    public static ServerGUI g;

    public static void main(String[] args) {
        g = new ServerGUI();
        try {
            ServerSocket serverSocket = new ServerSocket(6666);
            ExecutorService executorService = Executors.newFixedThreadPool(20);
            while (true) {
                Socket socket = serverSocket.accept();
                executorService.execute(new MultiServer(socket, g));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
