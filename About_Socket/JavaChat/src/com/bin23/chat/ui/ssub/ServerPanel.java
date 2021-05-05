package com.bin23.chat.ui.ssub;

import com.bin23.chat.server.MultiServer;
import com.bin23.chat.ui.OnlineList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerPanel extends JPanel {
    private OnlineList L;
    private LayoutManager layout;

    public ServerPanel() {
        this.setMaximumSize(new Dimension(300, 500));
        this.setMinimumSize(new Dimension(300, 500));
        this.setPreferredSize(new Dimension(300, 500));
        layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        this.setLayout(layout);
        L = new OnlineList(MultiServer.getCurrentOnlineList(), 300, 400);
        this.add(L);
        JButton button = new JButton("踢人下线");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (L.selected()) {
                    String temp = L.getSelectedName();
                    MultiServer.forcedLogout(temp);
                }

            }

        });
        this.add(button);
    }
}
