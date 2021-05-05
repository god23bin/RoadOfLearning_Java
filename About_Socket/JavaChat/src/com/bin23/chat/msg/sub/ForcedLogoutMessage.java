package com.bin23.chat.msg.sub;

import com.bin23.chat.client.Client;
import com.bin23.chat.msg.MsgPackage;
import com.bin23.chat.ui.csub.ClientReadServer;

public class ForcedLogoutMessage extends MsgPackage {

    public ForcedLogoutMessage(byte OperationType, String Data) {
        super(OperationType, Data);
    }

    @Override
    public void readMsgFromServer(ClientReadServer C) {
        super.readMsgFromServer(C);
    }

}
