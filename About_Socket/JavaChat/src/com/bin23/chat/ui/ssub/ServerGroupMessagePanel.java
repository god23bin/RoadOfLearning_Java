package com.bin23.chat.ui.ssub;

import com.bin23.chat.server.MultiServer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerGroupMessagePanel extends JPanel {
    private LayoutManager layout;
    private JPanel SPPanel;
    private JTextField Text;

    public ServerGroupMessagePanel() {
        SPPanel = new JPanel();
        SPPanel.setSize(300, 400);
        this.setMaximumSize(new Dimension(300, 500));
        this.setMinimumSize(new Dimension(300, 500));
        this.setPreferredSize(new Dimension(300, 500));
        layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        this.setLayout(layout);
        Text = new JTextField();
        Text.setSize(500, 30);
        Text.setPreferredSize(new Dimension(500, 30));
        Text.setMaximumSize(new Dimension(500, 30));
        this.add(SPPanel);
        JLabel label = new JLabel("群发消息");
        this.add(label);
        this.add(Text);
        JButton button = new JButton("确认");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (!Text.getText().isEmpty()) {
                    MultiServer.sendGroupMessage("服务器消息", Text.getText());
                }

            }

        });
        this.add(button);
    }
}
