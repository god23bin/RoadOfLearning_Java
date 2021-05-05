package com.bin23.chat.msg.sub;

import com.bin23.chat.msg.MsgPackage;
import com.bin23.chat.server.MultiServer;
import com.bin23.chat.ui.csub.ClientReadServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Map;
import java.util.Set;

public class SendGroupMessage extends MsgPackage {

    public SendGroupMessage(byte OperationType, String Data) {
        super(OperationType, Data);
    }

    public SendGroupMessage(byte OperationType, byte[] Data) {
        super(OperationType, Data);
    }

    @Override
    public void multiServerSendMessage(MultiServer S) {
        //这是个用来让继承类重写的函数
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

    @Override
    public void readMsgFromServer(ClientReadServer C) {
        C.addGrounpMsg(this);
    }

}
