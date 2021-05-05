package com.bin23.chat.msg.sub;

import com.bin23.chat.msg.MsgPackage;
import com.bin23.chat.server.MultiServer;
import com.bin23.chat.ui.csub.ClientReadServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Map;
import java.util.Set;

public class RefreshMessage extends MsgPackage {

    public RefreshMessage(byte OperationType, String Data) {
        super(OperationType, Data);
        // TODO 自动生成的构造函数存根
    }

    @Override
    public void readMsgFromServer(ClientReadServer C) {
        C.refreshList(this.getData());
    }

    @Override
    public void multiServerSendMessage(MultiServer S) {
        Set<Map.Entry<String, Socket>> set = MultiServer.map.entrySet();
        for (Map.Entry<String, Socket> entry : set) {
            Socket client = entry.getValue();
            OutputStream out;
            try {
                out = client.getOutputStream();
                out.write(this.toByte());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
