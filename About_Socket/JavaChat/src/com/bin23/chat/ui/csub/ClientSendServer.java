package com.bin23.chat.ui.csub;

import com.bin23.chat.msg.MsgPackage;
import com.bin23.chat.msg.sub.Login;
import com.bin23.chat.msg.sub.Logout;
import com.bin23.chat.utils.OperationCode;

import java.io.OutputStream;
import java.net.Socket;

public class ClientSendServer extends Thread implements Runnable {
    private Socket socket;
    private MsgPackage msg;

    public ClientSendServer(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            OutputStream out = socket.getOutputStream();
            while (true) {
                if (this.isInterrupted()) {
                    return;
                }
                if (this.msg != null) {
                    out.write(msg.toByte());
                    this.msg = null;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendMsg(MsgPackage d) {
        this.msg = d;
    }

    public void login(String name) {
        MsgPackage Msg = new Login(OperationCode.LOGIN, name);
        sendMsg(Msg);
    }

    public void logout() {
        MsgPackage Msg = new Logout(OperationCode.LOGOUT, " ");
        sendMsg(Msg);
    }
}
