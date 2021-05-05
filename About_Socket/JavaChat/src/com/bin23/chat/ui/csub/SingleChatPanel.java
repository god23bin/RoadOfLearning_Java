package com.bin23.chat.ui.csub;

import com.bin23.chat.client.Client;
import com.bin23.chat.msg.sub.SendMessage;
import com.bin23.chat.ui.ClientGUI;
import com.bin23.chat.utils.Data;
import com.bin23.chat.utils.OperationCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class SingleChatPanel extends JPanel {
    private JScrollPane scrollPane;
    private JTextArea singleMessage;
    private Vector<Data> currentSingleChat;
    private LabelAndTextField Text;
    private int size_x;
    private int size_y;

    public SingleChatPanel() {
    }

    public SingleChatPanel(int size_x, int size_y) {
        this.setMaximumSize(new Dimension(size_x, size_y));
        this.setMinimumSize(new Dimension(size_x, size_y));
        this.setPreferredSize(new Dimension(size_x, size_y));
        singleMessage = new JTextArea(7, 30);
        singleMessage.setLineWrap(true);    //设置文本域中的文本为自动换行
        singleMessage.setEditable(false);
        scrollPane = new JScrollPane(singleMessage);
        scrollPane.setSize(size_x - 40, size_y - 40);
        this.size_x = size_x;
        this.reconstruct();
    }

    void reconstruct() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.removeAll();
        singleMessage = new JTextArea(7, 30);
        singleMessage.setLineWrap(true);    //设置文本域中的文本为自动换行
        singleMessage.setEditable(false);
        if (currentSingleChat != null) {
            for (int i = 0; i < currentSingleChat.size(); i++) {
                singleMessage.append(currentSingleChat.elementAt(i).getName() + "\n");
                singleMessage.append(currentSingleChat.elementAt(i).getMsg() + "\n");
            }
        }
        scrollPane = new JScrollPane(singleMessage);
        scrollPane.setSize(size_x - 40, size_y - 40);
        this.add(scrollPane);
        singleMessage.selectAll();
        Text = new LabelAndTextField(size_x - 40, 20, "");
        this.add(Text);
        this.updateUI();
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    public JTextArea getSingleMessage() {
        return singleMessage;
    }

    public void setSingleMessage(JTextArea singleMessage) {
        this.singleMessage = singleMessage;
    }

    public Vector<Data> getCurrentSingleChat() {
        return currentSingleChat;
    }

    public void setCurrentSingleChat(Vector<Data> currentSingleChat) {
        this.currentSingleChat = currentSingleChat;
    }

    public LabelAndTextField getText() {
        return Text;
    }

    public void setText(LabelAndTextField text) {
        Text = text;
    }

    public int getSize_x() {
        return size_x;
    }

    public void setSize_x(int size_x) {
        this.size_x = size_x;
    }
}