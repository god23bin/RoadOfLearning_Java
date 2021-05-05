package com.bin23.chat.ui;

import com.bin23.chat.utils.Data;

import javax.swing.*;
import java.awt.*;

public class MsgPanel extends JPanel {
    private static Data[] msgQueue = new Data[8];
    private static int head = 0, tail = 0;

    public MsgPanel() {

    }

    public MsgPanel(int x, int y) {
        super();
        this.setSize(x, y);
    }

    public void addMsg(Data d) {
        msgQueue[tail] = d;
        tail = (tail + 1) % msgQueue.length;
        if (head == tail) head = (head + 1) % msgQueue.length;
        this.repaint();
    }

    public void paint(Graphics g) {
        int x = 20, y = 40;
        for (int i = head; i != tail; i = (i + 1) % msgQueue.length) {
            g.drawString(msgQueue[i].getName(), x, y);
            y += 30;
            g.drawString(msgQueue[i].getMsg(), x, y);
            y += 50;
        }
    }
}
