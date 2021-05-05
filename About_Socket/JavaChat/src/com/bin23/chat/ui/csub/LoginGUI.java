package com.bin23.chat.ui.csub;

import com.bin23.chat.client.Client;
import com.bin23.chat.ui.ClientGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LoginGUI extends JFrame {

    private LabelAndTextField labelAndTextField;
    private JButton button;
    private JPanel panel;

    public LoginGUI() {
        this.setSize(400, 400);
        this.setTitle("登录");
        panel = new JPanel();
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                Client.exit();
            }
        });
        this.add(panel);
        this.setVisible(true);
        this.reconstruct();
    }

    public void reconstruct() {
        panel.removeAll();
        LayoutManager layout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(layout);
        labelAndTextField = new LabelAndTextField(400, 30, "ID：");
        panel.add(Box.createVerticalGlue());
        panel.add(labelAndTextField);
        button = new JButton("确认");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String text = labelAndTextField.getTextField().getText();
                Client.login(text);
            }

        });
        panel.add(button);
        panel.add(Box.createVerticalGlue());
        panel.updateUI();
    }

    public void IDused() {
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
        LabelPanel.add(new JLabel("这个ID已经被使用了"));
        LabelPanel.add(Box.createHorizontalGlue());
        Panel.add(LabelPanel);
        Panel.add(Box.createVerticalGlue());
        JButton button = new JButton("确定");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
                reconstruct();
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
                reconstruct();
            }
        });
        dialog.setVisible(true);
    }
}
