package com.bin23.chat.ui.csub;

import com.bin23.chat.client.Client;
import com.bin23.chat.msg.MsgPackage;
import com.bin23.chat.msg.sub.*;
import com.bin23.chat.utils.Data;
import com.bin23.chat.utils.OperationCode;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

public class ClientReadServer extends Thread implements Runnable {
    private Socket socket;
    private MsgPackage[] msgList;

    public ClientReadServer(Socket socket) {
        msgList = new MsgPackage[10];
        msgList[1] = new Login(OperationCode.LOGIN, " ");
        msgList[2] = new SendMessage(OperationCode.SEND_MESSAGE, " ");
        msgList[3] = new Logout(OperationCode.LOGOUT, " ");
        msgList[4] = new ForcedLogoutMessage(OperationCode.FORCED_LOGOUT, " ");
        msgList[5] = new RefreshMessage(OperationCode.REFRESH_MESSAGE, " ");
        msgList[6] = new LoginSuccessMessage(OperationCode.LOGIN_SUCCESS_MESSAGE, " ");
        msgList[7] = new LoginFailedMessage(OperationCode.LOGIN_FAILED_MESSAGE, " ");
        msgList[8] = new SendGroupMessage(OperationCode.SEND_GROUP_MESSAGE, " ");
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream in = socket.getInputStream();
            byte b[] = new byte[2333];
            int len;
            while (true) {
                if (this.isInterrupted()) {
                    return;
                }
                len = in.read(b);
                byte[] temp = new byte[len];
                for (int i = 0; i < len; i++) temp[i] = b[i];
                MsgPackage Msg = new MsgPackage(temp);
                msgList[Msg.getOperationType()].reconstruct(Msg.Data);
                msgList[Msg.getOperationType()].readMsgFromServer(this);
                System.out.println((int) Msg.getOperationType());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addGrounpMsg(SendGroupMessage sendGroupMessage) {
        Client.g.addGroupMsg(sendGroupMessage);
    }

    public void loginSuccess() {
        Client.loginSuccess();

    }

    public void loginFailed() {
        Client.loginFailed();

    }

    public void refreshList(byte[] Data) {
        try {
            String tot = new String(Data, "UTF-8");
            Vector<String> namelist = new Vector<String>();
            String[] ll = tot.split(" ");
            for (int i = 0; i < ll.length; i++) namelist.add(ll[i]);
            Set<Map.Entry<String, Vector<Data>>> mapset = Client.map.entrySet();
            for (Map.Entry<String, Vector<Data>> entry : mapset) {
                boolean exist = false;
                for (String name : namelist) {
                    if (entry.getKey().equals(name)) exist = true;
                }
                if (!exist) {
                    Client.map.remove(entry.getKey());
                }
            }
            for (String name : namelist) {
                if (!Client.map.containsKey(name)) {
                    Client.map.put(name, new Vector<Data>());
                }
            }
            Client.set.clear();
            for (int i = 0; i < ll.length; i++) Client.set.add(ll[i]);
            Client.refresh();
        } catch (UnsupportedEncodingException e1) {
            // TODO 自动生成的 catch 块
            e1.printStackTrace();
        }

    }
}
