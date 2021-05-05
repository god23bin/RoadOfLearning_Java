package com.bin23.chat.ui.csub;

import com.bin23.chat.client.Client;
import com.bin23.chat.msg.sub.SendGroupMessage;
import com.bin23.chat.msg.sub.SendMessage;
import com.bin23.chat.ui.ClientGUI;
import com.bin23.chat.ui.OnlineList;
import com.bin23.chat.utils.Data;
import com.bin23.chat.utils.OperationCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class ChatPanel extends JPanel {
    private GroupChatPanel groupChatPanel;
    private Vector<Data> currentSingleChat;
    private SingleChatPanel singleChat;
    private int size_x, size_y;

    public ChatPanel(int size_x, int size_y) {
        this.setMaximumSize(new Dimension(size_x, size_y));
        this.setMinimumSize(new Dimension(size_x, size_y));
        this.setPreferredSize(new Dimension(size_x, size_y));
        this.size_x = size_x;
        this.size_y = size_y;
        groupChatPanel = new GroupChatPanel(size_x, size_y / 2);
        singleChat = new SingleChatPanel(size_x, size_y / 2);
        OnlineList online = new OnlineList(Client.getCurrentOnlineList(), 200, size_y) {
            @Override
            protected void action() {
                reconstruct();
            }

            public void reconstruct() {
                int temp = this.getTable().getSelectedRow();
                if (temp != -1) {
                    String name = Client.getCurrentOnlineList().elementAt(temp);
                    currentSingleChat = Client.map.get(name);
                }
                ChatGUI.reconstruct();
            }
        };
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(groupChatPanel);
        this.add(singleChat);
        // TODO 自动生成的构造函数存根
    }

    public synchronized void reconsturct() {
        groupChatPanel.reconstruct();
        singleChat.reconstruct();
        this.updateUI();
    }





    public void addGrounpMsg(SendGroupMessage sendGroupMessage) {
        groupChatPanel.addMessage(new Data(sendGroupMessage.Data));

    }

    public GroupChatPanel getGroupChatPanel() {
        return groupChatPanel;
    }

    public void setGroupChatPanel(GroupChatPanel groupChatPanel) {
        this.groupChatPanel = groupChatPanel;
    }

    public Vector<Data> getCurrentSingleChat() {
        return currentSingleChat;
    }

    public void setCurrentSingleChat(Vector<Data> currentSingleChat) {
        this.currentSingleChat = currentSingleChat;
    }

    public SingleChatPanel getSingleChat() {
        return singleChat;
    }

    public void setSingleChat(SingleChatPanel singleChat) {
        this.singleChat = singleChat;
    }

    public int getSize_x() {
        return size_x;
    }

    public void setSize_x(int size_x) {
        this.size_x = size_x;
    }

    public int getSize_y() {
        return size_y;
    }

    public void setSize_y(int size_y) {
        this.size_y = size_y;
    }
}
