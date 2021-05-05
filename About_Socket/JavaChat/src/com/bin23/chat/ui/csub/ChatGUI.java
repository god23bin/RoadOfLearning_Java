package com.bin23.chat.ui.csub;

import com.bin23.chat.client.Client;
import com.bin23.chat.msg.sub.SendGroupMessage;
import com.bin23.chat.ui.ClientGUI;
import com.bin23.chat.ui.OnlineList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ChatGUI extends JFrame {
    public static JPanel f;
    public static ClientSendServer fThread;
    public static ChatPanel Chat;
    public static OnlineList online;
    public static String ListSelected = " ";

    public static void reconstruct() {
        f.removeAll();
//		ChatGUI.Chat.CurrentSingleChat=null;
        BoxLayout layout = new BoxLayout(f, BoxLayout.X_AXIS);
        f.setLayout(layout);
        online.refreshList(Client.getCurrentOnlineList());
        if (Client.map.get(ListSelected) == null) {
            ListSelected = " ";
            ChatGUI.Chat.setCurrentSingleChat(null);
        }
        f.add(online);
        Chat.reconsturct();
        f.add(Chat);
        f.updateUI();
    }

    public ChatGUI(String name) {
        super();
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                Client.exit();
            }
        });
        this.setTitle(name);
        Chat = new ChatPanel(300, 400);
        fThread = Client.send;
        this.setResizable(false);
        this.setSize(500, 450);
        f = new JPanel();
        this.add(f);
        BoxLayout layout = new BoxLayout(f, BoxLayout.X_AXIS);
        f.setLayout(layout);
        this.setVisible(true);
        this.reconstruct();
    }

    public static void AddGrounpMsg(SendGroupMessage sendGroupMessage) {
        Chat.addGrounpMsg(sendGroupMessage);

    }

    public void ForcedLogout() {
        JDialog dialog = new JDialog(this, true);
        dialog.setResizable(false);
        dialog.setAutoRequestFocus(true);
        dialog.setSize(200, 200);
        JPanel Panel = new JPanel();
        dialog.add(Panel);
        LayoutManager layout = new BoxLayout(Panel, BoxLayout.Y_AXIS);
        Panel.setLayout(layout);
        Panel.add(Box.createVerticalGlue());
        JPanel LabelPanel = new JPanel();
        LabelPanel.setLayout(new BoxLayout(LabelPanel, BoxLayout.X_AXIS));
        LabelPanel.add(Box.createHorizontalGlue());
        LabelPanel.add(new JLabel("服务器已将你移除"));
        LabelPanel.add(Box.createHorizontalGlue());
        Panel.add(LabelPanel);
        Panel.add(Box.createVerticalGlue());
        JButton button = new JButton("确定");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
                Client.exit();
            }

        });
        JPanel ButtonPanel = new JPanel();
        ButtonPanel.setLayout(new BoxLayout(ButtonPanel, BoxLayout.X_AXIS));
        ButtonPanel.add(Box.createHorizontalGlue());
        ButtonPanel.add(button);
        ButtonPanel.add(Box.createHorizontalGlue());
        Panel.add(ButtonPanel);
        Panel.add(Box.createVerticalGlue());
        dialog.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dialog.dispose();
                Client.exit();
            }
        });
        dialog.setVisible(true);
    }
}
