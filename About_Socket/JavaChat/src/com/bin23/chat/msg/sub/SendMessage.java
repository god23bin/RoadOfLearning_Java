package com.bin23.chat.msg.sub;

import com.bin23.chat.client.Client;
import com.bin23.chat.msg.MsgPackage;
import com.bin23.chat.server.MultiServer;
import com.bin23.chat.ui.csub.ClientReadServer;
import com.bin23.chat.ui.csub.ClientSendServer;
import com.bin23.chat.utils.Data;

public class SendMessage extends MsgPackage {
    public SendMessage(byte OperationType, String Data) {
        super(OperationType, Data);
    }

    public SendMessage(byte OperationType, byte[] Data) {
        super(OperationType, Data);
    }

    @Override
    public void multiServerSendMessage(MultiServer S) {
        S.sendSingleMessage(this);
    }

    @Override
    public void sendMsgToServer(ClientSendServer C) {
        C.sendMsg(this);
    }

}
