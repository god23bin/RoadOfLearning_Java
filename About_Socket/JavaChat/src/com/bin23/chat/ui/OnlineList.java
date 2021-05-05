package com.bin23.chat.ui;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.Vector;

public class OnlineList extends JPanel {
    private Vector<String> nameList;
    private JTable table;
    private JScrollPane SP;

    public Vector<String> getNameList() {
        return nameList;
    }

    public void setNameList(Vector<String> nameList) {
        this.nameList = nameList;
    }

    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;
    }

    public JScrollPane getSP() {
        return SP;
    }

    public void setSP(JScrollPane SP) {
        this.SP = SP;
    }

    public OnlineList(Vector<String> namelist, int size_x, int size_y) {
        super();
        this.setMaximumSize(new Dimension(size_x, size_y));
        this.setMinimumSize(new Dimension(size_x, size_y));
        this.setPreferredSize(new Dimension(size_x, size_y));
        refreshList(namelist);
    }

    public void refreshList(Vector<String> nameList) {
        this.removeAll();
        LayoutManager layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        this.setLayout(layout);
        if (nameList.size() < 1) {
            nameList = new Vector<String>();
            nameList.add(" ");
        }
        this.setNameList(nameList);
        String[] Title = {"用户"};
        String[][] Text = new String[nameList.size()][1];
        for (int i = 0; i < nameList.size(); i++) Text[i][0] = nameList.elementAt(i);
        table = new JTable(Text, Title) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                action();
            }
        });
        SP = new JScrollPane(table);
        SP.setMaximumSize(new Dimension(300, 700));
        SP.setMinimumSize(new Dimension(300, 700));
        SP.setPreferredSize(new Dimension(300, 700));

        this.add(SP);
        this.updateUI();
    }

    protected void action() {
        //这是用于重写的方法

    }

    public boolean selected() {
        return table.getSelectedColumn() != -1;
    }

    public String getSelectedName() {
        return nameList.elementAt(table.getSelectedRow());
    }

    public void reconstruct() {

    }
}
