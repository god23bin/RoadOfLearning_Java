package com.bin23.chat.ui;

import com.bin23.chat.ui.ssub.ServerGroupMessagePanel;
import com.bin23.chat.ui.ssub.ServerPanel;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ServerGUI extends JFrame {
    private MsgPanel msgPanel;
    private JPanel panel;
    private ServerPanel S;
    private ServerGroupMessagePanel G;

    public ServerGUI() {
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        panel = new JPanel();
        this.setResizable(false);
        this.setSize(600, 500);
        this.setTitle("服务器端");
        this.add(panel);
        BoxLayout layout = new BoxLayout(panel, BoxLayout.X_AXIS);
        panel.setLayout(layout);
        S = new ServerPanel();
        panel.add(S);
        G = new ServerGroupMessagePanel();
        panel.add(G);
        this.setVisible(true);
    }

    public void reconstruct() {
        panel.removeAll();
        BoxLayout layout = new BoxLayout(panel, BoxLayout.X_AXIS);
        panel.setLayout(layout);
        S = new ServerPanel();
        panel.add(S);
        G = new ServerGroupMessagePanel();
        panel.add(G);
        panel.updateUI();
    }
}
