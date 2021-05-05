package com.bin23.chat.ui;

import com.bin23.chat.msg.sub.SendGroupMessage;
import com.bin23.chat.ui.csub.ChatGUI;
import com.bin23.chat.ui.csub.LoginGUI;

import javax.swing.*;

public class ClientGUI extends JFrame {
    private LoginGUI login;
    private ChatGUI chat;
    private String name;

    public ClientGUI() {
        login = new LoginGUI();
    }

    public void reconstruct() {
        ChatGUI.reconstruct();
    }

    public void loginFailed() {
        login.IDused();
    }

    public void loginSuccess() {
        login.setVisible(false);
        chat = new ChatGUI(getName());
    }

    public void addGroupMsg(SendGroupMessage sendGroupMessage) {
        ChatGUI.AddGrounpMsg(sendGroupMessage);

    }

    public void forcedLogout() {
        chat.ForcedLogout();

    }

    public LoginGUI getLogin() {
        return login;
    }

    public void setLogin(LoginGUI login) {
        this.login = login;
    }

    public ChatGUI getChat() {
        return chat;
    }

    public void setChat(ChatGUI chat) {
        this.chat = chat;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
