package com.bin23.chat.msg.sub;

import com.bin23.chat.msg.MsgPackage;
import com.bin23.chat.server.MultiServer;

public class Logout extends MsgPackage {

    public Logout(byte OperationType, String Data) {
        super(OperationType, Data);
    }

    @Override
    public void multiServerSendMessage(MultiServer S) {
        MultiServer.userExit(S.getSocket());
    }

}
