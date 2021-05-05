package com.bin23.chat.client;

import com.bin23.chat.ui.ClientGUI;
import com.bin23.chat.ui.csub.ClientReadServer;
import com.bin23.chat.ui.csub.ClientSendServer;
import com.bin23.chat.utils.Data;

import java.io.IOException;
import java.net.Socket;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public class Client {
    public static ClientGUI g;
    public static ClientSendServer send;
    public static ClientReadServer read;
    public static Set<String> set = new HashSet<>();
    public static Map<String, Vector<Data>> map = new ConcurrentHashMap<>();

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 6666);
        send = new ClientSendServer(socket);
        send.start();
        g = new ClientGUI();
        read = new ClientReadServer(socket);
        read.start();
    }

    public static void refresh() {
        g.reconstruct();
    }

    public static Vector<String> getCurrentOnlineList() {
        Vector<String> temp = new Vector<String>();
        for (String s : set) {
            temp.add(s);
        }
        return temp;
    }

    public static void loginFailed() {
        g.loginFailed();

    }

    public static void loginSuccess() {
        g.loginSuccess();

    }

    public static void login(String name) {
        send.login(name);
    }

    public static void forcedLogout() {
        g.forcedLogout();
    }

    public static void exit() {
        System.exit(0);
    }

    public static void addSingleMessage(Data Msg) {
        map.get(Msg.getName()).add(Msg);
    }
}
