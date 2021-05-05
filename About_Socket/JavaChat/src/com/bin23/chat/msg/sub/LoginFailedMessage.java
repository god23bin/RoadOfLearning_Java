package com.bin23.chat.msg.sub;

import com.bin23.chat.msg.MsgPackage;
import com.bin23.chat.ui.csub.ClientReadServer;
import com.bin23.chat.utils.OperationCode;

public class LoginFailedMessage extends MsgPackage {

    public LoginFailedMessage() {
        super(OperationCode.LOGIN_FAILED_MESSAGE, " ");
    }

    public LoginFailedMessage(byte OperationType, String Data) {
        super(OperationType, Data);
    }

    @Override
    public void readMsgFromServer(ClientReadServer C) {
        C.loginFailed();
    }

}
