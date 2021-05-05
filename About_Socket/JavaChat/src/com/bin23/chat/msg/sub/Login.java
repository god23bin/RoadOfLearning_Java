package com.bin23.chat.msg.sub;

import com.bin23.chat.msg.MsgPackage;
import com.bin23.chat.server.MultiServer;

import java.io.UnsupportedEncodingException;

public class Login extends MsgPackage {

    public Login(byte OperationType, String Data) {
        super(OperationType, Data);
    }

    @Override
    public void multiServerSendMessage(MultiServer S) {
        //这是个用来让继承类重写的函数
        try {
            S.userRegister(new String(this.Data, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
