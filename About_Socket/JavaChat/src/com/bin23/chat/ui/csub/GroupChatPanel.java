package com.bin23.chat.ui.csub;

import com.bin23.chat.client.Client;
import com.bin23.chat.msg.sub.SendGroupMessage;
import com.bin23.chat.ui.ClientGUI;
import com.bin23.chat.utils.Data;
import com.bin23.chat.utils.OperationCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GroupChatPanel extends JPanel {
    private JScrollPane Pane;
    private JTextArea GroupMessage;
    private LabelAndTextField Text;

    private int size_x;

    public GroupChatPanel() {
    }

    public GroupChatPanel(int size_x, int size_y) {
        this.setMaximumSize(new Dimension(size_x, size_y));
        this.setMinimumSize(new Dimension(size_x, size_y));
        this.setPreferredSize(new Dimension(size_x, size_y));
        GroupMessage = new JTextArea(7, 30);
        GroupMessage.setLineWrap(true);    //设置文本域中的文本为自动换行
        GroupMessage.setEditable(false);
        Pane = new JScrollPane(GroupMessage);
        Pane.setSize(size_x - 40, size_y - 40);
        this.size_x = size_x;
        this.reconstruct();
    }

    public void reconstruct() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.removeAll();
        this.add(Pane);
        GroupMessage.selectAll();
        Text = new LabelAndTextField(getSize_x() - 40, 20 , "");
        this.add(Text);
        this.updateUI();
    }

    public void addMessage(Data Msg) {
        GroupMessage.append(Msg.getName() + "\n");
        GroupMessage.append(Msg.getMsg() + "\n");
    }

    public JScrollPane getPane() {
        return Pane;
    }

    public void setPane(JScrollPane pane) {
        Pane = pane;
    }

    public JTextArea getGroupMessage() {
        return GroupMessage;
    }

    public void setGroupMessage(JTextArea groupMessage) {
        GroupMessage = groupMessage;
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
