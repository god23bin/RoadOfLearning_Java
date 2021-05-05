package com.bin23.chat.msg.sub;

import com.bin23.chat.msg.MsgPackage;
import com.bin23.chat.ui.csub.ClientReadServer;
import com.bin23.chat.utils.OperationCode;

public class LoginSuccessMessage extends MsgPackage {

    public LoginSuccessMessage() {
        super(OperationCode.LOGIN_SUCCESS_MESSAGE, " ");
    }

    public LoginSuccessMessage(byte OperationType, String Data) {
        super(OperationType, Data);
    }

    @Override
    public void readMsgFromServer(ClientReadServer C) {
        C.loginSuccess();
    }

}
