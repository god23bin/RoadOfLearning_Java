package com.bin23.chat.server;

import com.bin23.chat.msg.MsgPackage;
import com.bin23.chat.msg.sub.*;
import com.bin23.chat.ui.ServerGUI;
import com.bin23.chat.utils.Data;
import com.bin23.chat.utils.OperationCode;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public class MultiServer implements Runnable {
    public static Map<String, Socket> map = new ConcurrentHashMap<>();
    public static Set<String> set = new HashSet<>();
    public static Map<Socket, MultiServer> MultiServerMap = new ConcurrentHashMap<>();
    private String name;
    private MsgPackage[] msgList;
    private Socket socket;
    private ServerGUI g;
    private MsgPackage Msg;

    public static Vector<String> getCurrentOnlineList() {
        Vector<String> temp = new Vector<String>();
        for (String s : set) {
            temp.add(s);
        }
        return temp;
    }

    public MultiServer() {
    }

    public MultiServer(Socket socket, ServerGUI g) {
        this.socket = socket;
        this.g = g;
        MultiServerMap.put(socket, this);
        msgList = new MsgPackage[10];
        msgList[1] = new Login(OperationCode.LOGIN, " ");
        msgList[2] = new SendMessage(OperationCode.SEND_MESSAGE, " ");
        msgList[3] = new Logout(OperationCode.LOGOUT, " ");
        msgList[4] = new ForcedLogoutMessage(OperationCode.FORCED_LOGOUT, " ");
        msgList[5] = new RefreshMessage(OperationCode.REFRESH_MESSAGE, " ");
        msgList[6] = new LoginSuccessMessage(OperationCode.LOGIN_SUCCESS_MESSAGE, " ");
        msgList[7] = new LoginFailedMessage(OperationCode.LOGIN_FAILED_MESSAGE, " ");
        msgList[8] = new SendGroupMessage(OperationCode.SEND_GROUP_MESSAGE, " ");
    }

    @Override
    public void run() {
        try {
            InputStream in = socket.getInputStream();
            int len;
            while (true) {
                byte b[];
                MsgPackage msg = null;
                b = new byte[2333];
                if ((len = in.read(b)) > 2) {
                    byte[] temp = new byte[len];
                    for (int i = 0; i < len; i++) temp[i] = b[i];
                    msgList[0] = new MsgPackage(temp);
                    msgList[msgList[0].getOperationType()].reconstruct(msgList[0].Data);
                    msg = msgList[msgList[0].getOperationType()];
                    msg.multiServerSendMessage(this);
                }
            }
        } catch (SocketException e) {
            userExit(socket);
            MultiServer.refresh();
            g.reconstruct();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void userRegister(String userName) {
        if (set.add(userName)) {
            loginSuccess();
            this.name = userName;
            map.put(userName, this.socket);
            MultiServer.refresh();
            g.reconstruct();
        } else loginFailed();
    }

    public static void refresh() {
        String temp = new String();
        for (String iterator : set) {
            temp += iterator;
            temp += ' ';
        }
        new RefreshMessage(OperationCode.REFRESH_MESSAGE, temp).multiServerSendMessage(new MultiServer());
        ;
    }

    public static void forcedLogout(String name) {
        if (MultiServer.map.get(name) != null) {
            MsgPackage Msg;
            Msg = new ForcedLogoutMessage(OperationCode.FORCED_LOGOUT, " ");
            Msg.multiServerSendMessage(MultiServer.MultiServerMap.get(MultiServer.map.get(name)));
            userExit(MultiServer.map.get(name));
            MultiServer.refresh();
        }
        Server.g.reconstruct();
    }

    private void loginFailed() {
        MsgPackage Msg;
        Msg = new LoginFailedMessage();
        Msg.multiServerSendMessage(this);
    }

    private void loginSuccess() {
        MsgPackage Msg;
        Msg = new LoginSuccessMessage();
        Msg.multiServerSendMessage(this);
    }

    public void sendMessage(MsgPackage Msg) {
        try {
            OutputStream out = this.socket.getOutputStream();
            out.write(Msg.toByte());
        } catch (IOException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }

    }

    public void forceSomeoneLogout() {

    }

    public static synchronized void userExit(Socket socket) {
        String userName = null;
        for (String key : map.keySet()) {
            if (map.get(key).equals(socket)) {
                userName = key;
                break;
            }
        }
        if (userName != null) {
            map.remove(userName, socket);
            set.remove(userName);
        }
    }

    public static void sendGroupMessage(String string, String text) {
        // TODO 自动生成的方法存根
        MsgPackage Msg = new SendGroupMessage(OperationCode.SEND_GROUP_MESSAGE, new Data(string, text).toByte());
        Msg.multiServerSendMessage(new MultiServer());
        Server.g.reconstruct();
    }

    public void sendSingleMessage(MsgPackage sendMessage) {
        String name = new Data(sendMessage.Data).getName();
        String msg = new Data(sendMessage.Data).getMsg();
        MultiServer temp = MultiServerMap.get(map.get(name));
        temp.sendMessage(new SendMessage(sendMessage.getOperationType(), new Data(this.name, msg).toByte()));
    }

    public static Map<String, Socket> getMap() {
        return map;
    }

    public static void setMap(Map<String, Socket> map) {
        MultiServer.map = map;
    }

    public static Set<String> getSet() {
        return set;
    }

    public static void setSet(Set<String> set) {
        MultiServer.set = set;
    }

    public static Map<Socket, MultiServer> getMultiServerMap() {
        return MultiServerMap;
    }

    public static void setMultiServerMap(Map<Socket, MultiServer> multiServerMap) {
        MultiServerMap = multiServerMap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MsgPackage[] getMsgList() {
        return msgList;
    }

    public void setMsgList(MsgPackage[] msgList) {
        this.msgList = msgList;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public ServerGUI getG() {
        return g;
    }

    public void setG(ServerGUI g) {
        this.g = g;
    }

    public MsgPackage getMsg() {
        return Msg;
    }

    public void setMsg(MsgPackage msg) {
        Msg = msg;
    }
}
