package com.bin23.chat.msg;

import com.bin23.chat.client.Client;
import com.bin23.chat.server.MultiServer;
import com.bin23.chat.ui.csub.ClientReadServer;
import com.bin23.chat.ui.csub.ClientSendServer;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.Map;
import java.util.Set;

public class MsgPackage {
    private byte OperationType;
    public byte[] Data;

    public MsgPackage(byte OperationType, String Data) {
        this.OperationType = OperationType;
        try {
            this.Data = Data.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
    }

    public MsgPackage(byte OperationType, byte[] Data) {
        this.OperationType = OperationType;
        this.Data = Data;
    }

    public MsgPackage(byte Msg[]) {
        //拆包
        this.OperationType = Msg[0];
        this.Data = new byte[Msg.length - 2];
        for (int i = 2; i < Msg.length; i++) this.Data[i - 2] = Msg[i];
    }

    public byte[] toByte() {
        //打包
        byte[] temp = new byte[2 + Data.length];
        temp[0] = this.OperationType;
        temp[1] = 0;
        for (int i = 0; i < Data.length; i++) temp[i + 2] = Data[i];
        return temp;
    }

    public void multiServerSendMessage(MultiServer S) {
        //这是个用来让继承类重写的函数
        S.sendMessage(this);
    }

    public void sendMsgToServer(ClientSendServer C) {
        //这是个用来让继承类重写的函数
        C.sendMsg(this);
    }

    public void readMsgFromServer(ClientReadServer C) {
        //这是个用来让继承类重写的函数
    }

    public void reconstruct(byte[] Data) {
        //这是个用来让继承类重写的函数
        this.Data = Data;
    }

    public byte getOperationType() {
        return OperationType;
    }

    public void setOperationType(byte operationType) {
        OperationType = operationType;
    }

    public byte[] getData() {
        return Data;
    }

    public void setData(byte[] data) {
        Data = data;
    }
}








